package com.uz.library_api.repository;

import com.uz.library_api.model.User.User;
import com.uz.library_api.model.User.UserLoginRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findByLogin(String username);
    boolean existsByLogin(String username);

}
