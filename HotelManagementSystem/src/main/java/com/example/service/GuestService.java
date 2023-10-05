package com.example.service;

import java.util.List;

import com.example.entity.Guest;
import com.example.exceptionhandling.EntityNotFoundException;

public interface GuestService {
	public Guest addGuest(Guest guest) throws EntityNotFoundException;
    public  List<Guest> getAllGuest(Guest guest);
    public  Guest  getGuestById(int id) throws EntityNotFoundException ;
    public Guest updateGuestById(Guest guest);
    public String deleteGuest(int id) throws EntityNotFoundException;
}
