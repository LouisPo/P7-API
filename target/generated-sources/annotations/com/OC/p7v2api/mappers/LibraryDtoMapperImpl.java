package com.OC.p7v2api.mappers;

import com.OC.p7v2api.dtos.LibraryDto;
import com.OC.p7v2api.entities.Library;
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
public class LibraryDtoMapperImpl implements LibraryDtoMapper {

    @Override
    public LibraryDto libraryToLibraryDto(Library library) {
        if ( library == null ) {
            return null;
        }

        LibraryDto libraryDto = new LibraryDto();

        libraryDto.setId( library.getId() );
        libraryDto.setName( library.getName() );
        libraryDto.setAddress( library.getAddress() );
        libraryDto.setEmail( library.getEmail() );
        libraryDto.setPhone( library.getPhone() );
        libraryDto.setOpeningTime( library.getOpeningTime() );

        return libraryDto;
    }

    @Override
    public List<LibraryDto> libraryToAllLibraryDto(List<Library> libraries) {
        if ( libraries == null ) {
            return null;
        }

        List<LibraryDto> list = new ArrayList<LibraryDto>( libraries.size() );
        for ( Library library : libraries ) {
            list.add( libraryToLibraryDto( library ) );
        }

        return list;
    }
}
