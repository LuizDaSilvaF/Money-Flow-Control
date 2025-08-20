package luizdasilva.moneyflowcontrol.service;

import luizdasilva.moneyflowcontrol.dto.user.CreateUserDTO;
import luizdasilva.moneyflowcontrol.dto.user.UserResponseDTO;
import luizdasilva.moneyflowcontrol.entity.User;
import luizdasilva.moneyflowcontrol.exception.user.EmailAlreadyExistsException;
import luizdasilva.moneyflowcontrol.repository.UserRepository;
import luizdasilva.moneyflowcontrol.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserResponseDTO create(CreateUserDTO createUserDTO){
        UserValidator.validateCreateUser(createUserDTO);

        if(userRepository.existsByEmail(createUserDTO.email())){
            throw new EmailAlreadyExistsException(createUserDTO.email());
        }

        User user = new User();
        user.setName(createUserDTO.name());
        user.setEmail(createUserDTO.email());
        user.setPassword(createUserDTO.password());

        User userSaved = userRepository.save(user);

        return new UserResponseDTO(
                userSaved.getId(),
                userSaved.getName(),
                userSaved.getEmail(),
                userSaved.getCreatedAt(),
                userSaved.getUpdatedAt()
        );
    }

    public List<UserResponseDTO> getAll(){
        return userRepository.findAll()
                .stream()
                .map(user -> new UserResponseDTO(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getCreatedAt(),
                        user.getUpdatedAt()
                ))
                .toList();
    }

    public UserResponseDTO getById(UUID id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isEmpty()){
            throw new RuntimeException("User not found.");
        }

        User user = optionalUser.get();

        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}
