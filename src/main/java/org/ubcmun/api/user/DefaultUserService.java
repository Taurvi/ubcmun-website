package org.ubcmun.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.ubcmun.api.permission.PermissionController;
import org.ubcmun.api.permission.PermissionRepository;

@Service("userService")
public class DefaultUserService implements UserService{
    private UserRepository userRepository;

    private PermissionRepository permissionRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public DefaultUserService(UserRepository userRepository, PermissionRepository permissionRepository) {
        this.userRepository = userRepository;
        this.permissionRepository = permissionRepository;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public UserModel findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void saveUser(String username, String password, int permissionsId) {
        UserModel user = new UserModel();
        user.setUsername(username);

        String hashedPassword = bCryptPasswordEncoder.encode(password);
        user.setPassword(hashedPassword);

        PermissionController permission = getPermission(permissionsId);
        user.setPermission(permission);

        userRepository.save(user);
    }

    private PermissionController getPermission(int id) {
        return permissionRepository.findById(id);
    }
}
