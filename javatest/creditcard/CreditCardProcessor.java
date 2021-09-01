package ar.com.eldars.javatest.creditcard;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import ar.com.eldars.javatest.rate.RateStrategy;
import ar.com.eldars.javatest.rate.RateStrategyFactory;

public class CreditCardProcessor {
	
	private final RateStrategyFactory rateStrategyFactory= new RateStrategyFactory();
	
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
	
	public String getCreditCardNameAndRate(CreditCard creditCard,LocalDate date) {
		String creditCardName = creditCard.getName();
		CreditCardEnum credEnum = CreditCardEnum.valueOf(creditCardName.toUpperCase());
		
		RateStrategy rateStrategy = 
				rateStrategyFactory
					.getRateStrategyForCreditCard(credEnum);
		return new CreditCardNameAndRateResponse(creditCardName, 
				rateStrategy.getRate(date).toString()).toString();
	}

}
