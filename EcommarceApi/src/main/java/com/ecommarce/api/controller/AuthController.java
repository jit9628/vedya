package com.ecommarce.api.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;
import org.springframework.web.servlet.ModelAndView;

import com.ecommarce.api.CheckAuthenticateUser;
import com.ecommarce.api.FileUploadHelper;
import com.ecommarce.api.LogoutSuccessHandlers;
import com.ecommarce.api.dao.UserDao;
import com.ecommarce.api.entity.ERole;
import com.ecommarce.api.entity.Role;
import com.ecommarce.api.entity.User;
import com.ecommarce.api.repo.RoleRepository;
import com.ecommarce.api.repo.UserRepository;
import com.ecommarce.api.request.LoginRequest;
import com.ecommarce.api.request.SignupRequest;
import com.ecommarce.api.security.jwt.JwtUtils;
import com.ecommarce.api.service.AddToCartService;
import com.ecommarce.api.service.UserDetailsImpl;
import com.ecommarce.api.service.UserImageFileService;
import com.ecommarce.api.utility.RandomStringValue;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:8005")
@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {
//	private SecurityContextRepository securityContextRepository = new HttpSessionSecurityContextRepository();
//	private SecurityContextHolderStrategy securityContextHolderStrategy = SecurityContextHolder
//			.getContextHolderStrategy();
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private LogoutSuccessHandlers loginsuccess;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private JwtUtils jwtUtils;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private CheckAuthenticateUser checkAuthenticateUser;
	@Autowired
	private AddToCartService addToCartService;
	@Autowired
	private UserImageFileService userImageFileService;
	@Autowired
	private FileUploadHelper helper;
	@Autowired
	private UserDao userDao;

//	@Autowired
//	Utils utils;
	@SuppressWarnings("unlikely-arg-type")
	@PostMapping("/signin")
	public ModelAndView authenticateUser(@ModelAttribute("loginRequest") LoginRequest loginRequest,
			HttpServletRequest request, HttpServletResponse response, ModelAndView mv)
			throws IOException, ServletException {

		boolean isNotValid = true;
		String isAuthenticate = "true";

		try {
			Optional<User> findByEmail = this.userRepository.findByEmail(loginRequest.getUsername());
			log.info("user is exists  :: " + findByEmail);
			if (findByEmail != null) {
				Authentication authentication = authenticationManager
						.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
								loginRequest.getPassword()));
				log.info("user authentication is :: " + authentication.isAuthenticated());
				UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal(); // all user details
				log.info("user userDetails is :: " + userDetails.getId());
				List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
						.collect(Collectors.toList());
				log.info("Roles of Zero Position " + roles.get(0));
				log.info("Roles is " + roles);
				String generateJwtToken = jwtUtils.generateJwtToken(authentication);
//				org.springframework.security.core.context.SecurityContext createEmptyContext = securityContextHolderStrategy
//						.createEmptyContext();
//				
//				log.debug("Empty Context  is ::" + createEmptyContext);
//				securityContextHolderStrategy.setContext(createEmptyContext);
//				createEmptyContext.setAuthentication(authentication);
//				log.debug("After Set Authentication ::" + createEmptyContext.getAuthentication());
//				log.debug("Authenticate user1 is ::" + createEmptyContext.getAuthentication().getPrincipal());
//				Authentication authentication2 = securityContextHolderStrategy.getContext().getAuthentication();
//				log.debug("Authenticate user2 is ::" + authentication2.getPrincipal());
//				securityContextRepository.saveContext(createEmptyContext, request, response);
				// Authentication authentication2 =
				// securityContextHolderStrategy.getContext().getAuthentication();
//				if (authentication2 != null || authentication2 instanceof AnonymousAuthenticationToken) {

				/* ============== check authentication ========= */
				checkAuthenticateUser.setAuthenticationSecurityContext(authentication, request, response);
String chekRole = checkAuthenticateUser.chekRole();
System.out.println("Your Role Is ::"+chekRole);
				if (roles.get(0) == "ROLE_ADMIN") {
					log.info("ADMIN Proccess");
					HttpSession session = request.getSession();
					session.setAttribute("auth", authentication);
					session.setAttribute("userid", userDetails.getId());
					//session.setAttribute("role", roles.get(0));
					isNotValid = false;
					mv.setViewName("redirect:/api/auth/admindashboard");
					return mv;
				}
				if (roles.get(0) == "ROLE_USER") {
					// Authentication auth = SecurityContextHolder.getContext().getAuthentication();
					HttpSession session = request.getSession();
					// session.setAttribute("auth", userDetails.getUsername());
					session.setAttribute("auth", authentication);
					session.setAttribute("userid", userDetails.getId());
					session.setAttribute("username", userDetails.getEmail());
					log.info("UserName Is ::" + userDetails.getUsername());
					//session.setAttribute("role", roles.get(0));
					session.setAttribute("firstname", findByEmail.get().getFirstname());
					log.info("User Proccess");

					log.info("Get The Image Picture From Session ::" + session.getAttribute("pictures"));
					// mv.setViewName("My-Account");
					isNotValid = false;
					mv.setViewName("redirect:/api/auth/userdashboard");
					return mv;
				}

			}

			else {

				// log.error("Authenticate User Is ::" + authentication2.getPrincipal());
				isAuthenticate = "false";
				mv.addObject("isNotValid", isNotValid);
				mv.addObject("isAuthenticate", isAuthenticate);
				mv.addObject("error", "Invalid UserName Or Password");
				mv.setViewName("redirect:/api/page/LogIn");

				return mv;
			}
		} catch (BadCredentialsException e) {

			isNotValid = false;
			isAuthenticate = "false";
			mv.addObject("isAuthenticate", isAuthenticate);
			mv.addObject("isNotValid", isNotValid);
			mv.addObject("error", "Invalid UserName Or Password");
			mv.setViewName("redirect:/api/page/LogIn");
			return mv;
		} catch (Unauthorized e) {
			isNotValid = false;
			isAuthenticate = "false";
			mv.addObject("isAuthenticate", isAuthenticate);
			mv.addObject("isNotValid", isNotValid);
			mv.addObject("error", "Invalid UserName Or Password");
			mv.setViewName("redirect:/api/page/LogIn");
			return mv;

		} catch (Exception e) {
			isNotValid = false;
			isAuthenticate = "false";
			mv.addObject("isAuthenticate", isAuthenticate);
			mv.addObject("isNotValid", isNotValid);
			mv.addObject("error", "Invalid UserName Or Password");
			mv.setViewName("redirect:/api/page/LogIn");
			e.getMessage();
			return mv;
		}
		return mv;
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		Map<String, Object> body = new HashMap<>();
		System.out.println(" First Name " + signUpRequest.getFirstname());
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {

			body.put("message", "Your Account is Allready Exists - " + signUpRequest.getEmail());
			body.put("status", "409");
			return new ResponseEntity<>(body, HttpStatus.CONFLICT);
		}
		User userEntity = this.mapper.map(signUpRequest, User.class);

		/* == encoded password== */
		String encode = encoder.encode(userEntity.getPassword());
		userEntity.setPassword(encode);
		signUpRequest.setRole(signUpRequest.getRole());
		System.out.println("set Role is :: " + signUpRequest.getRole());
		Set<String> strRoles = signUpRequest.getRole();
		System.out.println(" get Role is :: " + strRoles);
		Set<Role> roles = new HashSet<>();
		System.out.println(" Add Role is :: " + roles);
		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
			System.out.println(" Add Role is :: " + roles);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);
					System.out.println(" Add Role is :: " + roles);

					break;
				case "mod":
					Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);
					System.out.println(" Add Role is :: " + roles);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
					System.out.println(" Add Role is :: " + roles);
				}
			});
		}

//		check Password 
		if (signUpRequest.getPassword() == null || signUpRequest.getPassword() == "") {
			body.put("message", "Fill Password !!");
			body.put("status", "202");
			return new ResponseEntity<>(body, HttpStatus.OK);
		} else {
			userEntity.setRoles(roles);
			userEntity.setFirstname(signUpRequest.getFirstname());
			userEntity.setUsername(RandomStringValue.getAlphaNumericString());
			User save = userRepository.save(userEntity);
			ModelAndView modelAndView = new ModelAndView("api/test/Sign-Up");
			body.put("message", "Your Account Is Created !!");
			body.put("status", "200");
		}

//		userEntity.setRoles(roles);
//		userEntity.setFirstname(signUpRequest.getFirstname());
//		userEntity.setUsername(RandomStringValue.getAlphaNumericString());
//		
//		
//		
//		
//	
//		User save = userRepository.save(userEntity);
//		
//		
//		
//		
//		
//		
//		ModelAndView modelAndView = new ModelAndView("api/test/Sign-Up");
//		body.put("message", "Your Account Is Created  !!");
//		body.put("status", "200");
		return new ResponseEntity<>(body, HttpStatus.OK);
		// return new ResponseEntity<>(Map.of("status", "200", "message", "Your Account
		// Is Created !!"), HttpStatus.OK);
	}

//	@RequestMapping(value = "/logout", method = RequestMethod.GET)
//	public ModelAndView logoutPage(HttpServletRequest request, HttpServletResponse response,
//			 ModelAndView mv, HttpSession httpSession)
// {	
//request.getSession().removeAttribute("auth");
//request.getSession().removeAttribute("userid");
//request.getSession().invalidate();
//		mv.setViewName("redirect:/api/page/LogIn");
//	return mv;
//	
//}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logoutPage(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication, ModelAndView mv, HttpSession httpSession)
			throws IOException, ServletException {
		// org.springframework.http.HttpHeaders httpHeaders = new
		// org.springframework.http.HttpHeaders();
//		List<String> list = httpHeaders.get("Authtoken");
//		log.info("list of data is :" + list);

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		log.info("inside Login url Authentication object is :" + auth);
		// || auth instanceof AnonymousAuthenticationToken
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
			/*
			 * SecurityContextLogoutHandler securityContextLogoutHandler = new
			 * SecurityContextLogoutHandler(); securityContextLogoutHandler.logout(request,
			 * response, auth); boolean invalidateHttpSession =
			 * securityContextLogoutHandler.isInvalidateHttpSession();
			 * securityContextLogoutHandler.setInvalidateHttpSession(invalidateHttpSession);
			 */
			// httpSession.invalidate();
			// inside Login url Authentication object is :AnonymousAuthenticationToken
			// [Principal=anonymousUser, Credentials=[PROTECTED], Authenticated=true,
			// Details=WebAuthenticationDetails [RemoteIpAddress=0:0:0:0:0:0:0:1,
			// SessionId=73CFBB1C242E45BFBD1D59BB9ABF7A0F], Granted
			// Authorities=[ROLE_ANONYMOUS]]

			SecurityContextHolder.clearContext();
			log.info("inside lOGoUT url Authentication object is :" + auth);
		}
		HttpSession session = request.getSession();
		request.setAttribute("isNotValid", true);
		mv.setViewName("login");
		return mv;
	}
	/* ==================== TESTED AUTHENTICation =========================== */

//	public ResponseEntity<?> logoutPage(HttpServletRequest request, HttpServletResponse response,
//			Authentication authentication, ModelAndView mv, HttpSession httpSession)
//			throws IOException, ServletException {
//		org.springframework.http.HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();
//		List<String> list = httpHeaders.get("Authtoken");
//		log.info("list of data is :" + list);
//
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//
//		log.info("inside Login url Authentication object is :" + auth);
//		if (auth != null) {
//			new SecurityContextLogoutHandler().logout(request, response, auth);
////			httpSession.invalidate();
//			SecurityContextHolder.clearContext();
//			log.info("inside lOGoUT url Authentication object is :" + auth);
//		}
//
//		return new ResponseEntity<>(Map.of("status", "200", "message", "You Are Logged Out !!"), HttpStatus.OK);
//	}

	@PostMapping("/login")
	public ResponseEntity<?> authentic(@RequestBody LoginRequest loginRequest, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		try {
			Optional<User> findByEmail = this.userRepository.findByEmail(loginRequest.getUsername());
			log.info("user is exists  :: " + findByEmail);
			if (findByEmail != null) {
				Authentication authentication = authenticationManager
						.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
								loginRequest.getPassword()));

				log.info("user authentication is :: " + authentication.isAuthenticated());

				UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal(); // all user details
				log.info("user userDetails is :: " + userDetails.getId());

				List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
						.collect(Collectors.toList());
				log.info("Roles of Zero Position " + roles.get(0));
				log.info("Roles is " + roles);
				String generateJwtToken = jwtUtils.generateJwtToken(authentication);
				/* ================ Set Sesssion after successfull login============= */

				if (roles.get(0) == "ROLE_ADMIN") {
					log.info("ADMIN Proccess");
					HttpSession session = request.getSession();
					session.setAttribute("auth", authentication);
					session.setAttribute("userid", userDetails.getId());
					log.info("Admin Site ");
				}
				if (roles.get(0) == "ROLE_USER") {
					// Authentication auth = SecurityContextHolder.getContext().getAuthentication();

					HttpSession session = request.getSession();
					// session.setAttribute("auth", userDetails.getUsername());
					session.setAttribute("auth", authentication);
					session.setAttribute("userid", userDetails.getId());
					session.setAttribute("username", userDetails.getEmail());
					log.info("UserName Is ::" + userDetails.getUsername());
					session.setAttribute("firstname", findByEmail.get().getFirstname());
					log.info("User Proccess");

					log.info("Get The Image Picture From Session ::" + session.getAttribute("pictures"));
					log.info("Admin Site ");
				}

				return new ResponseEntity<>(Map.of("status", "200", "tokens", generateJwtToken, "role", roles.get(0),
						"email", userDetails.getEmail()), HttpStatus.OK);
			}
		} catch (BadCredentialsException e) {

			return new ResponseEntity<>(Map.of("status", "401", "tokens", "UnAuthorized Request"),
					HttpStatus.UNAUTHORIZED);
		} catch (Exception e) {

			e.getMessage();
			return new ResponseEntity<>(Map.of("status", "500", "message", e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(Map.of("status", "500", "mesage", "Internal Server Eror "),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/*
	 * @GetMapping("/details")
	 * 
	 * @PostAuthorize(value = "hasRole('ROLE_ADMIN')")
	 * 
	 * public ResponseEntity<?> getDetails() { try { log.info("start testing");
	 * return new ResponseEntity<>(Map.of("status", "200", "message",
	 * "You have Authorize Person :"), HttpStatus.OK); }
	 * 
	 * catch (Unauthorized e) { return new ResponseEntity<>(Map.of("status", "401",
	 * "tokens", "UnAuthorized Request"), HttpStatus.UNAUTHORIZED); } catch
	 * (Exception e) { return new ResponseEntity<>(Map.of("status", "401", "tokens",
	 * e.getMessage()), HttpStatus.UNAUTHORIZED); }
	 * 
	 * }
	 * 
	 */

	@SuppressWarnings("unlikely-arg-type")
	@GetMapping("/admindashboard")
	// @PostAuthorize(value = "hasRole('ROLE_ADMIN')")
	public ModelAndView getDetails(ModelAndView mv, HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) {
		try {
			int checkAuthenticatedIsTrue = checkAuthenticateUser.checkAuthenticatedIsTrue();
			boolean authorizeduser = authentication.getAuthorities().equals("ROLE_ADMIN");
			log.info("Get Authority Value Is ::" + authorizeduser);
			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
			List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
					.collect(Collectors.toList());
			if (roles.get(0) == "ROLE_ADMIN") {
				
				mv.setViewName("Admin/Dashboard");
				return mv;
			}else {
				mv.setViewName("redirect:/api/page/LogIn");
				return mv;
			}

//			if (checkAuthenticatedIsTrue==0) {
//				mv.setViewName("redirect:/api/page/LogIn");
//				return mv;
//			}
			/*
			 * if(checkAuthenticateUser.checkAuthority()==1) {
			 * mv.setViewName("Admin/Dashboard"); return mv; }
			 */
//			mv.setViewName("redirect:/api/page/LogIn");
//			return mv;

			/*
			 * mv.setViewName("Admin/Dashboard"); return mv;
			 */
		}
		/*
		 * catch (Unauthorized e) { mv.setViewName("redirect:/api/page/LogIn"); return
		 * mv; }
		 */

		catch (Exception e) {
			mv.setViewName("redirect:/api/page/LogIn");
			return mv;
		}

	}

	@GetMapping("/userdashboard")
	// @PostAuthorize(value = "hasRole('ROLE_ADMIN')")
	public ModelAndView userDashboard(ModelAndView mv, HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) {
		try {

			int checkAuthenticatedIsTrue = checkAuthenticateUser.checkAuthenticatedIsTrue();
			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
			List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
					.collect(Collectors.toList());
			if (roles.get(0) == "ROLE_USER") {
				Long attribute = (Long) request.getSession().getAttribute("userid");
				String usernames = (String) request.getSession().getAttribute("username");
				int countAddToCartProductBasedOnUser = this.addToCartService
						.countAddToCartProductBasedOnUser(attribute);
				mv.addObject("countAddToCartProductBasedOnUser", countAddToCartProductBasedOnUser);
				String findImage = this.userImageFileService.findImage(attribute);
				if (findImage != "" && findImage != null) {
					mv.addObject("findImage", findImage);
					// mv.addObject("findImage", findImage);
				} else {
					String findImages = "user.png".trim();
					mv.addObject("findImage", findImages);
				}
				// mv.addObject("findImage", findImage);
				// mv.addObject("findImage", this.userImageFileService.findImage(attribute));
				mv.addObject("usernames", usernames);
				// mv.addObject("findImage", findImage);
				mv.setViewName("My-Account");
				return mv;
			} else {
				mv.setViewName("redirect:/api/page/LogIn");
				return mv;
			}

//			if (checkAuthenticatedIsTrue==0) {
//				mv.setViewName("redirect:/api/page/LogIn");
//				return mv;
//			}
//			
//			if(checkAuthenticateUser.checkAuthority()==0) {
//				mv.setViewName("Admin/Dashboard");
//				return mv;
//			}

		}
//		catch (Unauthorized e) {
//			mv.setViewName("redirect:/");
//			return mv;
//		}
		catch (Exception e) {
			e.printStackTrace();
			mv.setViewName("redirect:/api/page/LogIn");
			return mv;
		}

	}

	/*
	 * @GetMapping("/ad")
	 * 
	 * @PostAuthorize(value = "hasRole('ROLE_ADMIN')") public ModelAndView
	 * getAdminDashBoard(ModelAndView mv) { try { log.info("start testing");
	 * mv.setViewName("Admin/DashBoard"); return mv; } catch (Unauthorized e) {
	 * log.info("UnAuthorized Exception testing"); e.getMessage(); return mv; }
	 * catch (Exception e) { log.info(" Exception testing"); e.getStackTrace();
	 * return mv; } }
	 */

//	@GetMapping("/login")
//	public ResponseEntity<?> getImagePrcture() {
//		long id = 4;
//		//log.info("user roles is ::"+findByRoles.getId());
//		String role = this.userDao.getRole(id);
//		String findImage = this.userImageFileService.findImage(4);
//		
//		
//		// helper.deleteImageFromFolder("DEV04816.jpg");
//		return new ResponseEntity<>(Map.of("message", findImage), HttpStatus.OK);
//	}

	/* =========== LogIn ============== */

//	@PostMapping("/login")
//	public void login(@RequestBody LoginRequest loginRequest, HttpServletRequest request,
//			HttpServletResponse response) {
////	    UsernamePasswordAuthenticationToken token = UsernamePasswordAuthenticationToken.unauthenticated(
////	        loginRequest.getUsername(), loginRequest.getPassword()); 
//
//		/* === check authenticate user =========== */
//		Authentication authentication = authenticationManager.authenticate(
//				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//
//		log.info("tokens  Details is " + authentication.getPrincipal());
//		String generateJwtToken = jwtUtils.generateJwtToken(authentication);
//		log.info("Authentication Details is " + authentication);
//		org.springframework.security.core.context.SecurityContext createEmptyContext = securityContextHolderStrategy
//				.createEmptyContext();
//		createEmptyContext.setAuthentication(authentication);
//		securityContextHolderStrategy.setContext(createEmptyContext);
//		log.debug("Authenticate user1 is ::" + createEmptyContext.getAuthentication().getPrincipal());
//		Authentication authentication2 = securityContextHolderStrategy.getContext().getAuthentication();
//		log.debug("Authenticate user2 is ::" + authentication2.getPrincipal());
//		securityContextRepository.saveContext(createEmptyContext, request, response);
//
//	}

}