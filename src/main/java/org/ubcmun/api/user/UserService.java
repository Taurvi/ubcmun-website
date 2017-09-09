package org.ubcmun.api.user;

public interface UserService {
    UserModel findByUsername(String username);
    void saveUser(String username, String password, int permissionsId);
}
