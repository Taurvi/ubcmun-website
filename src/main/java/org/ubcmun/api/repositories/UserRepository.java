package org.ubcmun.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.ubcmun.api.models.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findById(int id);
    User findByUsername(String username);
}
