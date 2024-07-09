package com.learner.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learner.dto.UserFeedBackDto;
import com.learner.entity.UserFeedBack;
import com.learner.exception.UserRelavantException;
import com.learner.repository.UserFeedBackRepository;

@Service
public class UserFeedBackService {

	@Autowired
	private UserFeedBackRepository backRepository;
	
	private UserFeedBackDto toDto(UserFeedBack req)
	{
		UserFeedBackDto dto = new UserFeedBackDto();
		dto.setId(req.getId());
		dto.setEmail(req.getEmail());
		dto.setName(req.getName());
		dto.setPhone(req.getPhone());
		dto.setCheckBoxValues(req.getCheckBoxValues());
		return dto;
	}
	
	private UserFeedBack toEntity(UserFeedBackDto req)
	{
		UserFeedBack entity = new UserFeedBack();
		entity.setEmail(req.getEmail());
		entity.setName(req.getName());
		entity.setPhone(req.getPhone());
		entity.setCheckBoxValues(req.getCheckBoxValues());
		return entity;
	}
	
	public UserFeedBackDto save(UserFeedBackDto dto)
	{
		return toDto(backRepository.save(toEntity(dto)));
	}
	
	public List<UserFeedBackDto> getAllUserFeedBacks()
	{
		List<UserFeedBack> users = backRepository.findAll();
		List<UserFeedBackDto> dtos = new ArrayList<UserFeedBackDto>();
		for(UserFeedBack i : users)
		{
			dtos.add(toDto(i));
		}
		return dtos;
	}
	
	public void deleteFeedBack(int id)
	{
		UserFeedBack user = backRepository.findById(id).orElseThrow(
				() -> new UserRelavantException("UserFeedBack not found with id "+id)
				);
		backRepository.delete(user);
	}
	
	
	public UserFeedBackDto getFeedBack(int id)
	{
		UserFeedBack user = backRepository.findById(id).orElseThrow(
				() -> new UserRelavantException("UserFeedBack not found with id "+id)
				);
		return toDto(user);
	}
}
