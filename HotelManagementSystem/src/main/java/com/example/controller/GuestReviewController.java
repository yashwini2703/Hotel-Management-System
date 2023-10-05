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

import com.example.entity.GuestReview;
import com.example.exceptionhandling.EntityNotFoundException;
import com.example.service.GuestReviewService;

@RestController
public class GuestReviewController {
@Autowired
GuestReviewService guestreviewService;

@PostMapping("/guestReviews")
public GuestReview addGuest(@Valid @RequestBody GuestReview gr) throws EntityNotFoundException {
	return guestreviewService.addGuest(gr);
}
@GetMapping("/guestReviews")
public List<GuestReview> getAllGuestReview(GuestReview gr)
{
	return guestreviewService.getAllGuestReview(gr);
}

@GetMapping("/guestReview/{id}")
public GuestReview getGuestReviewById(@PathVariable int id) throws EntityNotFoundException
{
	return guestreviewService.getGuestReviewById(id);
}


@DeleteMapping("/guestReviews/{id}")
public String deleteGuestReview(@PathVariable int id) throws EntityNotFoundException 
{
	return guestreviewService.deleteGuestReview(id);
}

@PutMapping("/guestReviwes")
public GuestReview updateGuestReview(@RequestBody GuestReview guestreview) {
	return guestreviewService.updateGuestReview(guestreview);
}





}
