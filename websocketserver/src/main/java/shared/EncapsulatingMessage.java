package shared;

public class EncapsulatingMessage {

    private String messageType;
    private String messageData;

    public EncapsulatingMessage(String message, String object) {
        this.messageType = message;
        this.messageData = object;
    }

    public String getMessage() {
        return messageType;
    }

    public String getObject() {
        return messageData;
    }

    public void setMessage(String message) {
        this.messageType = message;
    }

    public void setObject(String object) {
        this.messageData = object;
    }
}
