package org.ubcmun.api.user;

import org.junit.Before;
import org.junit.Test;
import org.ubcmun.api.user.UserRepository;
import org.ubcmun.api.permission.PermissionController;
import org.ubcmun.api.user.UserModel;

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
        Throwable error = catchThrowable(() -> Class.forName("org.ubcmun.api.user.UserRepository"));

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
        PermissionController permissionController = generatePermission(0, "root");
        UserModel userModel = generateUser(1, "test", "test", permissionController);

        // When
        when(sut.findById(0)).thenReturn(userModel);

        // Then
        assertThat(sut.findById(0)).isEqualTo(userModel);
    }

    private PermissionController generatePermission(int id, String role) {
        PermissionController permissionController = new PermissionController();
        permissionController.setId(id);
        permissionController.setRole(role);
        return permissionController;
    }

    private UserModel generateUser(int id, String username, String password, PermissionController permissionController) {
        UserModel userModel = new UserModel();
        userModel.setId(id);
        userModel.setUsername(username);
        userModel.setPassword(password);
        userModel.setPermission(permissionController);
        return userModel;
    }

    @Test
    public void should_return_user_by_username_if_exists() {
        // Given
        PermissionController permissionController = generatePermission(0, "root");
        UserModel userModel1 = generateUser(1, "test", "test", permissionController);
        UserModel userModel2 = generateUser(2, "test2", "test2", permissionController);

        // When
        when(sut.findByUsername("test")).thenReturn(userModel1);
        when(sut.findByUsername("test2")).thenReturn(userModel2);

        // Then
        assertThat(sut.findByUsername("test")).isEqualTo(userModel1);
        assertThat(sut.findByUsername("test2")).isEqualTo(userModel2);
    }
}
