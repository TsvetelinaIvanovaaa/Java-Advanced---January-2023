package aquarium;

public class Fish {
    private String name;
    private String color;
    private int fins;

    public Fish(String name, String color, int fins) {
        this.name = name;
        this.color = color;
        this.fins = fins;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getFins() {
        return fins;
    }

    public void setFins(int fins) {
        this.fins = fins;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Fish: %s",getName()));
        sb.append(System.lineSeparator());
        sb.append(String.format("Color: %s",getColor()));
        sb.append(System.lineSeparator());
        sb.append(String.format("Number of fins: %d",getFins()));
        return sb.toString().trim();
    }
}
