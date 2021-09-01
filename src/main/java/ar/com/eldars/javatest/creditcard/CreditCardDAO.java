package ar.com.eldars.javatest.creditcard;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class CreditCardDAO implements ICreditCardDAO {
	
	private final static Map<String,CreditCard> creditCardMap;
			
			static {
				CreditCard creditCard = new CreditCard();
				creditCard.setName("VISA");
				creditCard.setCardHolder("juan perez");
				creditCard.setDateOfExpiry("12/20");
				creditCard.setCardNumber("1234123412341234");
				
				CreditCard creditCard2 = new CreditCard();
				creditCard2.setName("NARA");
				creditCard2.setCardHolder("maria luna");
				creditCard2.setDateOfExpiry("02/30");
				creditCard2.setCardNumber("1234123412341235");
			    creditCardMap = new HashMap<>();
			    creditCardMap.put("1234123412341234", creditCard);
			    creditCardMap.put("1234123412341235", creditCard2);
			    
			}
   	
	@Override
	public Optional<CreditCard> getCreditCardByNumber(String number) {
		CreditCard card = creditCardMap.get(number);
		if(card == null) return Optional.empty();
		
		return Optional.of(card);
	}

}
