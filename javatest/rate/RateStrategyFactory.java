package ar.com.eldars.javatest.rate;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import ar.com.eldars.javatest.creditcard.CreditCardEnum;

public class RateStrategyFactory {

	private Map<CreditCardEnum,RateStrategy> rateStrategies;
	
	public RateStrategyFactory() {
		this.createStrategy(Set.of(new VisaRateStrategy(),new NaraRateStrategy()));
	}
	
	public Map<CreditCardEnum,RateStrategy> getStrategies() {
		return this.rateStrategies;
	}
	
	public RateStrategy getRateStrategyForCreditCard(CreditCardEnum creditCard)  {
		
		return rateStrategies.get(creditCard);
		
	  }
	
	private void createStrategy(Set<RateStrategy> strategySet) {
	      rateStrategies = new HashMap<CreditCardEnum, RateStrategy>();
	      strategySet.forEach( 
	    		  	strategy -> rateStrategies.put(strategy.getRateStrategyName(), strategy));
	  }
	
	
}
