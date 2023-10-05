package com.example.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.GuestReview;
import com.example.entity.Reservation;
import com.example.exceptionhandling.EntityNotFoundException;
import com.example.repository.GuestReviewRepository;
import com.example.repository.ReservationRepository;
import com.example.service.GuestReviewService;


@Service
public class GuestReviewServiceImpl implements GuestReviewService {
@Autowired
GuestReviewRepository guestreviewRepository;
@Autowired
   	ReservationRepository reservationRepository; 
	
	
	
	@Override
	public GuestReview addGuest(GuestReview guestreview)throws EntityNotFoundException {
	    Optional<Reservation> reservationOptional = reservationRepository.findById(guestreview.getRsvid());

	    if ( reservationOptional.isPresent()) {
	      	guestreview.setReservation(reservationOptional.get());
	    	
	      	return guestreviewRepository.save(guestreview);
	    } else {
	        
	        throw new EntityNotFoundException("Reservation with id "+guestreview.getRsvid()+" is not available in database");
	    }
		
	}

	@Override
	public List<GuestReview> getAllGuestReview(GuestReview guestreview) {
		// TODO Auto-generated method stub
		return guestreviewRepository.findAll();
	}
		
	@Override
	public GuestReview getGuestReviewById(int id) throws EntityNotFoundException {
		Optional<GuestReview> option=guestreviewRepository.findById(id);
		if(option.isPresent()) {
			return guestreviewRepository.findById(id).get();
		}
		else {
			throw new EntityNotFoundException("Guest Review not available in database");
		}
	}
	@Override
	public GuestReview updateGuestReview(GuestReview gr) {
		// TODO Auto-generated method stub
		GuestReview _g=guestreviewRepository.findById(gr.getReviewid()).get();
		_g.setReservation(gr.getReservation());
		_g.setDate(gr.getDate());
		_g.setRating(gr.getRating());
		_g.setComments(gr.getComments());

		return guestreviewRepository.save(_g);
	
	}

	@Override
	public String deleteGuestReview(int id) throws EntityNotFoundException{
		Optional<GuestReview> option=guestreviewRepository.findById(id);
		if(option.isPresent()) {
		guestreviewRepository.deleteAllById(null);
		return "GuestReview has been deleted";
	}
		else {
			throw new EntityNotFoundException("Guest Review is not available in database");
		}
		}

	
}