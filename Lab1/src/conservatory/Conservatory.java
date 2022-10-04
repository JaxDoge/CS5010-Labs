package conservatory;

import java.util.ArrayList;

public class Conservatory {
    private static final int maxAviaries = 20;

    private int aviaryIdx = 0;

    private ArrayList<Aviary> aviaryList;

    public Conservatory() {
        this.aviaryList = new ArrayList<>();
    }

    /**
     * return the length of current aviary number*/
    public int getCurrentAviaryNum() {
        return this.aviaryList.size();
    }

    public int getAviaryIdx() {
        return this.aviaryIdx;
    }

    /**
     * Check if this conservatory has enough space to accommodate another aviary
     * return: Boolean if there is enough space
     * */
    public boolean checkSpace() {
        return maxAviaries == this.getCurrentAviaryNum();
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
     * Retrieve the aviary at the specified position in this conservatory.*/
    public Aviary getAviary(int index) {
        return aviaryList.get(index);
    }

    /**
     * Directly return the aviary list*/
    public ArrayList<Aviary> getAviaryList() {
        return aviaryList;
    }
}
