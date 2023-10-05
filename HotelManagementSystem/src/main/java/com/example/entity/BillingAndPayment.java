package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
@Entity  

public class BillingAndPayment {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int paymentid;
		
	@NotEmpty(message="payment date can not be empty")
    @Column(name = "payment_date")
    private String paymentdate;

    @Column(name = "total_price")
    private double totalPrice;
     
    
    @Column(name = "payment_method")
    private String paymentmethod;

    @OneToOne
    @JoinColumn(name = "reservation_id")
	@NotEmpty(message="reservatiom id  can not be empty")

    private Reservation reservation;
    private Integer rsvid;
   
	@NotEmpty(message="room id can not be empty")
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    private Integer rid;
    
	@NotEmpty(message="room service order id can not be empty")

    @ManyToOne
    @JoinColumn(name = "roomServiceOrder_id")
    private RoomServiceOrder roomserviceorder;
    private Integer rsod;
   
   
    
}

