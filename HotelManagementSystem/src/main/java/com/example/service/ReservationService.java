package com.example.service;

import java.util.List;

import com.example.entity.Reservation;
import com.example.exceptionhandling.EntityNotFoundException;


public interface ReservationService {
    public Reservation addReservation(Reservation reservation) throws EntityNotFoundException;
	public  List<Reservation> getAllReservation();
	 public  Reservation getReservationById(int id) throws EntityNotFoundException  ;
	  public   Reservation updateReservationById(Reservation reservation);
	   public String deleteReservationById(int id) throws EntityNotFoundException;
	    
}