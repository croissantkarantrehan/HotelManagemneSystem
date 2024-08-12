package com.example.demo.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

import com.example.demo.entity.UserTable;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class JwtFilter extends OncePerRequestFilter {

	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	JwtUserDetails jwtUserDetails;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	
		System.out.println(request.getRequestURI()+request.getMethod());
		String jwtToken=null;String username=null;
		String token=request.getHeader("Authorization");
		if(token!=null&&token.contains("Bearer"))
		{
			jwtToken=token.substring(7);
		username=jwtUtil.getUsernameFromToken(jwtToken);
		}
		
		
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			UserDetails user=jwtUserDetails.loadUserByUsername(username);
			 if(jwtUtil.validateToken(jwtToken, user))
			 {
				 UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
				 usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				 SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			 }
			
			
		}
		
		filterChain.doFilter(request, response);
		
	}

}
