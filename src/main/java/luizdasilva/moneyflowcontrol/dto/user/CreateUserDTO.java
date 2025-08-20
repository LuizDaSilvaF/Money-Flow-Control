package luizdasilva.moneyflowcontrol.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUserDTO(

        @NotBlank(message = "The user name is required.")
        String name,

        @NotBlank(message = "The user email is required.")
        @Email(message = "The user email is invalid.")
        String email,

        @NotBlank(message = "The user password is required.")
        @Size(min = 8, message = "The password must be at least 8 characters long.")
        String password
) {
}
