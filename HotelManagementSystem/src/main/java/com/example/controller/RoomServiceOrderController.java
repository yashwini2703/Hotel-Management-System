package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.RoomServiceOrder;
import com.example.exceptionhandling.EntityNotFoundException;
import com.example.service.RoomServiceOrderService;


@RestController
public class RoomServiceOrderController {

	@Autowired
	RoomServiceOrderService roomserviceorderService;
	@PostMapping("/roomserviceorders")
	public RoomServiceOrder addRoomServiceOrder(@Valid @RequestBody RoomServiceOrder roomserviceorder) throws EntityNotFoundException {
		return roomserviceorderService.addRoomServiceOrder(roomserviceorder);
}
	
	@GetMapping("/roomserviceorders")
	public List<RoomServiceOrder> getAllRoomServiceOrder()
	{

		return roomserviceorderService.getAllRoomServiceOrder();
	}
	
	@GetMapping("/roomserviceorders/{id}")
	public RoomServiceOrder findRoomServiceOrderById(@PathVariable int id) throws EntityNotFoundException {
	      return roomserviceorderService.getRoomServiceOrderById(id);
	}
	
	@DeleteMapping("/roomserviceorders/{id}")
	public String deleteRoomServiceOrder(@PathVariable int id) throws EntityNotFoundException {
		return roomserviceorderService.deleteRoomServiceOrderById(id);
	}
	
	@PutMapping("/roomserviceorders")
	public RoomServiceOrder updateRoomServiceOrderById(@RequestBody RoomServiceOrder roomserviceorder) {
		return roomserviceorderService.updateRoomServiceOrderById(roomserviceorder);
	}
	
}