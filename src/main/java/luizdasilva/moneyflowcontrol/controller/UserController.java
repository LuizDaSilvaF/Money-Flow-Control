package luizdasilva.moneyflowcontrol.controller;

import jakarta.validation.Valid;
import luizdasilva.moneyflowcontrol.dto.user.CreateUserDTO;
import luizdasilva.moneyflowcontrol.dto.user.UserResponseDTO;
import luizdasilva.moneyflowcontrol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@RequestBody @Valid CreateUserDTO createUserDTO){
        return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(userService.create(createUserDTO)
                );
    }
}
