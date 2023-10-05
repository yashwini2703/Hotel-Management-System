package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Reservation;
import com.example.exceptionhandling.EntityNotFoundException;
import com.example.service.ReservationService;


@RestController
public class ReservationController {
@Autowired
	ReservationService reservationService;
@PostMapping("/reservations")
public Reservation addReservation(@Valid @RequestBody Reservation reservation) throws EntityNotFoundException {
	return reservationService.addReservation(reservation);
}
@GetMapping("/reservations")
public List<Reservation> getAllReservation(){
	return reservationService.getAllReservation();
}

@GetMapping("reservation/{id}")
public Reservation getReservationById(@PathVariable int id) throws EntityNotFoundException{
	return reservationService.getReservationById(id);
}

@DeleteMapping("/reservations/{id}")
public String deleteReservation(@PathVariable int id) throws EntityNotFoundException
{
	return reservationService.deleteReservationById(id);
}

@PutMapping("/reservations")
public Reservation updateReservation(@RequestBody Reservation reservation) {
	return reservationService.updateReservationById(reservation);
}





}
