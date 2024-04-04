package com.parrisu.finals.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parrisu.finals.services.ContestantService;

@RestController
@CrossOrigin({ "*", "http://localhost/" })
@RequestMapping({ "api/contestants/" })
public class ContestantController {

	@Autowired
	private ContestantService conService;
	
	
	
	
	
}
