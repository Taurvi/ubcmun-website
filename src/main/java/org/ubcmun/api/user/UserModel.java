package org.ubcmun.api.user;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Component;
import org.ubcmun.api.permission.PermissionController;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "users")
@Data
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    @NotEmpty(message = "You must provide a username.")
    private String username;

    @Column(name = "password")
    @Length(min = 5, message = "Password must be a minimum of 5 characters.")
    @NotEmpty(message = "You must provide a password.")
    private String password;

    @ManyToOne
    @JoinColumn(name = "permissions_id")
    private PermissionController permission;
}
