package org.ubcmun.api.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
    UserModel findById(int id);
    UserModel findByUsername(String username);
}
