package ar.com.eldars.javatest.creditcard;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.eldars.javatest.rate.RateStrategy;
import ar.com.eldars.javatest.rate.RateStrategyFactory;

@Service
public class CreditCardProcessorService {
	
	@Autowired
	private ICreditCardDAO creditCardRepo;
	
	@Autowired
	private RateStrategyFactory rateStrategyFactory;
	
	public String getCreditCardInfo(CreditCard creditCard) {
		return creditCard.toString();
	}
	
	public boolean areCreditCardsEquals(CreditCard creditCard1,CreditCard creditCard2) {
		return creditCard1.equals(creditCard2);
	}
	
	public boolean isValidCreditCard(CreditCard creditCard) {
		String dateOfExpiryStr = creditCard.getDateOfExpiry();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
        YearMonth dateOfExpiry = YearMonth.parse(dateOfExpiryStr,formatter);
        return dateOfExpiry.isAfter(YearMonth.now());
	}
	
	public Optional<CreditCardRateResponse> getCreditCardNameAndRate(String creditCardNumber) {
		Optional<CreditCard> creditCardOptional = creditCardRepo.getCreditCardByNumber(creditCardNumber);
		if(creditCardOptional.isEmpty()) return Optional.empty();
		
		String creditCardName = creditCardOptional.get().getName();
		CreditCardEnum credEnum = CreditCardEnum.valueOf(creditCardName.toUpperCase());
		
		RateStrategy rateStrategy = 
				rateStrategyFactory
					.getRateStrategyForCreditCard(credEnum);
		return Optional.of (new CreditCardRateResponse(creditCardName, 
				rateStrategy.getRate(LocalDate.now()).toString()));
	}

}
