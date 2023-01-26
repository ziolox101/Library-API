package com.uz.library_api.controller.BookLend;

import com.uz.library_api.exceptions.User.UserNotFoundException;
import com.uz.library_api.model.BookLend.BookLend;
import com.uz.library_api.model.BookLend.DTO.BookLendDTO;
import com.uz.library_api.model.BookLend.DTO.BookLendRequest;
import com.uz.library_api.model.BookLend.DTO.BookLendUserDTO;
import com.uz.library_api.model.MessageDto;
import com.uz.library_api.service.BookLend.BookLendService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Slf4j
public class BookLendController {
    private BookLendService bookLendService;
    @GetMapping("/book/lend/user")
    public List<BookLendUserDTO> getUserLendedBooks(Principal principal) {
        if (principal == null) {
            throw new UserNotFoundException("User has not logged in");
        } else {
            return bookLendService.getUserBooksLended(principal.getName());
        }
    }

    @PostMapping("/book/lend")
    public ResponseEntity<BookLendUserDTO> lendBook(@RequestBody BookLendRequest dto, Principal principal){
       log.info("User" + principal.getName() + " has lended book " + dto.getBook());
        return new ResponseEntity<>(bookLendService.lendBook(dto, principal.getName()), HttpStatus.CREATED);
    }

    @DeleteMapping("/book/lend/back/{id}")
    public ResponseEntity<Void> lendBookBack(@PathVariable long id, Principal principal){
        log.info("User lended back book " + id);
        bookLendService.lendBookBack(id, principal.getName());
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
