/**
 * Created by Vahe Aghajanyan
 * Date: 11/10/2023
 * Time: 4:27 PM
 */

package am.arca.dtovalidation.controller;

import am.arca.dtovalidation.dto.UserRequest;
import am.arca.dtovalidation.entity.User;
import am.arca.dtovalidation.exception.UserNotFoundException;
import am.arca.dtovalidation.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/signup")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest) {
        return new ResponseEntity<>(service.saveUser(userRequest), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<UserRequest>> getAllUsers() {
        return ResponseEntity.ok(service.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRequest> getUserById(@PathVariable int id) throws UserNotFoundException {
        return ResponseEntity.ok(service.getUser(id));
    }
}
