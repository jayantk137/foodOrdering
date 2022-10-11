package com.project.foodOrdering.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.project.foodOrdering.util.JwtUtil;



@Component
public class SecurityFilter extends OncePerRequestFilter {

	@Autowired
	JwtUtil jwtUtil;

	@Autowired
	UserDetailsService detailsService;

	public String token;
	
	public String jwt_token;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		token = request.getHeader("Authorization");
		if (token!=null && token.startsWith("Bearer ")) {
			String username = jwtUtil.getUsername(token.substring(7));
			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails user = detailsService.loadUserByUsername(username);
				boolean isValid = jwtUtil.validateToken(token.substring(7), user.getUsername());
				if (isValid) {
					UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
							username, user.getPassword(),null);
					authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				}
			}

		}
		filterChain.doFilter(request, response);

	}

}
