package com.edson.desafio.controller;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

import com.edson.desafio.model.util.JwtUtil;

public class TokenFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		String token = req.getHeader("Authorization");
		if (token == null || token.isEmpty()) {
			throw new ServletException("Token não encontrado!");
		}

		if (JwtUtil.isValid(token)) {
			chain.doFilter(request, response);
		} else {
			throw new ServletException("Token Inválido!");
		}

	}

}
