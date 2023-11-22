package com.ecommarce.api.controller;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.ecommarce.api.service.CategoryService;
import com.ecommarce.api.service.ProductService;
import lombok.AllArgsConstructor;
/*==============  THIS COTROLLER MANAGE ALL DEFAULT HANDLER LIKE   AFTER / INDEX PAGE IS DEFAULT HANDLER WHICH RESPONSIBLE FOR DELIVER INDEX PAGE CONTENT ==========*/

@RestController
@AllArgsConstructor
public class DefaultController {
	private CategoryService categoryService;
	private ProductService productService;
	private ModelMapper mapper;

	@GetMapping("/")
	public ModelAndView getIndexPage(ModelAndView mv) {
		try {

			mv.setViewName("redirect:/api/page/index");
			return mv;
		} catch (Exception e) {
			e.getMessage();
		}
		return mv;
	}

}
