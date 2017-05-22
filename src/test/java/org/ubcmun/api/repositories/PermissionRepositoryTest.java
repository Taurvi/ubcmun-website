package org.ubcmun.api.repositories;

import org.junit.Test;
import org.ubcmun.api.models.Permission;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PermissionRepositoryTest {
    @Test
    public void should_exist() {
        // Given
        // When
        Throwable error = catchThrowable(() -> Class.forName("org.ubcmun.api.repositories.PermissionRepository"));

        // Then
        assertThat(error).isNull();
    }

    @Test
    public void should_return_permission_by_id() {
        // Given
        PermissionRepository sut = mock(PermissionRepository.class);
        Permission permission = new Permission();
        permission.setId(0);
        permission.setRole("root");

        // When
        when(sut.findById(0)).thenReturn(permission);

        // Then
        assertThat(sut.findById(0)).isEqualTo(permission);
    }
}
