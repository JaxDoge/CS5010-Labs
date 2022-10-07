package conservatory;
import bird.*;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Aviary {
    private static final int maxBirds = 5;
    private static int AviaryIndex = 0;
    private final String location;
    private final ArrayList<Bird> curBirdsList;

    private AviaryDemand aviaryDemand;
    private Map<Food, Integer> aviaryFoodDemand;

    /**
     * default constructor. Create an empty aviary*/
    public Aviary() {
        curBirdsList = new ArrayList<>();
        this.location = "Location " + AviaryIndex;
        AviaryIndex ++;
        aviaryFoodDemand = new HashMap<>();
    }

    public String getLocation() {
        return this.location;
    }

    /**
     * Get the current population of this aviary*/
    public int getBirdsCount() {
        return this.curBirdsList.size();
    }

    /**
     * Add a bird in this aviary
     * return Boolean: Whether this bird is successfully added*/
    public boolean addBird(@NotNull Bird bird) {
        // case 1, this bird is extinct
        if (bird.isExtinction()) {
            System.out.println("This is an extincted bird");
            return false;
        }
        // case 2, this is an empty aviary, so it could take any bird in, excepted extincted one.
        else if (this.getBirdsCount() == 0) {
            this.curBirdsList.add(bird);
            this.aviaryDemand = bird.getAviaryDemand();
            this.updateFoodDemand(bird);
            return true;
        }
        // case 3, this is a fully loaded aviary.
        else if (this.getBirdsCount() == maxBirds) {
//            System.out.println("Case 3 exception. This aviary is full.");
            return false;
        }
        // case 4, the bird aviary demand cannot go well with this aviary
        else if (bird.getAviaryDemand() != this.aviaryDemand) {
//            System.out.println("Case 4 exception. Demanded bird or aviary.");;
            return false;
        } else {
            // Case 5, all other valid cases.
            this.curBirdsList.add(bird);
            this.updateFoodDemand(bird);
            return true;
        }
    }

    /**
     * Remove a bird from this aviary by bird pointer*/
    public boolean removeBird(Bird bird) {
        return this.curBirdsList.remove(bird);

    }

    /**
     * Retrieve the bird object on given index
     * Throw: IndexOutOfBoundsException*/
    public Bird getBird(int index) {
        return this.curBirdsList.get(index);
    }

    /**
     * Update a new bird food requirement to the aviary level total food demands
     * */
    public void updateFoodDemand(@NotNull Bird bird) {
        for (Map.Entry<Food, Integer> eachFood : bird.getFavFood().entrySet()) {
            Food eachFoodKey = eachFood.getKey();
            int eachFoodPortion = eachFood.getValue();
            this.aviaryFoodDemand.put(eachFoodKey, this.aviaryFoodDemand.getOrDefault(eachFoodKey,0) + eachFoodPortion);
        }
    }

    /**
     * Get the aviary level food demands
     * */
    public Map<Food, Integer> getAviaryFoodDemand() {
        return this.aviaryFoodDemand;
    }

    /**
     * Return a sign for any given aviary that gives a description of the birds it houses and any interesting information that it may have about that animal
     * Return String:
     * */
    public String printASign() {
        if (getBirdsCount() == 0) {
            System.out.println("This is an empty aviary");
            return "[]";
        }
        StringJoiner birdList = new StringJoiner(",\n\n","[\n","\n]");
        for (Bird b : this.curBirdsList) {
            birdList.add(b.birdSpec());
        }

        return birdList.toString();
    }

    /**
     * Return all birds' species name and nickname in this aviary
     * */
    @Override
    public String toString() {
        if (getBirdsCount() == 0) {
            System.out.println("This is an empty aviary");
            return this.getLocation();
        }

        StringJoiner birdList = new StringJoiner(", ");
        for (Bird b : this.curBirdsList) {
            birdList.add(b.toString());
        }

        return this.getLocation() + "  " + birdList;
    }

}
