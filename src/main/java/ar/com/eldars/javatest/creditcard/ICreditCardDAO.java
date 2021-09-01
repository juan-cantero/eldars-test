package ar.com.eldars.javatest.creditcard;

import java.util.Optional;

public interface ICreditCardDAO {

	Optional<CreditCard> getCreditCardByNumber(String number);

}
