package L02.P08_MethodParameters;

public class Animal {
    public String type;

    public Animal(String description) {
        this.type = description;
    }


    public String getObjectDescription() {
        return this.toString() + " {" +
                "type='" + type + '\'' +
                '}';
    }

}
