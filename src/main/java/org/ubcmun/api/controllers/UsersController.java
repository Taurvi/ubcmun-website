package org.ubcmun.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.ubcmun.api.models.Permission;
import org.ubcmun.api.models.User;
import org.ubcmun.api.repositories.PermissionRepository;
import org.ubcmun.api.repositories.UserRepository;

import javax.persistence.TypedQuery;
import java.util.List;

@Controller
@RequestMapping(path = "/api/users")
public class UsersController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PermissionRepository permissionRepository;

    @ResponseBody
    @GetMapping(path="/all")
    public Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }


    @ResponseBody
    @GetMapping(path="/get")
    public String getUser(@RequestParam String username, @RequestParam String password) {
        User user = userRepository.findByUsername(username);
        return user.toString();
    }

    @ResponseBody
    @GetMapping(path="/add")
    public String addUser(@RequestParam String username, @RequestParam String password, @RequestParam int permissionsId) {
        User user = new User();
        Permission permission = getPermission(permissionsId);
        user.setUsername(username);
        user.setPassword(password);
        user.setPermission(permission);

        userRepository.save(user);

        return "Successfully added user: " + username + ", password: " + password + ", with the role: " + permission.getRole();
    }

    private Permission getPermission(int id) {
        return permissionRepository.findById(id);
    }
}
