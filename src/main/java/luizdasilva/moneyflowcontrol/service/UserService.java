package luizdasilva.moneyflowcontrol.service;

import luizdasilva.moneyflowcontrol.dto.user.CreateUserDTO;
import luizdasilva.moneyflowcontrol.dto.user.UserResponseDTO;
import luizdasilva.moneyflowcontrol.entity.User;
import luizdasilva.moneyflowcontrol.repository.UserRepository;
import luizdasilva.moneyflowcontrol.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserResponseDTO create(CreateUserDTO createUserDTO){
        UserValidator.validateCreateUser(createUserDTO);

        if(userRepository.existsByEmail(createUserDTO.email())){
            throw new RuntimeException("There is already a registered user with this email: "+createUserDTO.email());
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
}
