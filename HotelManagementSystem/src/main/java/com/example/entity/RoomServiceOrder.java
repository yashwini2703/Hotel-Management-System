package com.example.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
@Entity  

public class RoomServiceOrder 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderid;
    
    @NotEmpty(message="order date and time can't be empty!")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}", message = "Date and time must be in the format yyyy-MM-dd HH:mm")
    @Column(name = "order_date_time")
    private String orderdatetime;

    @NotEmpty(message = "Items ordered cannot be empty")
    @Size(max = 255, message = "Items ordered must be at most 255 characters")
    private String itemsordered;
   
    @Column(name = "amount")
    private double amount;
    
    @OneToMany(mappedBy = "roomserviceorder", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<BillingAndPayment> billingandpayment;
   
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;
    
    private Integer rsvid;
}