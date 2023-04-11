import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Habitat {
    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void add(Elephant elephant){
        if(this.data.size() < this.capacity){
            data.add(elephant);
        }
    }
    public boolean remove(String name){

        return data.removeIf(elephant -> elephant.getName().equals(name));
    }
    public Elephant getElephant(String retiredFrom){
        for (Elephant elephant : data) {
            if(elephant.getRetiredFrom().equals(retiredFrom)){
                return elephant;
            }
        }
        return null;
    }
    public Elephant getOldestElephant(){
        return data.stream().max(Comparator.comparing(Elephant::getAge))
                .orElse(null);
    }
    public int getAllElephants(){
        return data.size();
    }
    public String getReport(){
        StringBuilder sb = new StringBuilder();
        sb.append("Saved elephants in the park:");
        sb.append(System.lineSeparator());
        data.forEach(elephant -> sb.append(String.format("%s came from: %s%n",elephant.getName(), elephant.getRetiredFrom())));
        return sb.toString();
    }
}

