package com.example.cqrsbankingapp.web.security.jwt;

import io.github.ilyalisov.jwt.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.GenericFilterBean;

@RequiredArgsConstructor
public class JwtTokenFilter extends GenericFilterBean {

    private final TokenService jwtService;
    private final UserDetailsService userDetailsService;

    @Override
    @SneakyThrows
    public void doFilter(
            final ServletRequest req,
            final ServletResponse res,
            final FilterChain filterChain
    ) {
        try {
            String token = resolve((HttpServletRequest) req);
            if (!token.isEmpty()
                    && jwtService.getType(token).equals(TokenType.ACCESS.name())
                    && !jwtService.isExpired(token)) {
                Authentication auth = getAuthentication(token);
                if (auth != null) {
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            }
        } catch (Exception ignored) {
        }
        filterChain.doFilter(req, res);
    }

    private String resolve(
            final HttpServletRequest request
    ) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return "";
    }

    private Authentication getAuthentication(
            final String token
    ) {
        String subject = jwtService.getSubject(token);
        UserDetails userDetails = userDetailsService
                .loadUserByUsername(subject);
        if (userDetails != null) {
            return new UsernamePasswordAuthenticationToken(
                    userDetails,
                    "",
                    userDetails.getAuthorities()
            );
        }
        return null;
    }

}
