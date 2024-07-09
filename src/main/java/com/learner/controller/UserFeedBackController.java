package com.learner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learner.dto.UserFeedBackDto;
import com.learner.service.UserFeedBackService;

@RestController
@RequestMapping("/feedback")
public class UserFeedBackController {
	
	@Autowired
	private UserFeedBackService service;
	
	@PostMapping("/save")
	public ResponseEntity<UserFeedBackDto> saveEntity(@RequestBody UserFeedBackDto req)
	{
		return ResponseEntity.ok(service.save(req));
	}
	
	@GetMapping("/get-all-feedbacks")
	public ResponseEntity<List<UserFeedBackDto>> getAllFeedBacks()
	{
		return ResponseEntity.ok(service.getAllUserFeedBacks());
	}
	
	@GetMapping("/get-feedback-by-id/{id}")
	public ResponseEntity<UserFeedBackDto> getUserFeedBack(@PathVariable int id)
	{
		return ResponseEntity.ok(service.getFeedBack(id));
	}
	
	@DeleteMapping("/delete-feedback/{id}")
	public ResponseEntity<String> deleteUserFeedBack(@PathVariable int id)
	{
		service.deleteFeedBack(id);
		return ResponseEntity.ok("Requested UserFeedback deleted successfully.");
	}
	
	
}
