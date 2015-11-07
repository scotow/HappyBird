package HappyBird.Exception;

public class BoundsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String error;
	
	public BoundsException(String error){
		this.error = error;
	}
	
	public void boundsMessageError(){
		System.err.println("Ce type n'existe pas : "+error);
		printStackTrace();
	}

}
