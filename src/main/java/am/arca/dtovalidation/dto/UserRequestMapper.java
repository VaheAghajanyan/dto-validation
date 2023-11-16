/**
 * Created by Vahe Aghajanyan
 * Date: 11/16/2023
 * Time: 3:08 PM
 */

package am.arca.dtovalidation.dto;

import am.arca.dtovalidation.entity.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserRequestMapper implements Function<User, UserRequest> {
    @Override
    public UserRequest apply(User user) {
        return new UserRequest(
                user.getName(),
                user.getEmail(),
                user.getMobile(),
                user.getGender(),
                user.getAge(),
                user.getNationality()
        );
    }
}
