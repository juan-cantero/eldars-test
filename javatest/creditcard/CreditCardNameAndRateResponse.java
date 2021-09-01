package ar.com.eldars.javatest.creditcard;

public class CreditCardNameAndRateResponse {
	
	private String name;
	private String rate;
	
	public CreditCardNameAndRateResponse(String name, String rate) {
		super();
		this.name = name;
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", rate=" + rate + "]";
	}
	
	
	
	

}
