package model.entities;

public enum Role {
    ADMIN(1, "ADMINISTRATOR"),
    SUPERVISOR(2, "SUPERVISOR"),
    CLIENT(3, "CLIENT");

    private final int id;
    private final String tag;

    Role (int id, String tag) {
        this.id = id;
        this.tag = tag;
    }

    public static Role fromId(int id) {
        for (Role role: Role.values()) {
            if (role.getId() == id) return role;
        }

        return null;
    }

    public int getId() { return this.id; }
    public String getTag() { return this.tag; }
}
