package ar.com.eldars.javatest.creditcard;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/creditcard")
public class CreditCardResource {
	
	@Autowired
	private CreditCardProcessorService creditCardProcessorService;

	@GetMapping(value="/checkrate",produces = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<?> getRate(@RequestParam String cardNumber) {
		
		Optional<CreditCardRateResponse> responseOptional = creditCardProcessorService.getCreditCardNameAndRate(cardNumber);
		
		if(responseOptional.isEmpty()) 
			return new ResponseEntity<>("Resource not found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<CreditCardRateResponse>(responseOptional.get(),HttpStatus.OK);
		
	}
}
