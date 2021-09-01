package ar.com.eldars.javatest.operation;

public class OperationValidator {

	private final Double maxTotal = 1000d;
	
	public String validateOperation(OperationRequest operation) throws LimitAumountException {
		if (operation.getAmount() >= maxTotal) {
			throw new LimitAumountException();
		}
		return "The operation was successful";
	}
}
