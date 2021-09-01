package ar.com.eldars.javatest.creditcard;

public class CreditCardRateResponse {
	
	private String name;
	private String rate;
	
	
	
	public CreditCardRateResponse() {
	}

	public CreditCardRateResponse(String name, String rate) {
		super();
		this.name = name;
		this.rate = rate;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", rate=" + rate + "]";
	}
	
	
	
	

}
