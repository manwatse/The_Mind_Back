package shared;

public class EncapsulatingMessage {

    String message;
    Object object;

    public EncapsulatingMessage(String message, Object object) {
        this.message = message;
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public Object getObject() {
        return object;
    }
}
