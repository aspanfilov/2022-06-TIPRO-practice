package L04.Ch1_IO.P06_ObjectIOStream.Node1.Domain;

import java.io.Serializable;

public class Car implements Serializable {
    static final long serialVersionUID = 1;

    private String model;
    private String color;

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
