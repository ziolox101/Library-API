package com.uz.library_api.controller.BookLend;

import com.uz.library_api.model.BookLend.DTO.BookLendDTO;
import com.uz.library_api.service.BookLend.BookLendAdminService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/admin")
@AllArgsConstructor
@Slf4j
public class BookLendControllerAdmin {
    private BookLendAdminService bookLendAdminService;
    @GetMapping("/book/lend/{id}")
    public ResponseEntity<BookLendDTO> getSingle(@PathVariable long id){
        log.info("Admin lendBook selected by id " + id);
        return new ResponseEntity<>(bookLendAdminService.getSingle(id), HttpStatus.OK);
    }

    @GetMapping("/book/lend")
    public ResponseEntity<List<BookLendDTO>> getAll(){
        return new ResponseEntity<>(bookLendAdminService.getALl(), HttpStatus.OK);
    }

    @DeleteMapping("/book/lend/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        log.info("Admin deleted lended book with id " + id);
        bookLendAdminService.deleteBookLendedById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
