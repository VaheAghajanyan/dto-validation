/**
 * Created by Vahe Aghajanyan
 * Date: 11/10/2023
 * Time: 4:59 PM
 */

package am.arca.dtovalidation.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}
