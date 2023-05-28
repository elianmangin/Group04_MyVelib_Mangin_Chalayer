package system.core;

/**
 * This class extends the Exception class.
 * <p>
 * We use it to handle a possible illegal use of the system such as trying to rent a bicycle from an offline station.
 * It's useful when we test the code to difference those error from coding error that exit the program.
 * </p>
 */
public class GeneralException extends Exception  {

	private static final long serialVersionUID = -5925653232424960697L;
	
	/** Creates a GeneralException.*/
	public GeneralException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/** Creates a GeneralException.*/
	public GeneralException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	
	/** Creates a GeneralException.*/
	public GeneralException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	
	/** Creates a GeneralException.*/
	public GeneralException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	/** Creates a GeneralException.*/
	public GeneralException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}


}

