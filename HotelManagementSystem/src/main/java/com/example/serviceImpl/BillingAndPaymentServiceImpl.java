package com.example.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.BillingAndPayment;
import com.example.entity.Reservation;
import com.example.entity.Room;
import com.example.entity.RoomServiceOrder;
import com.example.exceptionhandling.EntityNotFoundException;
import com.example.repository.BillingAndPaymentRepository;
import com.example.repository.ReservationRepository;
import com.example.repository.RoomRepository;
import com.example.repository.RoomServiceOrderRepository;
import com.example.service.BillingAndPaymentService;


@Service
public class BillingAndPaymentServiceImpl implements BillingAndPaymentService{
@Autowired 
BillingAndPaymentRepository  billingandpaymentRepository;
@Autowired
ReservationRepository reservationRepository;
@Autowired
RoomRepository  roomRepository;
@Autowired
RoomServiceOrderRepository roomserviceorderRepository; 


@Override
public BillingAndPayment addBillingAndPayment(BillingAndPayment billingAndPayment) throws EntityNotFoundException {
    Optional<Reservation> reservationOptional = reservationRepository.findById(billingAndPayment.getRsvid());
    Optional<Room> roomOptional = roomRepository.findById(billingAndPayment.getRid());
    Optional<RoomServiceOrder> roomserviceorderOptional = roomserviceorderRepository.findById(billingAndPayment.getRsod());

    if (reservationOptional.isPresent() && roomserviceorderOptional.isPresent() && roomOptional.isPresent()) {
        billingAndPayment.setReservation(reservationOptional.get());
        billingAndPayment.setRoom(roomOptional.get());
        billingAndPayment.setRoomserviceorder(roomserviceorderOptional.get());

        Room room = roomOptional.get(); // Retrieve the Room object

        if (roomserviceorderOptional.isPresent() && room != null) {
            double totalPrice = room.getRoomRate() + roomserviceorderOptional.get().getAmount();
            billingAndPayment.setTotalPrice(totalPrice);
            
        } else {
            throw new EntityNotFoundException("RoomServiceOrder or Room not available for the given IDs");
        }

        return billingandpaymentRepository.save(billingAndPayment);
    } else {
        throw new EntityNotFoundException("Reservation, RoomServiceOrder, or Room not available for the given IDs");
    }
}


	@Override
	public List<BillingAndPayment> getAllBillingAndPayment() {
		// TODO Auto-generated method stub
		return billingandpaymentRepository.findAll();
	}

	
	
	@Override
	public BillingAndPayment getBillingAndPaymentById(int id) throws EntityNotFoundException {
		Optional<BillingAndPayment> option=	billingandpaymentRepository.findById(id);
		if(option.isPresent()) {
			return billingandpaymentRepository.findById(id).get();
		}
		else {
			throw new EntityNotFoundException("Billing and Payment not available in database");
		}
		
	}

	@Override
	public BillingAndPayment updateBillingAndPaymentById(BillingAndPayment bp) {
		// TODO Auto-generated method stub
		BillingAndPayment _bp=billingandpaymentRepository.findById(bp.getPaymentid()).get();
		_bp.setReservation(bp.getReservation());
		_bp.setPaymentdate(bp.getPaymentdate());
		_bp.setTotalPrice(bp.getTotalPrice());
		_bp.setPaymentmethod(bp.getPaymentmethod());

		return billingandpaymentRepository.save(_bp);
	}

	@Override
	public String deleteBillingAndPaymentById(int id) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		Optional<BillingAndPayment> option=	billingandpaymentRepository.findById(id);
		if(option.isPresent()) {
			billingandpaymentRepository.deleteById(id);
			return "BillingAndPayment is Cancelled";
		}
		else {
			throw new EntityNotFoundException("Billing and Payment not available in database");
		}
	}
	

}
