package DefiningClassesLab.CarConstructors;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    public Car(String brand) {
        this.brand = brand;
        this.model = "unknown";
        this.horsePower = -1;
    }

    public Car(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("The car is: ").append(String.format("%s ",brand)).append(String.format("%s - ",model))
                .append(String.format("%d HP.",horsePower)).append(System.lineSeparator());
        return sb.toString();
    }
}
