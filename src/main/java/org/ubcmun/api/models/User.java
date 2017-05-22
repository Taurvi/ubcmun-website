package org.ubcmun.api.models;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "users")
@Data
public class User {
    private int id;
    private String username;
    private String password;
    private Permission permission;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "permissions_id")
    public Permission getPermission() {
        return permission;
   }
}
