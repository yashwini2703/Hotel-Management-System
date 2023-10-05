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

import com.example.entity.Hotel;
import com.example.exceptionhandling.EntityNotFoundException;
import com.example.service.HotelService;


@RestController
public class HotelController {
@Autowired
HotelService hotelService;

@PostMapping("/hotels")
public Hotel addHotel(@Valid @RequestBody Hotel h) {
	return hotelService.addHotel(h);
}
@GetMapping("/hotels")
public List<Hotel> getAllHotel(Hotel hotel)
{
	return hotelService.getAllHotel(hotel);
}

@GetMapping("/hotels/{id}")
public Hotel getHotelById(@PathVariable int id) throws EntityNotFoundException {
	return hotelService.getHotelById(id);
}
@DeleteMapping("/hotels/{id}")
public String deleteHotel(@PathVariable int id) throws EntityNotFoundException
{
	return hotelService.deleteHotel(id);
}

@PutMapping("/hotels")
public Hotel updateHotel(@RequestBody Hotel hotel) {
	
	return hotelService.updateHotelById(hotel);
}


}


