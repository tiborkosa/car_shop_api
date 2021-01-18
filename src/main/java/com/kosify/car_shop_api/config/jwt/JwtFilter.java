package com.kosify.car_shop_api.config.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.kosify.car_shop_api.config.CustomEmployeeDetailService;
import com.kosify.car_shop_api.config.CustomEmployeeDetails;

import static org.springframework.util.StringUtils.hasText;

import lombok.extern.java.Log;

@Component
@Log
public class JwtFilter extends GenericFilterBean {

	public static final String AUTHORIZATION = "Authorization";

    @Autowired
    private JwtProvider jwtProvider;
    
    @Autowired
    private CustomEmployeeDetailService employeeDetailService;
    
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		logger.info("do filter...");
        String token = getTokenFromRequest((HttpServletRequest) request);
        if (token != null && jwtProvider.validateToken(token)) {
            String userLogin = jwtProvider.getEmpIdFromToken(token);
            CustomEmployeeDetails emp = employeeDetailService.loadUserByUsername(userLogin);
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(emp, null, emp.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        
        chain.doFilter(request, response);
	}
	
	 private String getTokenFromRequest(HttpServletRequest request) {
	        String bearer = request.getHeader(AUTHORIZATION);
	        if (hasText(bearer) && bearer.startsWith("Bearer ")) {
	            return bearer.substring(7);
	        }
	        return null;
	    }

}
