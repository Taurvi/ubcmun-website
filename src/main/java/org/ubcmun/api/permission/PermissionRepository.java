package org.ubcmun.api.permission;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends CrudRepository<PermissionController, Long>{
    PermissionController findById(int id);
}
