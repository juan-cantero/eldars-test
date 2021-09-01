package ar.com.eldars.javatest.rate;

import java.math.BigDecimal;
import java.time.LocalDate;

import ar.com.eldars.javatest.creditcard.CreditCardEnum;

public class NaraRateStrategy implements RateStrategy{
	private final BigDecimal rateMultiplier = BigDecimal.valueOf(0.5); 

	@Override
	public BigDecimal getRate(LocalDate date) {
		BigDecimal month = BigDecimal.valueOf(date.getDayOfMonth());
		
		return month.multiply(rateMultiplier);
	}

	@Override
	public CreditCardEnum getRateStrategyName() {
		return CreditCardEnum.NARA;
	}

}
