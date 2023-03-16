package com.OC.p7v2api.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Table(name = "BORROW")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
public class Borrow {

    @Id
    @Column(name="BORROW_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="START_DATE")
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="RETURN_DATE")
    private Date returnDate;

    @Column(name="ALREADY_EXTENDED")
    private boolean alreadyExtended;

    @Column(name="IS_OUTDATED")
    private boolean outdated;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOOK_ID")
    private Book book;

/*
    public Borrow(Integer BORROW_ID, Date START_DATE, Date RETURN_DATE, Boolean ALREADY_EXTENDED, Boolean IS_OUTDATED, User USER_ID, Book BOOK_ID) {

        this.id = BORROW_ID;
        this.startDate = START_DATE;
        this.returnDate = RETURN_DATE;
        this.alreadyExtended = ALREADY_EXTENDED;
        this.outdated = IS_OUTDATED;
        this.user = USER_ID;
        this.book = BOOK_ID;


    }
*/
}