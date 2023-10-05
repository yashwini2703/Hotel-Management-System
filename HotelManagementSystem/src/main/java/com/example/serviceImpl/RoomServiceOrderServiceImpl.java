package com.example.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Reservation;
import com.example.entity.RoomServiceOrder;
import com.example.exceptionhandling.EntityNotFoundException;
import com.example.repository.ReservationRepository;
import com.example.repository.RoomServiceOrderRepository;
import com.example.service.RoomServiceOrderService;

@Service
public class RoomServiceOrderServiceImpl implements RoomServiceOrderService{
@Autowired
RoomServiceOrderRepository roomserviceorderRepository;
@Autowired
ReservationRepository reservationRepository;

	@Override
	public RoomServiceOrder addRoomServiceOrder(RoomServiceOrder roomServiceOrder)throws EntityNotFoundException {
		Optional<Reservation> reservationOptional = reservationRepository.findById(roomServiceOrder.getRsvid());

	    if (reservationOptional.isPresent()) {
	   	      	roomServiceOrder.setReservation(reservationOptional.get());
	    	
	        return roomserviceorderRepository.save(roomServiceOrder);
	    } else {
	        
	        throw new EntityNotFoundException("Reservation with id "+roomServiceOrder.getRsvid()+" is not available in database");
	    }
	}

	@Override
	public List<RoomServiceOrder> getAllRoomServiceOrder() {
		// TODO Auto-generated method stub
		return roomserviceorderRepository.findAll();
	}
	
	@Override
	public RoomServiceOrder getRoomServiceOrderById(int id) throws EntityNotFoundException {
		Optional<RoomServiceOrder> option=roomserviceorderRepository.findById(id);
		if(option.isPresent()) {
			return roomserviceorderRepository.findById(id).get();
		}
		else {
			throw new EntityNotFoundException("Room Service Order is Not Available in Database");
		}
	}

	@Override
	public RoomServiceOrder updateRoomServiceOrderById(RoomServiceOrder rso) {
		// TODO Auto-generated method stub
		RoomServiceOrder  _r=roomserviceorderRepository.findById(rso.getOrderid()).get();
	
		_r.setReservation(rso.getReservation());
		_r.setOrderid(rso.getOrderid());
		_r.setItemsordered(rso.getItemsordered());
		_r.setOrderdatetime(rso.getOrderdatetime());
		_r.setAmount(rso.getAmount());
		return roomserviceorderRepository.save(_r);
	}

	@Override
	public String deleteRoomServiceOrderById(int id) throws EntityNotFoundException {
		Optional<RoomServiceOrder> option=roomserviceorderRepository.findById(id);
		if(option.isPresent()) {
			roomserviceorderRepository.deleteById(id);
			return "ROOMSERVICEORDER  is deleted";
		}
		else {
			throw new EntityNotFoundException("Room Service Order is Not Available in Database");
		}
		
	}


}
