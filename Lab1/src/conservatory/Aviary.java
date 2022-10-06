package conservatory;
import bird.*;

import java.util.*;

public class Aviary {
    private static final int maxBirds = 5;
    private static int AviaryIndex = 0;
    private String location;
    private final ArrayList<Birdable> curBirdsList;

    /**
     * Using a set to record all "species level" bird names
     */
    private static final Set<String> species = new HashSet<>(Arrays.asList("Moa", "Hawk",
            "RoseringParakeet", "Swan", "BlueheadedQuaildove", "GreatAuk", "SnowyOwl"));
    private static final Set<String> exclusiveType = new HashSet<>(Arrays.asList("FlightlessBird","PreyBird","Waterfowl"));
    /**
     * default constructor. Create an empty aviary*/
    public Aviary() {
        curBirdsList = new ArrayList<>();
        this.location = "Location " + AviaryIndex;
        AviaryIndex ++;
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
    public boolean addBird(Birdable bird) {
        // Check if bird is species
        if (!species.contains(bird.getClass().getSimpleName())) {
            System.out.println("It is not a bird species.");
            return false;
        }

        // case 1, this bird is extinct
        if (bird.isExtinction()) {
            System.out.println("This is an extincted bird");
            return false;
        }
        // case 2, this is an empty aviary
        else if (this.getBirdsCount() == 0) {
            this.curBirdsList.add(bird);
            return true;
        }
        // case 3, this is a fully loaded aviary.
        else if (this.getBirdsCount() == maxBirds) {
            System.out.println("Case 3 exception. This aviary is full.");
            return false;
        }
        // case 4, this bird, or the bird in this aviary is one of these species: flightless birds, birds of prey, and waterfowl, which should not be mixed with other bird types
        else if (this.isDemanded(bird)) {
            Birdable firstBird = this.curBirdsList.get(0);
            if (firstBird.getClass().getSuperclass().getSimpleName().equals(bird.getClass().getSuperclass().getSimpleName())) {
                this.curBirdsList.add(bird);
                return true;
            } else {
                System.out.println("Case 4 exception. Demanded bird or aviary.");;
                return false;
            }

        } else {
            // Case 5, all other valid cases.
            this.curBirdsList.add(bird);
            return true;
        }
    }
    /**
     * Helper function, judge if this is a demanded bird or demanded aviary
     * Return Boolean: */
    private boolean isDemanded(Birdable bird) {
        Birdable firstBird = this.getBird(0);
        return exclusiveType.contains(bird.getClass().getSuperclass().getSimpleName()) ||
                exclusiveType.contains(firstBird.getClass().getSuperclass().getSimpleName());
    }


    /**
     * Remove a bird from this aviary by bird pointer*/
    public boolean removeBird(Birdable bird) {
        //Check input bird is a species
        if (!species.contains(bird.getClass().getSimpleName())) {
            System.out.println("It is not a bird species.");
            return false;
        }

        return this.curBirdsList.remove(bird);

    }

    /**
     * Retrieve the bird object on given index
     * */
    public Birdable getBird(int index) {
        if (index < 0) {
            System.out.printf("Index %s is smaller than ZERO.%n", index);
            return null;
        }

        try {
            return this.curBirdsList.get(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please Check the aviary size:" + e.getMessage());
            return null;
        }
    }

    /**
     * Return all birds' species name and nickname in this aviary
     * */
    @Override
    public String toString() {
        if (getBirdsCount() == 0) {
            System.out.println("This is an empty aviary");
            return "[]";
        }

        StringJoiner birdList = new StringJoiner(", ","[","]");
        for (Birdable b : this.curBirdsList) {
            birdList.add(b.toString());
        }

        return birdList.toString();
    }




}
