package com.example.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Hotel;
import com.example.entity.Room;
import com.example.exceptionhandling.EntityNotFoundException;
import com.example.repository.HotelRepository;
import com.example.repository.RoomRepository;
import com.example.service.RoomService;


@Service
public class RoomServiceImpl implements RoomService {
   	@Autowired
RoomRepository  roomRepository;
   	@Autowired
   	HotelRepository hotelRepository; 
   	@Override
   
   	public Room addRoom(Room room)throws EntityNotFoundException {
   	    Optional<Hotel> optionalHotel = hotelRepository.findById(room.getHid());
   	    
   	    if (optionalHotel.isPresent()) {
   	        Hotel hotel = optionalHotel.get();
   	        room.setHotel(hotel);
   	        return roomRepository.save(room);
   	    } else {
   	        // Handle the case where the hotel with the given ID does not exist
   	        throw new EntityNotFoundException("Hotel with ID "+room.getHid()+"  not found");
   	    }
   	} 


	@Override
	public List<Room> getAllRoom(Room room) {
		
		return roomRepository.findAll();
	}


	@Override
	public Room getRoomById(int id) throws EntityNotFoundException {
		Optional<Room> option= roomRepository.findById(id);
		if(option.isPresent()) {
			return roomRepository.findById(id).get();
		}
		else {
			throw new EntityNotFoundException("Room with ID "+id+" not available in database");
		}
	}
	
	
	

	@Override
	public Room updateRoomById(Room r) {
		// TODO Auto-generated method stub
		Room _r=roomRepository.findById(r.getId()).get();
		_r.setRoomNumber(r.getRoomNumber());
		_r.setRoomRate(r.getRoomRate());
		_r.setFloorNumber(r.getFloorNumber());
		_r.setHotel(r.getHotel());
		return roomRepository.save(_r);	}
	
	@Override
	public String deleteRoom(int id)throws EntityNotFoundException {
		Optional<Room> option= roomRepository.findById(id);
		if(option.isPresent()) {
			roomRepository.deleteAllById(null);
			return "Room is deleted ";
		}
		else {
			throw new EntityNotFoundException("Room with ID "+id+" not available in database");
		}
		
	}

	
	
	
}