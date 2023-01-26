package com.uz.library_api.service.User;

import com.uz.library_api.exceptions.User.UserNotFoundException;
import com.uz.library_api.model.User.CustomUserDetails;
import com.uz.library_api.model.User.User;
import com.uz.library_api.repository.UserRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserLoginService implements UserDetailsService {
    private  UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userRepo.findByLogin(username);
       if (user == null) {
           log.info("User with"  + username + " typed wrong password or username");
           throw new UsernameNotFoundException("NOT FOUND");
       }
           log.info("User logged " + user.getLogin());
           return new CustomUserDetails(user);
    }
}
