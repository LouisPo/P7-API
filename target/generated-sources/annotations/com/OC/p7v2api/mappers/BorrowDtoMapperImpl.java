package com.OC.p7v2api.mappers;

import com.OC.p7v2api.dtos.BorrowDto;
import com.OC.p7v2api.entities.Book;
import com.OC.p7v2api.entities.Borrow;
import com.OC.p7v2api.entities.Library;
import com.OC.p7v2api.entities.User;
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
public class BorrowDtoMapperImpl implements BorrowDtoMapper {

    @Override
    public BorrowDto borrowToBorrowDtoMapper(Borrow borrow) {
        if ( borrow == null ) {
            return null;
        }

        BorrowDto borrowDto = new BorrowDto();

        borrowDto.setId( borrow.getId() );
        borrowDto.setStartDate( borrow.getStartDate() );
        borrowDto.setReturnDate( borrow.getReturnDate() );
        borrowDto.setAlreadyExtended( borrow.isAlreadyExtended() );
        borrowDto.setOutdated( borrow.isOutdated() );
        borrowDto.setUsername( borrowUserUsername( borrow ) );
        borrowDto.setFirstName( borrowUserFirstName( borrow ) );
        borrowDto.setLastName( borrowUserLastName( borrow ) );
        borrowDto.setBookTitle( borrowBookTitle( borrow ) );
        borrowDto.setBookAuthor( borrowBookAuthor( borrow ) );
        borrowDto.setLibraryName( borrowBookLibraryName( borrow ) );
        borrowDto.setOpeningTime( borrowBookLibraryOpeningTime( borrow ) );

        return borrowDto;
    }

    @Override
    public List<BorrowDto> borrowToAllBorrowDto(List<Borrow> borrows) {
        if ( borrows == null ) {
            return null;
        }

        List<BorrowDto> list = new ArrayList<BorrowDto>( borrows.size() );
        for ( Borrow borrow : borrows ) {
            list.add( borrowToBorrowDtoMapper( borrow ) );
        }

        return list;
    }

    private String borrowUserUsername(Borrow borrow) {
        if ( borrow == null ) {
            return null;
        }
        User user = borrow.getUser();
        if ( user == null ) {
            return null;
        }
        String username = user.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }

    private String borrowUserFirstName(Borrow borrow) {
        if ( borrow == null ) {
            return null;
        }
        User user = borrow.getUser();
        if ( user == null ) {
            return null;
        }
        String firstName = user.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String borrowUserLastName(Borrow borrow) {
        if ( borrow == null ) {
            return null;
        }
        User user = borrow.getUser();
        if ( user == null ) {
            return null;
        }
        String lastName = user.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }

    private String borrowBookTitle(Borrow borrow) {
        if ( borrow == null ) {
            return null;
        }
        Book book = borrow.getBook();
        if ( book == null ) {
            return null;
        }
        String title = book.getTitle();
        if ( title == null ) {
            return null;
        }
        return title;
    }

    private String borrowBookAuthor(Borrow borrow) {
        if ( borrow == null ) {
            return null;
        }
        Book book = borrow.getBook();
        if ( book == null ) {
            return null;
        }
        String author = book.getAuthor();
        if ( author == null ) {
            return null;
        }
        return author;
    }

    private String borrowBookLibraryName(Borrow borrow) {
        if ( borrow == null ) {
            return null;
        }
        Book book = borrow.getBook();
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

    private String borrowBookLibraryOpeningTime(Borrow borrow) {
        if ( borrow == null ) {
            return null;
        }
        Book book = borrow.getBook();
        if ( book == null ) {
            return null;
        }
        Library library = book.getLibrary();
        if ( library == null ) {
            return null;
        }
        String openingTime = library.getOpeningTime();
        if ( openingTime == null ) {
            return null;
        }
        return openingTime;
    }
}
