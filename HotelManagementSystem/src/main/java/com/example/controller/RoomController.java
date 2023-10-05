package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Room;
import com.example.exceptionhandling.EntityNotFoundException;
import com.example.service.RoomService;


@RestController

public class RoomController {
@Autowired
RoomService roomService;

@PostMapping("/rooms")
public Room addRoom(@RequestBody Room r) throws EntityNotFoundException {
	return roomService.addRoom(r);
}

@GetMapping("/rooms")
public List<Room> getAllRoom(@RequestBody Room room)
{
	return roomService.getAllRoom(room);
}

@GetMapping("/room/{id}")
public Room getRoomById(@PathVariable int id) throws EntityNotFoundException{
	return roomService.getRoomById(id);
}

@DeleteMapping("/rooms/{id}")
public String deleteRoom(@PathVariable int id) throws EntityNotFoundException
{
	return roomService.deleteRoom(id);
}

@PutMapping("/rooms")
public Room updateRoom(@RequestBody Room room) {
	return roomService.updateRoomById(room);
}



}

