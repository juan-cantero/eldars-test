package ar.com.eldars.javatest.operation;

public class LimitAumountException extends Exception{
	 private String message;
	 
	    public LimitAumountException() {
	    	this.message = "You cannot spend more than the limit amount";
	    	
	    }
	    
	    public String getMessage() {
	        return message;
	    }

}
