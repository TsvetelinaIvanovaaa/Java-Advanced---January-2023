package easterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basket {
    private String material;
    private int capacity;
    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void addEgg(Egg egg){
        if(this.data.size() < this.capacity){
            data.add(egg);
        }
    }
    public boolean removeEgg(String color) {
        for (Egg egg : data) {
            if (egg.getColor().equals(color)) {
                data.remove(egg);
                return true;
            }
        }
        return false;
    }
    public Egg getStrongestEgg(){
        return data.stream().max(Comparator.comparing(Egg::getStrength))
                .orElse(null);
    }
    public Egg getEgg(String color){
        return data.stream().filter(egg ->
                egg.getColor().equals(color)).findFirst().orElse(null);
    }
    public int getCount(){
        return data.size();
    }
    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s basket contains:",this.material));
        sb.append(System.lineSeparator());
        data.forEach(egg -> sb.append(String.format("%s%n",egg.toString())));
        return sb.toString().trim();
    }
}
