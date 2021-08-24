package com.mock.account.controller;

import java.util.ArrayList;
import java.util.Collection;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mock.account.model.Company;
import com.mock.account.model.Score;

@RestController
public class AccountVerificationController {
	
	static Collection<String> accountlist = new ArrayList<String>();
	private static final Gson gson = new Gson();
	
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
	
	@PostMapping(value="/account/v1/calculate/score", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Score> calculateScore(@RequestBody Company reqcompany)
	{
		Score score = new Score();
		if(reqcompany.getQuoteAmount() > 75000)
			score.setVal(45);
		if(reqcompany.getQuoteAmount() >= 50000 && reqcompany.getQuoteAmount() <= 75000 )
			score.setVal(65);
		else
			score.setVal(85);
		
		//return ResponseEntity.ok(gson.toJson("This is a String"));
		//return new ResponseEntity<String>("Declined" , HttpStatus.NOT_FOUND);
		 
		 return new ResponseEntity<Score>(score, HttpStatus.OK);
		
	}
	
	static {
				accountlist.add("11001122");
				accountlist.add("11001123");
				accountlist.add("11001124");
		
		
	}

}
