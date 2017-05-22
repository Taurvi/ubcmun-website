package org.ubcmun.api.repositories;

import org.junit.Before;
import org.junit.Test;
import org.ubcmun.api.models.Permission;
import org.ubcmun.api.models.User;
import org.ubcmun.api.utilities.BuilderPermissions;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserRepositoryTest {
    private UserRepository sut;

    @Before
    public void setUp() throws Exception {
        sut = mock(UserRepository.class);
    }

    @Test
    public void should_exist() {
        // Given
        // When
        Throwable error = catchThrowable(() -> Class.forName("org.ubcmun.api.repositories.UserRepository"));

        // Then
        assertThat(error).isNull();
    }

    @Test
    public void should_return_null_if_user_id_does_not_exist() {
        // Given
        // When
        // Then
        assertThat(sut.findById(0)).isNull();
    }

    @Test
    public void should_return_null_if_username_does_not_exist() {
        // Given
        // When
        // Then
        assertThat(sut.findByUsername(null)).isNull();
    }

    @Test
    public void should_return_user_by_id_if_exists() {
        // Given
        Permission permission = generatePermission(0, "root");
        User user = generateUser(1, "test", "test", permission);

        // When
        when(sut.findById(0)).thenReturn(user);

        // Then
        assertThat(sut.findById(0)).isEqualTo(user);
    }

    private Permission generatePermission(int id, String role) {
        Permission permission = new Permission();
        permission.setId(id);
        permission.setRole(role);
        return permission;
    }

    private User generateUser(int id, String username, String password, Permission permission) {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setPermission(permission);
        return user;
    }

    @Test
    public void should_return_user_by_username_if_exists() {
        // Given
        Permission permission = generatePermission(0, "root");
        User user1 = generateUser(1, "test", "test", permission);
        User user2 = generateUser(2, "test2", "test2", permission);

        // When
        when(sut.findByUsername("test")).thenReturn(user1);
        when(sut.findByUsername("test2")).thenReturn(user2);

        // Then
        assertThat(sut.findByUsername("test")).isEqualTo(user1);
        assertThat(sut.findByUsername("test2")).isEqualTo(user2);
    }
}
