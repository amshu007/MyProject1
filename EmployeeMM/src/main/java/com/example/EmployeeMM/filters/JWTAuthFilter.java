package com.example.EmployeeMM.filters;

import com.example.EmployeeMM.service.CustomUserDetailsService;
import com.example.EmployeeMM.util.JWTUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTAuthFilter extends OncePerRequestFilter {

    @Autowired
    JWTUtil jwtUtil;

    @Autowired
    CustomUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;
        if(authHeader!=null && authHeader.startsWith("Bearer ")){
            token = authHeader.substring(7);
            username = jwtUtil.extractUsername(token);

            System.out.println("Token:"+ token);
            System.out.println("Username:" + username);

        }

//       TODO  checking if SecurityContextHolder is null or not
        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){


//            TODO fetch username
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            System.out.println("Userdetails:" + userDetails.getUsername());
//            TODO validate Token
            if(jwtUtil.validateToken(username, userDetails, token)){
//          TODO set to spring context
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

//                Setting details related to request in context holder  -- optional
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                System.out.println("Auth Token:" + authToken);
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }

        }

//      calling next filter
        filterChain.doFilter(request,response);

    }
}
