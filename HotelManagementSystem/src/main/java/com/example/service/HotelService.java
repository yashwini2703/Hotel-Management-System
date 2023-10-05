package com.example.service;

import java.util.List;

import com.example.entity.Hotel;
import com.example.exceptionhandling.EntityNotFoundException;


public interface HotelService {
	public Hotel addHotel(Hotel hotel);
    public  List<Hotel> getAllHotel(Hotel hotel);
    public  Hotel  getHotelById(int id) throws EntityNotFoundException;
    public Hotel updateHotelById(Hotel hotel);
    public String deleteHotel(int id) throws EntityNotFoundException;
}
