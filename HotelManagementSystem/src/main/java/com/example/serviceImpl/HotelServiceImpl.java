package com.example.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Hotel;
import com.example.exceptionhandling.EntityNotFoundException;
import com.example.repository.HotelRepository;
import com.example.service.HotelService;


@Service
public class HotelServiceImpl implements HotelService{
@Autowired
HotelRepository hotelRepository;

@Override
public Hotel addHotel(Hotel hotel) {
	// TODO Auto-generated method stub
	return hotelRepository.save(hotel);
}

@Override
public List<Hotel> getAllHotel(Hotel hotel) {
	// TODO Auto-generated method stub
	return hotelRepository.findAll();
}


@Override
public Hotel getHotelById(int id) throws EntityNotFoundException {
	Optional<Hotel> option= hotelRepository.findById(id);
	if(option.isPresent()) {
		return hotelRepository.findById(id).get();
	}
	else {
		throw new EntityNotFoundException("Hotel with id "+id+" is not available in database");
	}
	
}

@Override
public Hotel updateHotelById(Hotel hotel) {
	// TODO Auto-generated method stub
	Hotel _hotel=hotelRepository.findById(hotel.getId()).get();
	_hotel.setName(hotel.getName());
	_hotel.setCity(hotel.getCity());
	return hotelRepository.save(_hotel);
}

@Override
public String deleteHotel(int id) throws EntityNotFoundException {
	Optional<Hotel> option= hotelRepository.findById(id);
	if(option.isPresent()) {
		hotelRepository.deleteById(id);
		return "Hotel Booking is cancelled";
	}
	else {
		throw new EntityNotFoundException("Hotel with id "+id+" is not available in database");
	}
	
}

}
