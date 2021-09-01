package ar.com.eldars.javatest.rate;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.eldars.javatest.creditcard.CreditCardEnum;

@Component
public class RateStrategyFactory {

	private Map<CreditCardEnum,RateStrategy> rateStrategies;
	
	@Autowired
	public RateStrategyFactory(Set<RateStrategy> strategySet) {
		this.createStrategy(strategySet);
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
