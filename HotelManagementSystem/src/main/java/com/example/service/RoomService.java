package com.example.service;

import java.util.List;

import com.example.entity.Room;
import com.example.exceptionhandling.EntityNotFoundException;


public interface RoomService {
	public Room addRoom(Room room) throws EntityNotFoundException;
    public  List<Room> getAllRoom(Room room);
    public  Room  getRoomById(int id) throws EntityNotFoundException;
    public Room updateRoomById(Room room);
    public String deleteRoom(int id) throws EntityNotFoundException;
    
}
