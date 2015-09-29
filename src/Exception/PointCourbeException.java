package Exception;

public class PointCourbeException extends Exception {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  private String error;
  
  public PointCourbeException() {
    super();
  }
  
  public PointCourbeException(String error) {
    this.error = error;
  }

  @Override
  public String getMessage() {
    return error;
  }
}
