/**
 * Created by Vahe Aghajanyan
 * Date: 11/10/2023
 * Time: 4:22 PM
 */

package am.arca.dtovalidation.service;

import am.arca.dtovalidation.dto.UserRequest;
import am.arca.dtovalidation.dto.UserRequestMapper;
import am.arca.dtovalidation.entity.User;
import am.arca.dtovalidation.exception.UserNotFoundException;
import am.arca.dtovalidation.repository.UserRepository;
import am.arca.dtovalidation.util.validators.ObjectsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    private final UserRequestMapper userRequestMapper;
    private final ObjectsValidator<UserRequest> objectsValidator;

    public UserService(UserRequestMapper userRequestMapper, ObjectsValidator objectsValidator) {
        this.userRequestMapper = userRequestMapper;
        this.objectsValidator = objectsValidator;
    }

    public User saveUser(UserRequest userRequest) {
        /* Custom validation

        if (!this.objectsValidator.validate(userRequest).isEmpty()) {
            return this.objectsValidator.validate(userRequest);
        }

        */

        User user = User.build(
                0,
                userRequest.getName(),
                userRequest.getEmail(),
                userRequest.getMobile(),
                userRequest.getGender(),
                userRequest.getAge(),
                userRequest.getNationality()
        );
        return this.repository.save(user);
    }

    public List<UserRequest> getAllUsers() {
        return repository.findAll()
                .stream()
                .map(userRequestMapper)
                .collect(Collectors.toList());
    }

    public UserRequest getUser(int id) throws UserNotFoundException {
        Optional<User> user = Optional.ofNullable(repository.findByUserId(id));

        if (user.isPresent()) {
            return user.map(userRequestMapper).get();
        } else {
            throw new UserNotFoundException("User not found with id: " + id);
        }
    }
}
