package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
@Entity  

@Table(name = "guestReviews")
public class GuestReview {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Integer reviewid;

	@NotEmpty
    @Size(min = 1, max = 5)
    @Column(name = "rating")
    private int rating;

    
	@Size(max = 255)
    @Column(name = "comments")
    private String comments;

	@NotEmpty
    @Size(max = 10)
    @Column(name = "date")
    private String date;
    
    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;
    private int rsvid;
    
    
}
