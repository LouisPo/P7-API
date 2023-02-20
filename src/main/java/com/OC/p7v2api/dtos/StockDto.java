package com.OC.p7v2api.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StockDto {

        private Integer id;
        private int numberOfCopiesAvailable;
        private int numberOfCopiesOut;
        private int totalOfCopies;
        private boolean bookIsAvailable;


}
