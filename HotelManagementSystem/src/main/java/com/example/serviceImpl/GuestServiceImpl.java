package com.example.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Guest;
import com.example.entity.Hotel;
import com.example.exceptionhandling.EntityNotFoundException;
import com.example.repository.GuestRepository;
import com.example.repository.HotelRepository;
import com.example.service.GuestService;

@Service
public class GuestServiceImpl implements GuestService {
@Autowired
GuestRepository guestRepository;
	@Autowired
   	HotelRepository hotelRepository; 
   
@Override
public Guest addGuest(Guest guest) throws EntityNotFoundException {
	    Optional<Hotel> optionalHotel = hotelRepository.findById(guest.getHid());
   	    
	    if (optionalHotel.isPresent()) {
	        Hotel hotel = optionalHotel.get();
	        guest.setHotel(hotel);
	        return guestRepository.save(guest);
	    } else {
	        // Handle the case where the hotel with the given ID does not exist
	        throw new EntityNotFoundException("Hotel with ID "+guest.getHid()+"  not found");
	    }
	
}

@Override
public List<Guest> getAllGuest(Guest guest) {
	// TODO Auto-generated method stub
	return guestRepository.findAll();
}

@Override
public Guest getGuestById(int id) throws EntityNotFoundException{
	Optional<Guest> option= guestRepository.findById(id);
	if(option.isPresent()) {
		return guestRepository.findById(id).get();
	}
	else {
		throw new EntityNotFoundException("Guest with ID "+id+" is not available in database");
	}
	
}




@Override
public Guest updateGuestById(Guest g) {
	// TODO Auto-generated method stub
	Guest _g=guestRepository.findById(g.getGid()).get();
	_g.setGfname(g.getGfname());
	_g.setGlname(g.getGlname());
	_g.setGemail(g.getGemail());
	_g.setGphone(g.getGphone());
    _g.setGaddr(g.getGaddr());
	return guestRepository.save(_g);	
	}


@Override
public String deleteGuest(int id) throws EntityNotFoundException{
	Optional<Guest> option= guestRepository.findById(id);
	if(option.isPresent()) {
		guestRepository.deleteAllById(null);
		return "Guest is deleted ";
	}
	else {
		throw new EntityNotFoundException("Guest with ID "+id+" is not available in database");
	}
	
}

	// TODO Auto-generated method stub
	

}


