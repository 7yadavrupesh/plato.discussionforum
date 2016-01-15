package com.srmri.plato.core.discussionforum.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

public class MultipartExceptionHandler extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
        	System.out.println("*********************************************");;
        	filterChain.doFilter(request, response);
        } catch (MaxUploadSizeExceededException e) {
            handle(request, response, e);
        } catch (ServletException e) {
            if(e.getRootCause() instanceof MaxUploadSizeExceededException) {
                handle(request, response, (MaxUploadSizeExceededException) e.getRootCause());
            } else {
                throw e;
            }
        }
    }

    private void handle(HttpServletRequest request,
            HttpServletResponse response, MaxUploadSizeExceededException e) throws ServletException, IOException {

        //String redirect = UrlUtils.buildFullRequestUrl(request) + "?error";
        response.sendRedirect("http://localhost:8080/plato.discussionforum.webproject/viewThread.html?thread_id=90");
    }

//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//	}

}