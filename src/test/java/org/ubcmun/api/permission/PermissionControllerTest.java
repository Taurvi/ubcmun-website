package org.ubcmun.api.permission;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

public class PermissionControllerTest {
    @Test
    public void should_exist() {
        // Given
        // When
        Throwable error = catchThrowable(() -> Class.forName("org.ubcmun.api.permission.PermissionController"));
        // Then
        assertThat(error).isNull();
    }
}
