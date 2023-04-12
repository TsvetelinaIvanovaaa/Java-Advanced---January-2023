package shelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shelter {
    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal){
        if(this.data.size() < this.capacity){
            data.add(animal);
        }
    }
    public boolean remove(String name){
        return data.removeIf(animal -> animal.getName().equals(name));
    }
    public Animal getAnimal(String name, String caretaker){
        return data.stream().filter(animal ->
                animal.getName().equals(name) && animal.getCaretaker().equals(caretaker)).findFirst().orElse(null);
    }
    public Animal getOldestAnimal(){
        return data.stream().max(Comparator.comparing(Animal::getAge)).get();
    }
    public int getCount(){
        return data.size();
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The shelter has the following animals:"));
        sb.append(System.lineSeparator());
        data.stream().forEach(animal -> sb.append(String.format("%s %s%n",animal.getName(), animal.getCaretaker())));
        return sb.toString().trim();
    }
}
