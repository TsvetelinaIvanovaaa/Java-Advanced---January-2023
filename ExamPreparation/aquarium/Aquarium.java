package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private String name;
    private int capacity;
    private int size;
    private List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public void add(Fish fish){
        if(this.fishInPool.size() < this.capacity){
            fishInPool.add(fish);
        }
    }

    public boolean remove(String name){
        return fishInPool.removeIf(fish -> fish.getName().equals(name));
    }

    public Fish findFish(String name){
        for (Fish fish : fishInPool) {
            if(fish.getName().equals(name)){
                return fish;
            }
        }
        return null;
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Aquarium: %s ^ Size: %d",this.name, this.size));
        sb.append(System.lineSeparator());
        fishInPool.stream().forEach(fish -> sb.append(String.format("%s%n", fish.toString())));
        return sb.toString().trim();
    }
}
