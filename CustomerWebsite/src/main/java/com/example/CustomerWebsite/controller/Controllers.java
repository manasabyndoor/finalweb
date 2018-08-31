package com.example.CustomerWebsite.controller;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.client.RestTemplate;

import com.example.CustomerWebsite.pojo.Customer;

@Controller
public class Controllers {
	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public String getAllEmployeesXML(Model model) {
		final String uri = "http://localhost:8080/view";

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<Customer>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Customer>>() {});
		if (response.getStatusCode().equals(HttpStatus.OK))
			model.addAttribute("customer", response.getBody());
		else
			model.addAttribute("customer", null);
		return "website";

	}
	@RequestMapping(value = "/customersid", method = RequestMethod.GET)
	public String getEmployeeById(Model model) {
		final String uri = "http://localhost:8080/view/id";

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<Customer>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Customer>>() {});
		if (response.getStatusCode().equals(HttpStatus.OK))
			model.addAttribute("customer", response.getBody());
		else
			model.addAttribute("customer", null);
		return "websitebyid";

	}

}
