package conservatory;
import bird.*;

import java.util.ArrayList;

public class Aviary {
    private static final int maxBirds = 5;
    private final ArrayList<Bird> curBirdsList;

    /**
     * default constructor. Create an empty aviary*/
    public Aviary() {
        curBirdsList = new ArrayList<>();
    }

    /**
     * Get the current population of this aviary*/
    public int getBirdsCount() {
        return this.curBirdsList.size();
    }

    /**
     * Add a bird in this aviary
     * return Boolean: Whether this bird is successfully added*/
    public boolean addBird(Bird bird) {
        // case 1, this bird is extinct
        if (bird.isExtinction()) {
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
        // case 4, this aviary is one of these species: flightless birds, birds of prey, and waterfowl, which should not be mixed with other bird types
        else if (bird instanceof FlightlessBird || bird instanceof PreyBird || bird instanceof Waterfowl) {
            Bird firstBird = this.curBirdsList.get(0);
            if (firstBird.getClass().getSimpleName().equals(bird.getClass().getSimpleName())) {
                this.curBirdsList.add(bird);
                return true;
            } else {
                System.out.println("Case 4 exception");;
                return false;
            }

        } else {
            // Case 5, all other valid cases.
            this.curBirdsList.add(bird);
            return true;
        }
    }


}
