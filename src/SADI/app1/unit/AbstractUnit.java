package SADI.app1.unit;

public abstract class AbstractUnit {
    public String id;
    public String name;

    public AbstractUnit(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract String getId();
    public abstract String getName();
}
