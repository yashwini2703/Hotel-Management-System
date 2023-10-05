package com.example.service;

import java.util.List;

import com.example.entity.GuestReview;
import com.example.exceptionhandling.EntityNotFoundException;


public interface GuestReviewService {
	public GuestReview addGuest(GuestReview guestreview) throws EntityNotFoundException;
    public  List<GuestReview> getAllGuestReview(GuestReview guestreview);
    public  GuestReview  getGuestReviewById(int id) throws EntityNotFoundException ;
    public GuestReview updateGuestReview(GuestReview guestreview);
    public String deleteGuestReview(int id) throws EntityNotFoundException;

}
