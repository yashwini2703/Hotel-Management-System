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

import com.example.entity.Guest;
import com.example.exceptionhandling.EntityNotFoundException;
import com.example.service.GuestService;

@RestController
public class GuestController {
@Autowired
GuestService guestService;

@PostMapping("/guests")
public Guest addGuest(@Valid @RequestBody Guest g) throws EntityNotFoundException {
	return guestService.addGuest(g);
}
@GetMapping("/guests")
public List<Guest> getAllGuest(Guest guest)
{
	return guestService.getAllGuest(guest);
}

@GetMapping("/guests/{id}")
public Guest findGuestById(@PathVariable int id) throws EntityNotFoundException  {
      return guestService. getGuestById(id);
}

@DeleteMapping("/guests/{id}")
public String deleteGuest(@PathVariable int id) throws EntityNotFoundException 
{
	return guestService.deleteGuest(id);
}

@PutMapping("/guests")
public Guest updateGuest(@RequestBody Guest guest) {
	return guestService.updateGuestById(guest);
}

}
