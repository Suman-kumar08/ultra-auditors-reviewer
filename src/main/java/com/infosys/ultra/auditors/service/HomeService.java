package com.infosys.ultra.auditors.service;

import org.springframework.stereotype.Service;

import com.infosys.ultra.auditors.model.HomeModel;

@Service
public class HomeService {

	public HomeModel testhome() {
		HomeModel homeModel = new HomeModel((long) 1,"Sweet Home");
		return homeModel;
	}
}
