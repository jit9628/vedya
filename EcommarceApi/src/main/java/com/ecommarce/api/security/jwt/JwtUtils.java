package com.ecommarce.api.security.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.ecommarce.api.service.UserDetailsImpl;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtUtils {
  private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

  @Value("${EcommarceApi.app.jwtSecret}")
  private String jwtSecret;

  @Value("${EcommarceApi.app.jwtExpirationMs}")
  private int jwtExpirationMs;
  /*============= this method is responsible for the generate the Json Web Token [JWT] */
  public String generateJwtToken(Authentication authentication) {
	// log.info("Authentication Generate Tokens  is "+authentication);

    UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
   // log.info("User Principal  is ::  "+userPrincipal);

  //  log.debug("userPrincipal  is "+userPrincipal.getEmail()+ " "+userPrincipal.getUsername());

    return Jwts.builder()
       // .setSubject((userPrincipal.getUsername()))
        .setSubject((userPrincipal.getEmail()))
        .setIssuedAt(new Date())
        .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
        .signWith(SignatureAlgorithm.HS512, jwtSecret)
        .compact();
  }

  /*========GET USER FROM JWT TOKEN=========*/
  public String getUserNameFromJwtToken(String token) {

	  String subject = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	 // log.debug("Jwt Token Subject :: "+subject);
	  return subject;
   // return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
  }
  /*==============VALIDATE TOKENS ==============*/
  public boolean validateJwtToken(String authToken) {
    try {
      Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
      return true;
    } catch (SignatureException e) {
      //log.error("Invalid JWT signature: {}", e.getMessage());
    } catch (MalformedJwtException e) {
     // log.error("Invalid JWT token: {}", e.getMessage());
    } catch (ExpiredJwtException e) {
    //  log.error("JWT token is expired: {}", e.getMessage());
    } catch (UnsupportedJwtException e) {
  //    log.error("JWT token is unsupported: {}", e.getMessage());
    } catch (IllegalArgumentException e) {
   //   log.error("JWT claims string is empty: {}", e.getMessage());
    }
    return false;
  }

}
