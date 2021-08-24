package com.mock.account.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mock.account.model.Company;

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
	
	@PostMapping(value="/account/v1/calculate/score")
	public ResponseEntity<String> calculateScore(@RequestBody Company reqcompany)
	{
		
		if(reqcompany.getQuoteAmount() > 75000)
			return new ResponseEntity<String>("45", HttpStatus.OK);
		if(reqcompany.getQuoteAmount() >= 50000 && reqcompany.getQuoteAmount() <= 75000 )
			return new ResponseEntity<String>("65", HttpStatus.OK);
		//if(reqcompany.getQuoteAmount() < 50000 )
		return new ResponseEntity<String>("85", HttpStatus.OK);
		//return new ResponseEntity<String>("Declined" , HttpStatus.NOT_FOUND);
		
	}
	
	static {
				accountlist.add("11001122");
				accountlist.add("11001123");
				accountlist.add("11001124");
		
		
	}

}
