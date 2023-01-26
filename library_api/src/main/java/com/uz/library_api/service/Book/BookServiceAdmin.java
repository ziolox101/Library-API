package com.uz.library_api.service.Book;

import com.uz.library_api.exceptions.Book.BookBadRequest;
import com.uz.library_api.exceptions.Book.BookNotFound;
import com.uz.library_api.model.Author.Author;
import com.uz.library_api.model.Book.Book;
import com.uz.library_api.model.Book.DTO.BookDto;
import com.uz.library_api.model.Book.DTO.BookEditDto;
import com.uz.library_api.model.Book.DTO.BookMapper;
import com.uz.library_api.model.Book.DTO.BookRequestDto;
import com.uz.library_api.model.Genre.Genre;
import com.uz.library_api.model.Library.Library;
import com.uz.library_api.model.Location.Location;
import com.uz.library_api.model.Publisher.Publisher;
import com.uz.library_api.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookServiceAdmin {
    private BookRepo bookRepo;
    private GenreRepo genreRepo;
    private PublisherRepo publisherRepo;
    private AuthorRepo authorRepo;
    private LocationRepo locationRepo;
    private LibraryRepo libraryRepo;


    public BookDto addBook(BookRequestDto dto){
        if(dto!=null) {
            Library library = libraryRepo.findByName(dto.getLibrary());
            Author author = authorRepo.findByNameAndSurname(dto.getAuthorName(), dto.getAuthorSurname());
            Genre genre = genreRepo.findByName(dto.getGenre());
            Publisher publisher = publisherRepo.findPublisherByName(dto.getPublisher());
            Location location = locationRepo.getByNumberOfRackAndNumberOfShelf(dto.getNumberOfRack(), dto.getNumberOfShelf());
            Book book = BookMapper.mapRequestDtoToEntity(dto);
            book.setAuthor(author);
            book.setLibrary(library);
            book.setGenre(genre);
            book.setPublisher(publisher);
            book.setLocation(location);
            return BookMapper.mapEntityToDto(bookRepo.save(book));
        }
        else{
            throw new BookBadRequest("Bad request to save book");
        }
    }

    public void deleteBook(long id) {
        if (bookRepo.existsById(id)) {
            bookRepo.deleteById(id);
        }else{
            throw new BookNotFound("Book was not found");
        }
    }

    public BookDto editBook(BookEditDto dto){
        Book book = bookRepo.findById(dto.getId()).orElseThrow(() -> new BookNotFound("Book was not found"));
        Library library = libraryRepo.findByName(dto.getLibrary());
        Author author = authorRepo.findByNameAndSurname(dto.getAuthorName(), dto.getAuthorSurname());
        Genre genre = genreRepo.findByName(dto.getGenre());
        Publisher publisher = publisherRepo.findPublisherByName(dto.getPublisher());
        Location location = locationRepo.getByNumberOfRackAndNumberOfShelf(dto.getNumberOfRack(), dto.getNumberOfShelf());
        book.setAuthor(author);
        book.setLibrary(library);
        book.setGenre(genre);
        book.setPublisher(publisher);
        book.setLocation(location);
        book.setTitle(dto.getTitle());
        book.setAmount(dto.getAmount());
       return BookMapper.mapEntityToDto(bookRepo.save(book));
    }

}
