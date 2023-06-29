package com.infosys.ultra.auditors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infosys.ultra.auditors.model.HomeModel;
import com.infosys.ultra.auditors.service.HomeService;
@Controller
@RequestMapping("/reviewer-service")
public class HomeController {
	@Autowired
	HomeService hservice;
	
	@GetMapping(value ="/test",produces="application/json")
	public ResponseEntity<HomeModel> homeTest(){
		HomeModel homeModel=hservice.testhome();
		return ResponseEntity.ok().body(homeModel);
	}
}
