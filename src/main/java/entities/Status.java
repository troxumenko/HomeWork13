package entities;

public class Status {

    public Status() {
    }

    public Status(String alias, String description) {
        this.alias = alias;
        this.description = description;
    }

    public Status(int id, String alias, String description) {
        this.id = id;
        this.alias = alias;
        this.description = description;
    }

    private int id;
    private String alias;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Status{" +
                "alias='" + alias + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
