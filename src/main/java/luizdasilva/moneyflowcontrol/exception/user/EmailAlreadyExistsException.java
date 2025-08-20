package luizdasilva.moneyflowcontrol.exception.user;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String email) {
        super("There is already a registered user with this email: " + email);
    }
}
