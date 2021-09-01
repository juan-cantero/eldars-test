package ar.com.eldars.javatest.rate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;

import ar.com.eldars.javatest.creditcard.CreditCardEnum;

public class VisaRateStrategy implements RateStrategy{

	@Override
	public BigDecimal getRate(LocalDate date) {
		
		int lastTwoDigitOfYear = Integer.valueOf(date.toString().substring(2, 4));
		
		BigDecimal year = BigDecimal.valueOf(lastTwoDigitOfYear);
		BigDecimal month = BigDecimal.valueOf(date.getMonthValue());
		
		return year.divide(month);
	}

	@Override
	public CreditCardEnum getRateStrategyName() {
		return CreditCardEnum.VISA;
	}

}
