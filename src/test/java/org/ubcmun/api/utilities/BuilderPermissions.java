package org.ubcmun.api.utilities;


import lombok.Builder;
import org.ubcmun.api.models.Permission;

@Builder(builderClassName = "Builder")
public class BuilderPermissions {
    private int id;
    private String role;

    public static class Builder {
        int id = 0;
        String role = "root";
    }
}
