package com.example.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Guest;
import com.example.entity.Hotel;
import com.example.entity.Reservation;
import com.example.entity.Room;
import com.example.exceptionhandling.EntityNotFoundException;
import com.example.repository.GuestRepository;
import com.example.repository.HotelRepository;
import com.example.repository.ReservationRepository;
import com.example.repository.RoomRepository;
import com.example.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private GuestRepository guestRepository;

    @Override
    public Reservation addReservation(Reservation reservation) throws EntityNotFoundException {
        Optional<Room> roomOptional = roomRepository.findById(reservation.getRid());
        Optional<Guest> guestOptional = guestRepository.findById(reservation.getGid());
        Optional<Hotel> hotelOptional = hotelRepository.findById(reservation.getHid());

        if (roomOptional.isPresent() && guestOptional.isPresent() && hotelOptional.isPresent()) {
        	Hotel hotel = hotelOptional.get();
   	        reservation.setHotel(hotel);
   	        
   	     Room room = roomOptional.get();
	        reservation.setRoom(room);
	        
	        Guest guest = guestOptional.get();
   	        reservation.setGuest(guest);
   	        return reservationRepository.save(reservation);
            
        } else {
            // Handle the case where one or more of the Optional objects is empty
            throw new EntityNotFoundException("One or more entities not found");
        }
    }



	@Override
	public List<Reservation> getAllReservation() {
		// TODO Auto-generated method stub
		return reservationRepository.findAll();
	}

	@Override
	public Reservation getReservationById(int id) throws EntityNotFoundException {
		Optional<Reservation> option=reservationRepository.findById(id);
		if(option.isPresent()) {				
		    return reservationRepository.findById(id).get();
	}
		else {
			throw new EntityNotFoundException("Reservation Not Available In Database");
		}
		
	}
	

@Override
public Reservation updateReservationById(Reservation reservation) {
	// TODO Auto-generated method stub
	Reservation _r=reservationRepository.findById(reservation.getId()).get();
	_r.setRoom(reservation.getRoom());
	_r.setGuest(reservation.getGuest());
	_r.setCheckInDate(reservation.getCheckInDate());
	_r.setCheckOutDate(reservation.getCheckOutDate());
	return reservationRepository.save(_r);
}
@Override
public String deleteReservationById(int id) throws EntityNotFoundException {
	Optional<Reservation> option=reservationRepository.findById(id);
	if(option.isPresent()) {	
		reservationRepository.deleteById(id);
		return "Reservation has be cancelled";
}
	else {
		throw new EntityNotFoundException("Reservation is not Available In Database");
	}
	
	
}


}

