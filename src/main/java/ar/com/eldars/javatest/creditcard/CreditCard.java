package ar.com.eldars.javatest.creditcard;

public class CreditCard {
	private String name;
    private String cardNumber;
    private String cardHolder;
    private String dateOfExpiry;
	
    public CreditCard() {
	}

	public CreditCard(String name, String cardNumber, String cardHolder, String dateOfExpiry) {
		super();
		this.name = name;
		this.cardNumber = cardNumber;
		this.cardHolder = cardHolder;
		this.dateOfExpiry = dateOfExpiry;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public String getDateOfExpiry() {
		return dateOfExpiry;
	}

	public void setDateOfExpiry(String dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}

	@Override
	public String toString() {
		return "CreditCard: \n "
				+ "	name=" + name + ",\n"
				+ "	cardNumber=" + cardNumber + ",\n"
				+ "	cardHolder=" + cardHolder + ", \n"
				+ "	dateOfExpiry=" + dateOfExpiry ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardHolder == null) ? 0 : cardHolder.hashCode());
		result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
		result = prime * result + ((dateOfExpiry == null) ? 0 : dateOfExpiry.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditCard other = (CreditCard) obj;
		if (cardHolder == null) {
			if (other.cardHolder != null)
				return false;
		} else if (!cardHolder.equals(other.cardHolder))
			return false;
		if (cardNumber == null) {
			if (other.cardNumber != null)
				return false;
		} else if (!cardNumber.equals(other.cardNumber))
			return false;
		if (dateOfExpiry == null) {
			if (other.dateOfExpiry != null)
				return false;
		} else if (!dateOfExpiry.equals(other.dateOfExpiry))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	
    
    
    
    
}
