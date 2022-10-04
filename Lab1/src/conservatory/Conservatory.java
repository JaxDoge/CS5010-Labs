package conservatory;

import java.util.*;
import bird.Bird;


public class Conservatory {
    private static final int maxAviaries = 20;

    private ArrayList<Aviary> aviaryList;
    private static final Set<String> species = new HashSet<>(Arrays.asList("Moa", "Hawk",
            "RoseringParakeet", "Swan", "BlueheadedQuaildove", "GreatAuk", "SnowyOwl"));


    public Conservatory() {
        this.aviaryList = new ArrayList<>();
    }

    /**
     * return the length of current aviary number*/
    public int getCurrentAviaryNum() {
        return this.aviaryList.size();
    }

    /**
     * Check if this conservatory has enough space to accommodate another aviary
     * return: Boolean if there is enough space
     * */
    public boolean checkSpace() {
        return maxAviaries > this.getCurrentAviaryNum();
    }

    /**
     * Create a new aviary in this conservatory
     * return: Boolean If successfully add a new aviary
     * avi: Aviary a aviary ready to be put in*/
    public boolean addNewAviary(Aviary avi) {
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
    public Aviary getAviary(int index) {
        if (index < 0) {
            System.out.printf("Index %s is smaller than ZERO.%n", index);
            return null;
        }

        try {
            return this.aviaryList.get(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please Check the conservatory size:" + e.getMessage());
            return null;
        }
    }

    /**
     * There is a bird need to be added in this conservatory
     * We need check each aviary and find the first suitable one
     * If there is no aviary here, we need create one
     * Return Boolean: if this bird is successfully settle here*/
    public boolean addNewBird(Bird bird) {
        // Check if bird is species
        if (!species.contains(bird.getClass().getSimpleName())) {
            System.out.println("It is not a bird species.");
            return false;
        }

        // Check if this bird is extincted
        if (bird.isExtinction()) {
            System.out.println("This is an extincted bird");
            return false;
        }

        if (this.getCurrentAviaryNum() != 0) {
            // case 1, check each aviary availability, if no one is available, create new one if possible
            for (Aviary av : this.aviaryList) {
                if (av.addBird(bird)) { return true; }
            }
        }
        // case 2, create a new aviary and put the bird in if possible
        return this.putBirdInNewAviary(bird);
    }

    /**
     * Helper function: Create a new aviary and put a new bird inside
     * Return Boolean: If it is a successful operation*/
    private boolean putBirdInNewAviary(Bird bird) {
        if(!this.checkSpace()) { return false; }
        Aviary newAv = new Aviary();
        return this.addNewAviary(newAv) && newAv.addBird(bird);
    }

    /**
     * Print out the whole conservatory
     * */
    @Override
    public String toString() {
        if (getCurrentAviaryNum() == 0) {
            System.out.println();
            return "{}";
        }
        StringJoiner sj = new StringJoiner(", ", "{", "}");
        for (Aviary av : this.aviaryList) {
            sj.add(av.toString());
        }
        return sj.toString();
    }
}
