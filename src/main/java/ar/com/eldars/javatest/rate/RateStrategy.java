package ar.com.eldars.javatest.rate;

import java.math.BigDecimal;
import java.time.LocalDate;

import ar.com.eldars.javatest.creditcard.CreditCardEnum;

public interface RateStrategy {
	
	BigDecimal getRate(LocalDate date);
	CreditCardEnum getRateStrategyName();
}
