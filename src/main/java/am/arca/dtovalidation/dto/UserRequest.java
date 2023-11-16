/**
 * Created by Vahe Aghajanyan
 * Date: 11/10/2023
 * Time: 4:19 PM
 */

package am.arca.dtovalidation.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor()
@NoArgsConstructor
public class UserRequest {
    @NotNull(message = "Username shouldn't be null")
    private String name;
    @Email(message = "User should have an email")
    private String email;
    @NotNull
    private String mobile;
    private String gender;
    @Min(18)
    @Max(60)
    private int age;
    @NotBlank
    private String nationality;
}
