package com.uz.library_api.service.BookLend;

import com.uz.library_api.exceptions.Book.BookNotFound;
import com.uz.library_api.exceptions.BookLend.BookIsNotInStock;
import com.uz.library_api.exceptions.BookLend.LendedBookNotFound;
import com.uz.library_api.exceptions.User.UserNotFoundException;
import com.uz.library_api.model.Book.Book;
import com.uz.library_api.model.Book.DTO.BookMapper;
import com.uz.library_api.model.BookLend.BookLend;
import com.uz.library_api.model.BookLend.DTO.BookLendDTO;
import com.uz.library_api.model.BookLend.DTO.BookLendMapper;
import com.uz.library_api.model.BookLend.DTO.BookLendRequest;
import com.uz.library_api.model.BookLend.DTO.BookLendUserDTO;
import com.uz.library_api.model.Library.Library;
import com.uz.library_api.model.MessageDto;
import com.uz.library_api.model.User.DTO.UserMapper;
import com.uz.library_api.model.User.User;
import com.uz.library_api.repository.BookLendRepo;
import com.uz.library_api.repository.BookRepo;
import com.uz.library_api.repository.LibraryRepo;
import com.uz.library_api.repository.UserRepo;
import com.uz.library_api.service.Library.LibraryAdminService;
import com.uz.library_api.service.Library.LibraryInfoService;
import com.uz.library_api.service.User.UserAdminService;
import com.uz.library_api.service.User.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class BookLendService {
    private BookLendRepo bookLendRepo;
    private BookRepo bookRepo;
    private UserRepo userRepo;
    private LibraryAdminService libraryService;

    public List<BookLendUserDTO> getUserBooksLended(String username){
        return BookLendMapper.mapEntityListToUserDto(bookLendRepo.getBookLendByUser_Login(username));
    }

    public BookLendUserDTO lendBook(BookLendRequest dto, String username) {
        Book book = bookRepo.findById(dto.getBook()).orElseThrow(() -> new BookNotFound("Book was not found"));
        if(book.getAmount()>0) {
            book.setAmount(book.getAmount() - 1);
            Library library = libraryService.getLibraryByName(dto.getLibrary());
            User user = userRepo.findByLogin(username);
            BookLend bookLend = BookLendMapper.mapRequestDtoToEntity(dto);
            bookLend.setUser(user);
            bookLend.setBook(book);
            bookLend.setLibrary(library);
            return BookLendMapper.mapEntityToUserDto(bookLendRepo.save(bookLend));
        }
        else{
            throw new BookIsNotInStock("Book out of stock");
        }
    }

    public void lendBookBack(long id, String username){
        User user = userRepo.findByLogin(username);
        Book book = bookRepo.findById(id).orElseThrow(() -> new BookNotFound("Book was not found"));
        book.setAmount(book.getAmount() + 1);
        bookRepo.save(book);
        bookLendRepo.deleteBookLendByBook_IdAndUser_Id(id,user.getId());
    }
}
