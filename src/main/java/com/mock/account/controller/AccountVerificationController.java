package com.mock.account.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountVerificationController {
	
	static Collection<String> accountlist = new ArrayList<String>();
	
	@GetMapping(value="/account/v1/verify/{accountno}")
	public ResponseEntity<String> verifyAccount(@PathVariable("accountno") String accountno)
	{
		if(accountlist.contains(accountno))
			return new ResponseEntity<String>("Approved", HttpStatus.OK);
		return new ResponseEntity<String>("Declined" , HttpStatus.NOT_FOUND);
		
	}
	
	static {
				accountlist.add("11001122");
				accountlist.add("11001123");
				accountlist.add("11001124");
		
		
	}

}
