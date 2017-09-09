package org.ubcmun.api.permission;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "permissions")
@Data
public class PermissionController {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String role;
}
