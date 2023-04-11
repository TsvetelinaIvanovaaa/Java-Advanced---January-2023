package parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
    public void add(Parrot parrot){
        if(this.data.size() < this.capacity){
            data.add(parrot);
        }
    }
    public boolean remove(String name){
        return data.removeIf(parrot -> parrot.getName().equals(name));
    }
    public Parrot sellParrot(String name){
        Parrot toReturn = null;
        for (Parrot parrot : data) {
            if(parrot.getName().equals(name)){
                parrot.setAvailable(false);
                return parrot;
            }
        }
        return toReturn;
    }
    public List<Parrot> sellParrotBySpecies(String species){
        List<Parrot> sellParrotBySpecies = new ArrayList<>();
        for (Parrot parrot : data) {
            if(parrot.getSpecies().equals(species)){
                parrot.setAvailable(false);
                sellParrotBySpecies.add(parrot);
            }
        }
        return sellParrotBySpecies;
    }
    public int count(){
        return data.size();
    }
    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Parrots available at %s:",this.name));
        sb.append(System.lineSeparator());
        for (Parrot parrot : this.data) {
            if(parrot.isAvailable()){
                sb.append(parrot.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
