package org.ubcmun.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.ubcmun.api.permission.PermissionController;
import org.ubcmun.api.permission.PermissionRepository;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {
    private final UserRepository userRepository;

    private final DefaultUserService userService;

    @Autowired
    public UserController(UserRepository userRepository, DefaultUserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping(path="/all")
    public Iterable<UserModel> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @GetMapping(path="/get")
    public String getUser(@RequestParam String username, @RequestParam String password) {
        UserModel userModel = userRepository.findByUsername(username);
        return userModel.toString();
    }

    @GetMapping(path="/add")
    public void addUser(@RequestParam String username, @RequestParam String password, @RequestParam int permissionsId) {
        userService.saveUser(username, password, permissionsId);
    }
}
