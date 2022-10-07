package conservatory;

import java.util.*;
import bird.Bird;
import bird.Food;
import org.jetbrains.annotations.NotNull;


public class Conservatory {
    private static final int maxAviaries = 20;

    private ArrayList<Aviary> aviaryList;
    protected Map<Food, Integer> conservatoryFoodDemand;
    private Map<Bird, Aviary> bird2Aviary;

    public Conservatory() {
        this.aviaryList = new ArrayList<>();
        this.conservatoryFoodDemand = new HashMap<>();
        this.bird2Aviary = new HashMap<>();
    }

    /**
     * return the length of current aviary number*/
    public int getCurrentAviaryNum() {
        return this.aviaryList.size();
    }

    /**
     * Check if this conservatory has enough space to accommodate another aviary
     * return: Boolean if there is extra space
     * */
    public boolean checkSpace() {
        return maxAviaries > this.getCurrentAviaryNum();
    }

    /**
     * Create a new aviary in this conservatory
     * return: Boolean If successfully add a new aviary
     * avi: Aviary a aviary ready to be put in*/
    public boolean addNewAviary(Aviary avi) {
        if (this.aviaryList.contains(avi)) {
            System.out.println("This aviary is already exist.");
            return false;
        }
        if (this.checkSpace()) {
            this.aviaryList.add(avi);
            return true;
        }
        else {
            System.out.println("This conservatory is fully loaded");
            return false;
        }
    }

    /**
     * Remove a given aviary by corresponding index
     * return: Boolean If this is a success operation*/
    public boolean removeAviary(Aviary avi) {
        return this.aviaryList.remove(avi);
    }

    /**
     * Retrieve the aviary at the specified position in this conservatory.
     * Return Aviary:
     * Throws: IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
     * */
//    public Aviary getAviary(int index) {
//        return this.aviaryList.get(index);
//    }

    /**
     * There is a bird need to be added in this conservatory
     * We need check each aviary and find the first suitable one
     * If there is no aviary here, we need create one
     * Return Boolean: if this bird is successfully settle here*/
    public boolean addNewBird(Bird bird) {
        // Check if this bird is extincted
        if (bird.isExtinction()) {
            System.out.println("This is an extincted bird");
            return false;
        }

        // case 1, check each aviary availability, if no one is available, create new one if possible
        for (Aviary av : this.aviaryList) {
            if (av.addBird(bird)) {
                this.updateFoodDemand(bird);
                this.updateBird2Aviary(bird, av);
                return true;
            }
        }
        // case 2, create a new aviary and put the bird in if possible
        Aviary newAvi = this.putBirdInNewAviary(bird);
        if (newAvi != null) {
            this.updateFoodDemand(bird);
            this.updateBird2Aviary(bird, newAvi);
            return true;
        }
        // case 3, cannot add this bird to conservatory for some reason
        return false;
    }

    /**
     * Helper function: Create a new aviary and put a new bird inside
     * Return Boolean: If it is a successful operation*/
    private Aviary putBirdInNewAviary(Bird bird) {
        if(!this.checkSpace()) { return null; }
        Aviary newAv = new Aviary();
        if (this.addNewAviary(newAv) && newAv.addBird(bird)) {
            return newAv;
        }
        return null;
    }

    /**
     * Update a new bird food requirement to the conservatory level total food demands
     * */
    public void updateFoodDemand(@NotNull Bird bird) {
        if (bird.getFavFood() == null) {
            return;
        }
        for (Map.Entry<Food, Integer> eachFood : bird.getFavFood().entrySet()) {
            Food eachFoodKey = eachFood.getKey();
            int eachFoodPortion = eachFood.getValue();
            this.conservatoryFoodDemand.put(eachFoodKey, this.conservatoryFoodDemand.getOrDefault(eachFoodKey,0) + eachFoodPortion);
        }
    }

    /**
     * Get the conservatory level food demands
     * */
    public Map<Food, Integer> getConservatoryFoodDemand() {
        return this.conservatoryFoodDemand;
    }

    public void updateBird2Aviary(Bird bird, Aviary aviary) {
        this.bird2Aviary.put(bird, aviary);
    }

    public Aviary checkBirdAviary(Bird bird) {
        if (this.bird2Aviary.containsKey(bird)) {
            return this.bird2Aviary.get(bird);
        } else {
            System.out.println("This bird has not been taken in yet.");
            return null;
        }
    }


    /**
     * Print out the whole conservatory
     * */
    public String printAMap() {
        if (getCurrentAviaryNum() == 0) {
            System.out.println();
            return "{}";
        }
        StringJoiner map = new StringJoiner("; \n", "{\n", "\n}");
        int i = 0;
        for (Aviary av : this.aviaryList) {
            map.add("Aviary " + i + ": " + av.toString());
            i ++;
        }
        return map.toString();
    }

    public String printAIndex() {
        if (this.bird2Aviary.isEmpty()) {
            return "[]";
        }
        List<String> allBirds = new ArrayList<>();
        for (Aviary av : this.aviaryList) {
            String location = av.getLocation();
            for (int i = 0; i < av.getBirdsCount(); i++) {
                Bird b = av.getBird(i);
                allBirds.add(b.toString() + " in " + location);
            }
        }
        Collections.sort(allBirds);
        StringJoiner sj = new StringJoiner(";\n","[\n","\n]");
        for (String s : allBirds) {
            sj.add(s);
        }
        return sj.toString();
    }
}
