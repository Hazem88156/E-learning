package com.elearning.config;

import com.elearning.dto.UserDTO;
import com.elearning.entities.Role;
import com.elearning.entities.users.UserEntity;
import com.elearning.helper.ModelMapperConverter;
import com.elearning.serviceImpl.CustomUserDetailsService;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtTokenProvider {
	
	@Value("${security.jwt.token.secret-key:secret}")
    private String secretKey = "secret";
	

    @Value("${security.jwt.token.expire-length:3600000}")
    private long validityInMilliseconds = 3600000;
    
    @Autowired
    private CustomUserDetailsService userDetailsService;
    
    @PostConstruct
    protected void init() {
       secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    	
    }
    
    public String createToken(String username, Role set) {
        Claims claims = Jwts.claims().setSubject(username);
        UserEntity userEntity = userDetailsService.findUserByLogin(username);
        claims.put("user", ModelMapperConverter.converToDTO(userEntity, UserDTO.class));
        claims.put("roles", set);
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);
        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(now)
            .setExpiration(validity)
            .signWith(SignatureAlgorithm.HS256, secretKey)
            .compact();
    }
    
    public Authentication getAuthentication(String token) {
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }
    
    public String getUsername(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }
    
    public String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }
    
    public boolean validateToken(String token, HttpServletRequest httpServletRequest) {
    	
    	try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException ex){
            System.out.println("Invalid JWT token");
        }catch (ExpiredJwtException ex){
            System.out.println("Expired JWT token");
            httpServletRequest.setAttribute("expired",ex.getMessage());
        }catch (UnsupportedJwtException ex){
            System.out.println("Unsupported JWT exception");
        }catch (IllegalArgumentException ex){
            System.out.println("Jwt claims string is empty");
        }
        return false;
    }
}
