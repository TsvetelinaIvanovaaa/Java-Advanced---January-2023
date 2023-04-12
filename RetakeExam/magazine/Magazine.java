package magazine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Magazine {
    private int capacity;
    private String type;
    private List<Cloth> data;

    public Magazine(String type, int capacity) {
        this.capacity = capacity;
        this.type = type;
        this.data = new ArrayList<>();
    }

    public void addCloth(Cloth cloth){
        if(this.data.size() < this.capacity){
            data.add(cloth);
        }
    }
    public boolean removeCloth(String color){
        for (Cloth cloth : data) {
            if(cloth.getColor().equals(color)){
                data.remove(cloth);
                return true;
            }
        }
        return false;
    }
    public Cloth getSmallestCloth(){
        return data.stream().min(Comparator.comparing(Cloth::getSize))
                .orElse(null);
    }
    public Cloth getCloth(String color){
        return data.stream().filter(cloth ->
                cloth.getColor().equals(color)).findFirst().orElse(null);
    }
    public int getCount(){
        return data.size();
    }
    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s magazine contains:", this.type));
        sb.append(System.lineSeparator());
        data.forEach(cloth -> sb.append(String.format("%s%n",cloth.toString())));
        return sb.toString().trim();
    }
}
