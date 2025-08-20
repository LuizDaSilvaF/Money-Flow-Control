package luizdasilva.moneyflowcontrol.validator;

import luizdasilva.moneyflowcontrol.dto.user.CreateUserDTO;

public class UserValidator {

    public static void validateCreateUser(CreateUserDTO user) {
        if (user == null) {
            throw new IllegalArgumentException("The user cannot be null.");
        }
        if (user.name() == null || user.name().trim().isEmpty()) {
            throw new IllegalArgumentException("The user name is required.");
        }
        if (user.email() == null || user.email().trim().isEmpty()) {
            throw new IllegalArgumentException("The user email is required.");
        }
        if (!isValidEmail(user.email())) {
            throw new IllegalArgumentException("The user email is invalid.");
        }
        if (user.password() == null || user.password().trim().isEmpty()) {
            throw new IllegalArgumentException("The user password is required.");
        }
        if (user.password().length() < 8) {
            throw new IllegalArgumentException("The password must be at least 8 characters long.");
        }
    }

    private static boolean isValidEmail(String email) {
        if (email == null) return false;

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailRegex);
    }
}
