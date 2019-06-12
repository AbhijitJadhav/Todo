package com.example.demo.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller("erro")
public class ErrorController {

	@ExceptionHandler(Exception.class)
	public ModelAndView handleRuntimeException(HttpServletRequest request,HttpServletResponse response,Exception exception) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exception", exception.getStackTrace());
		modelAndView.addObject("url", request.getRequestURI());
		modelAndView.setViewName("error");
		return modelAndView;
	}
}
