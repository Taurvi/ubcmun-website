package org.ubcmun.api.user;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

public class UserModelTest {
    @Test
    public void should_exist() {
        // Given
        // When
        Throwable error = catchThrowable(() -> Class.forName("org.ubcmun.api.user.UserModel"));

        // Then
        assertThat(error).isNull();
    }
}
