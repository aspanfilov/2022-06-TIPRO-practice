package L02.P06_AbstractClass;

public abstract class Animal {
    private String description;

    public Animal(String description) {
        this.description = description;
    }

    public abstract String speak();

    public String move() {
        return this.description + " передвигается";
    };

}
