package com.example.service;

import java.util.List;

import com.example.entity.RoomServiceOrder;
import com.example.exceptionhandling.EntityNotFoundException;


public interface RoomServiceOrderService {
	public RoomServiceOrder addRoomServiceOrder(RoomServiceOrder rso) throws EntityNotFoundException;
	public List<RoomServiceOrder> getAllRoomServiceOrder();
    public  RoomServiceOrder getRoomServiceOrderById(int id) throws EntityNotFoundException;
    public RoomServiceOrder updateRoomServiceOrderById(RoomServiceOrder rso);
	public String deleteRoomServiceOrderById(int id) throws EntityNotFoundException;
}
