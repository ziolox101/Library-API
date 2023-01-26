package com.uz.library_api.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
@Slf4j
public class LogoutHandler implements org.springframework.security.web.authentication.logout.LogoutHandler {
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
      log.info("User has logged out: " + authentication.getName());
    }
}
