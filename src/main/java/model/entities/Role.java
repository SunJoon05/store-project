package model.entities;

public enum Role {
    ADMIN(1, "Administrador"),
    SUPERVISOR(2, "Supervisor"),
    CLIENT(3, "Client");

    private final int id;
    private final String tag;

    Role(int id, String tag) {
        this.id = id;
        this.tag = tag;
    }

    public int getId() { return this.id; }
    public String getTag() { return this.tag; }

    public static Role fromId(int id) {
        for (Role role: Role.values()) {
            if (role.getId() == id) return role;
        }

        return null;
    }
}
