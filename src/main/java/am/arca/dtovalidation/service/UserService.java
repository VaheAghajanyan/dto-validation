/**
 * Created by Vahe Aghajanyan
 * Date: 11/10/2023
 * Time: 4:22 PM
 */

package am.arca.dtovalidation.service;

import am.arca.dtovalidation.dto.UserRequest;
import am.arca.dtovalidation.entity.User;
import am.arca.dtovalidation.exception.UserNotFoundException;
import am.arca.dtovalidation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User saveUser(UserRequest userRequest) {
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

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUser(int id) throws UserNotFoundException {
        Optional<User> user = Optional.ofNullable(repository.findByUserId(id));

        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UserNotFoundException("User not found with id: " + id);
        }
    }
}
