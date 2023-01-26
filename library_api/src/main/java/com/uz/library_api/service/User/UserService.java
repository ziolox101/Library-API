package com.uz.library_api.service.User;

import com.uz.library_api.config.PasswordEncoder;
import com.uz.library_api.exceptions.User.UserBadRequest;
import com.uz.library_api.model.Library.Library;
import com.uz.library_api.model.User.DTO.UserMapper;
import com.uz.library_api.model.User.DTO.UserRegisterDTO;
import com.uz.library_api.model.User.User;
import com.uz.library_api.repository.UserRepo;
import com.uz.library_api.service.Library.LibraryAdminService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {
        private UserRepo userRepo;
        private LibraryAdminService libraryService;
        private PasswordEncoder encoder;

        public UserRegisterDTO registerUser(UserRegisterDTO dto){
                if(validatePassword(dto.getPassword(), dto.getRepeatPassword())){
                        User user = UserMapper.mapDtoRegisterToEntity(dto);
                        user.setPassword(encoder.getPasswordEncoder().encode(dto.getPassword()));
                        Library library = libraryService.getLibraryByName(dto.getLibrary());
                        log.info("biblioteka" + library.getId());
                        user.setLibrary(library);
                        userRepo.save(user);
                        return dto;
                }
                else{
                        throw new UserBadRequest("Wrong request for registration");
                }
        }


        private boolean validatePassword(String password, String repeat){
                return password.equals(repeat);
        }
}
