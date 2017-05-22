package org.ubcmun.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.ubcmun.api.models.Permission;

import java.util.List;

@Repository
public interface PermissionRepository extends CrudRepository<Permission, Long>{
    Permission findById(int id);
}
