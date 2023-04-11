package workout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Workout {
    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }
    public void addExercise(Exercise exercise){
        if(this.exerciseCount > exercises.size()){
            exercises.add(exercise);
        }
    }
    public boolean removeExercise(String name, String muscle){
        return exercises.removeIf(exercise -> exercise.getName().equals(name)
        && exercise.getMuscle().equals(muscle));
    }
    public Exercise getExercise(String name, String muscle){
        for (Exercise exercise : exercises) {
            if(exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)){
                return exercise;
            }
        }
        return null;
    }
    public Exercise getMostBurnedCaloriesExercise(){
        return exercises.stream().max(Comparator.comparing(Exercise::getBurnedCalories))
                .orElse(null);
    }
    public int getExerciseCount(){
        return exercises.size();
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Workout type: %s%n",this.type));
        exercises.forEach(exercise -> sb.append(String.format("%s%n", exercise.toString())));

        return sb.toString();
    }
}
