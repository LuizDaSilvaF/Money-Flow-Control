package luizdasilva.moneyflowcontrol.controller;

import jakarta.validation.Valid;
import luizdasilva.moneyflowcontrol.dto.user.CreateUserDTO;
import luizdasilva.moneyflowcontrol.dto.user.UpdateUserDTO;
import luizdasilva.moneyflowcontrol.dto.user.UserResponseDTO;
import luizdasilva.moneyflowcontrol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@RequestBody @Valid CreateUserDTO createUserDTO){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.create(createUserDTO));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getById(@PathVariable UUID id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable UUID id){
        userService.deleteById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("User deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateById(@PathVariable UUID id, @RequestBody UpdateUserDTO updateUserDTO){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.updateById(id, updateUserDTO));
    }
}
