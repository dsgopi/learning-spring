package com.projects.accounts.mgmt.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acctmgmt")
public class AccountsManagementController {
	
	@GetMapping("/health/check")
	public String health() {
		
		return "Accounts Management Working...";
	}

}
