package L03.P03_Exception;

public class OwnException extends Exception{
    public OwnException(String description) {
        super(description);
    }

    public OwnException(Exception e) {
        super(e);
    }
}
