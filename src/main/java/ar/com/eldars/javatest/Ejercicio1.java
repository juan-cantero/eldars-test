package ar.com.eldars.javatest;

import java.time.LocalDate;

import ar.com.eldars.javatest.creditcard.CreditCard;
import ar.com.eldars.javatest.creditcard.CreditCardProcessor;
import ar.com.eldars.javatest.operation.OperationRequest;
import ar.com.eldars.javatest.operation.OperationValidator;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		// creo las tarjetas
		CreditCard creditCard = new CreditCard();
		creditCard.setName("VISA");
		creditCard.setCardHolder("juan perez");
		creditCard.setDateOfExpiry("12/20");
		creditCard.setCardNumber("1234123412341234");
		
		CreditCard creditCard2 = new CreditCard();
		creditCard2.setName("NARA");
		creditCard2.setCardHolder("maria luna");
		creditCard2.setDateOfExpiry("02/30");
		creditCard2.setCardNumber("1234123412341235");
		
		// creo las operaciones
		OperationRequest op1 = new OperationRequest(999d);
		OperationRequest op2 = new OperationRequest(9999d);
		
		
		// creo el objecto encargado de procesar las tarjetas
		CreditCardProcessor processor = new CreditCardProcessor();
		
		//creo objeto que valida las operaciones
		OperationValidator validator = new OperationValidator();
		
		//obtengo info de la tarjeta
		
		System.out.println("info de la tarjeta \n" + processor.getCreditCardInfo(creditCard));
		
		//comparo las tarjetas
		System.out.println("las tarjetas son iguales? " + processor.areCreditCardsEquals( creditCard, creditCard2));
		
		// chequeo que sea valida
		System.out.println("la tarjeta es valida? " + processor.isValidCreditCard(creditCard));
		System.out.println("la tarjeta es valida? " + processor.isValidCreditCard(creditCard2));
		
		
		// nombre y tasa de la tarjeta
		System.out.println("nombre y tasa de la tarjeta: " + processor.getCreditCardNameAndRate(creditCard, LocalDate.now()));
		System.out.println("nombre y tasa de la tarjeta: " + processor.getCreditCardNameAndRate(creditCard2, LocalDate.now()));
		
		
		// valido operaciones
		try {
			System.out.println("valido operacion 1: " + validator.validateOperation(op1));
			System.out.println("valido operacion 2: " + validator.validateOperation(op2));
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
