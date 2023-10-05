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
import javax.persistence.Table;
import javax.validation.constraints.Email;
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

@Table(name = "guests")

public class Guest {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "guest_id")
	 private Integer gid;

	 
	 @NotEmpty(message = "Invalid: you can't keep first name empty")
	 @Size(min = 3, max = 23, message = "Invalid name: please enter your first name")
	 @Pattern(regexp = "^[A-Za-z]*$", message = "Use Alphabets Only")
     @Column(name = "first_name")
     private String gfname;

	 @NotEmpty(message = "Invalid: you can't keep first name empty")
	 @Size(min = 3, max = 23, message = "Invalid name: please enter your last name")
	 @Pattern(regexp = "^[A-Za-z]*$", message = "Use Alphabets Only")
     @Column(name = "last_name")
     private String glname;

	 @NotEmpty(message = "Address cannot be blank")
	 @Size(max = 255, message = "Address must be at most 255 characters")
	 @Column(name = "address")
     private String gaddr;
	 
	 
	@NotEmpty(message = "You can't keep phone number Empty ")
	@Size(min = 10, max = 10, message = "Invalid Phone Number please enter a vaild phone number minimum of 10 digits")
	@Pattern(regexp = "^\\d{10}$", message = "Invalid input:Enter 10 digit numbers only")
	@Column(name = "phone_number",unique = true, length = 30)
     private String gphone;

	 @NotEmpty(message = "Email address cannot be blank")
	 @Email(message = "Invalid email address format")
	 @Pattern(
			    regexp = "^[A-Za-z0-9+_.-]+@(.+)$", // Replace with your desired regex pattern
			    message = "Invalid email address format"
			)
     @Column(name = "email_address")
     private String gemail;
	 

     @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
     @JoinColumn(name = "hotel_id")
     private Hotel hotel;
     
     private Integer hid;

     @OneToMany(mappedBy = "guest", cascade = CascadeType.ALL)
     @JsonIgnore
    // @JoinColumn(name="rsvid")
     private List<Reservation> reservation;
     
	 
} 

