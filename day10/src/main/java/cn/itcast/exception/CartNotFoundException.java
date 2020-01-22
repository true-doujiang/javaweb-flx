package cn.itcast.exception;

public class CartNotFoundException extends Exception {

	
	public CartNotFoundException() {
		
	}

	public CartNotFoundException(String message) {
		super(message);
	}

	public CartNotFoundException(Throwable cause) {
		super(cause);
	}

	public CartNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	

}
