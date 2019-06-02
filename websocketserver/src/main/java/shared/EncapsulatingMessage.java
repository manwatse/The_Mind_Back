package shared;

public class EncapsulatingMessage {

    String message;
    String object;

    public EncapsulatingMessage(String message, String object) {
        this.message = message;
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public String getObject() {
        return object;
    }
}
