package com.OC.p7v2api.controllers;

import com.OC.p7v2api.dtos.ReservationDto;
import com.OC.p7v2api.entities.Reservation;
import com.OC.p7v2api.mappers.ReservationDtoMapper;
import com.OC.p7v2api.services.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ReservationController {

    private final ReservationService reservationService;
    private final ReservationDtoMapper reservationDtoMapper;



    @GetMapping(value = "/allReservations")
    public ResponseEntity<List<ReservationDto>> checkIfReservationsAreExpired() {
        log.info("HTTP GET request received at /allReservations");
        List<Reservation> reservations = reservationService.findAllReservations();
        Date today = Date.from(Instant.now());
        for (Reservation reservation : reservations) {
            log.info("HTTP GET request received at /allReservations list");
            Date endDate = reservation.getEndDate();
            // SI les dates sont == retourne 0 si today>returnDate =-1
            // today<returnDate = 1
            if (today.compareTo(endDate) > 0) {
                log.info("HTTP GET request received at /allReservations list when reservation isOutdated");
                reservationService.deleteAReservationById(reservation.getId());
            }
        }
        return new ResponseEntity<>(reservationDtoMapper.reservationsToAllReservationDto(reservations), HttpStatus.OK);
    }


    @PostMapping(value = "books/reservation")
    public ResponseEntity<Object> makeAReservation(@RequestParam Integer bookId, @RequestParam Integer userId){
        log.info("HTTP POST request received at /books/reservation, where bookId is {} and userId is {}", bookId,userId);
        reservationService.makeAReservation(bookId, userId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
