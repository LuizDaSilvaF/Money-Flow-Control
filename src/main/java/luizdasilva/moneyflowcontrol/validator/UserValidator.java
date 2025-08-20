package luizdasilva.moneyflowcontrol.validator;

import luizdasilva.moneyflowcontrol.dto.user.CreateUserDTO;
import luizdasilva.moneyflowcontrol.dto.user.UpdateUserDTO;
import luizdasilva.moneyflowcontrol.exception.user.InvalidUserException;

public class UserValidator {

    public static void validateCreateUser(CreateUserDTO user) {
        if (user == null) {
            throw new InvalidUserException("The user cannot be null.");
        }
        if (user.name() == null || user.name().trim().isEmpty()) {
            throw new InvalidUserException("The user name is required.");
        }
        if (user.email() == null || user.email().trim().isEmpty()) {
            throw new InvalidUserException("The user email is required.");
        }
        if (!isValidEmail(user.email())) {
            throw new InvalidUserException("The user email is invalid.");
        }
        if (user.password() == null || user.password().trim().isEmpty()) {
            throw new InvalidUserException("The user password is required.");
        }
        if (user.password().length() < 8) {
            throw new InvalidUserException("The password must be at least 8 characters long.");
        }
    }

    public static void validateUpdateUser(UpdateUserDTO user) {
        if (user == null) {
            throw new InvalidUserException("The user cannot be null.");
        }

        boolean hasData = (user.name() != null && !user.name().trim().isEmpty()) ||
                (user.email() != null && !user.email().trim().isEmpty()) ||
                (user.password() != null && !user.password().trim().isEmpty());

        if (!hasData) {
            throw new InvalidUserException("At least one field must be provided to update the user.");
        }

        if (user.email() != null && !user.email().isBlank() && !isValidEmail(user.email())) {
            throw new InvalidUserException("The user email is invalid.");
        }

        if (user.password() != null && !user.password().isBlank() && user.password().length() < 8) {
            throw new InvalidUserException("The password must be at least 8 characters long.");
        }
    }

    private static boolean isValidEmail(String email) {
        if (email == null) return false;
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailRegex);
    }
}
