package com.OC.p7v2api.mappers;

import com.OC.p7v2api.dtos.BookSlimWithLibraryAndStockDto;
import com.OC.p7v2api.entities.Book;
import com.OC.p7v2api.entities.Library;
import com.OC.p7v2api.entities.Stock;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-25T18:21:29+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class BookSlimWithLibraryAndStockDtoMapperImpl implements BookSlimWithLibraryAndStockDtoMapper {

    @Override
    public BookSlimWithLibraryAndStockDto bookStockLibraryToBookSlimWithLibraryAndStockDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookSlimWithLibraryAndStockDto bookSlimWithLibraryAndStockDto = new BookSlimWithLibraryAndStockDto();

        bookSlimWithLibraryAndStockDto.setId( book.getId() );
        bookSlimWithLibraryAndStockDto.setTitle( book.getTitle() );
        bookSlimWithLibraryAndStockDto.setAuthor( book.getAuthor() );
        bookSlimWithLibraryAndStockDto.setPublisher( book.getPublisher() );
        bookSlimWithLibraryAndStockDto.setType( book.getType() );
        bookSlimWithLibraryAndStockDto.setSummary( book.getSummary() );
        bookSlimWithLibraryAndStockDto.setNumberOfCopiesAvailable( bookStockNumberOfCopiesAvailable( book ) );
        bookSlimWithLibraryAndStockDto.setLibraryName( bookLibraryName( book ) );

        return bookSlimWithLibraryAndStockDto;
    }

    @Override
    public List<BookSlimWithLibraryAndStockDto> booksStocksLibrariesToAllBookSlimWithLibraryAndStockDto(List<Book> books) {
        if ( books == null ) {
            return null;
        }

        List<BookSlimWithLibraryAndStockDto> list = new ArrayList<BookSlimWithLibraryAndStockDto>( books.size() );
        for ( Book book : books ) {
            list.add( bookStockLibraryToBookSlimWithLibraryAndStockDto( book ) );
        }

        return list;
    }

    @Override
    public Book bookSlimWithLibraryAndStockDtoToBook(BookSlimWithLibraryAndStockDto bookSlimWithLibraryAndStockDto) {
        if ( bookSlimWithLibraryAndStockDto == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( bookSlimWithLibraryAndStockDto.getId() );
        book.setTitle( bookSlimWithLibraryAndStockDto.getTitle() );
        book.setAuthor( bookSlimWithLibraryAndStockDto.getAuthor() );
        book.setType( bookSlimWithLibraryAndStockDto.getType() );
        book.setSummary( bookSlimWithLibraryAndStockDto.getSummary() );
        book.setPublisher( bookSlimWithLibraryAndStockDto.getPublisher() );

        return book;
    }

    @Override
    public Stock bookSlimWithLibraryAndStockDtoToStock(BookSlimWithLibraryAndStockDto bookSlimWithLibraryAndStockDto) {
        if ( bookSlimWithLibraryAndStockDto == null ) {
            return null;
        }

        Stock stock = new Stock();

        stock.setId( bookSlimWithLibraryAndStockDto.getId() );
        stock.setNumberOfCopiesAvailable( bookSlimWithLibraryAndStockDto.getNumberOfCopiesAvailable() );

        return stock;
    }

    @Override
    public Library bookSlimWithLibraryAndStockDtoToLibrary(BookSlimWithLibraryAndStockDto bookSlimWithLibraryAndStockDto) {
        if ( bookSlimWithLibraryAndStockDto == null ) {
            return null;
        }

        Library library = new Library();

        library.setId( bookSlimWithLibraryAndStockDto.getId() );

        return library;
    }

    private int bookStockNumberOfCopiesAvailable(Book book) {
        if ( book == null ) {
            return 0;
        }
        Stock stock = book.getStock();
        if ( stock == null ) {
            return 0;
        }
        int numberOfCopiesAvailable = stock.getNumberOfCopiesAvailable();
        return numberOfCopiesAvailable;
    }

    private String bookLibraryName(Book book) {
        if ( book == null ) {
            return null;
        }
        Library library = book.getLibrary();
        if ( library == null ) {
            return null;
        }
        String name = library.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
