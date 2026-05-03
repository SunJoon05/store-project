package model.entities;

public enum Permission {
    USERS_HANDLE("users", "handle"),
    USERS_CREATE("users", "create"),
    USERS_READ("users", "read"),
    USERS_UPDATE("users", "update"),
    USERS_DELETE("users", "delete");

    public final String resource;
    public final String action;

    Permission(String resource, String action) {
        this.resource = resource;
        this.action = action;
    }

    public static Permission from(String resource, String action) {
        for (Permission permission: values()) {
            if (permission.resource.equals(resource) && permission.action.equals(action)) {
                return permission;
            }
        }

        throw new IllegalArgumentException(
                "Permiso desconocido: " + resource + ":" + action
        );
    }
}
