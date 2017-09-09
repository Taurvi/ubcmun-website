package org.ubcmun.api.permission;

import org.junit.Test;
import org.ubcmun.api.permission.PermissionController;
import org.ubcmun.api.permission.PermissionRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PermissionRepositoryTest {
    @Test
    public void should_exist() {
        // Given
        // When
        Throwable error = catchThrowable(() -> Class.forName("org.ubcmun.api.permission.PermissionRepository"));

        // Then
        assertThat(error).isNull();
    }

    @Test
    public void should_return_permission_by_id() {
        // Given
        PermissionRepository sut = mock(PermissionRepository.class);
        PermissionController permissionController = new PermissionController();
        permissionController.setId(0);
        permissionController.setRole("root");

        // When
        when(sut.findById(0)).thenReturn(permissionController);

        // Then
        assertThat(sut.findById(0)).isEqualTo(permissionController);
    }
}
