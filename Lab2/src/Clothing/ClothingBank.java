package Clothing;

import java.util.*;


/**
 * ClothingBank class defines the stock of all available clothes
 * User could add or remove certain cloth to or from it.
 * It will shuffle and sort all clothes in a proper timing.
 * It has a maximum capacity 10 based on lab spec.
 * */
public class ClothingBank implements Iterable<Clothing>{
    private final List<Clothing> stock;
    private boolean sortFlag;
    private static final int maxNum = 10;

    /**
     * Create an empty, new clothing bank
     * */
    public ClothingBank() {
        stock = new LinkedList<>();
        sortFlag = false;
    }

    /**
     * Add new clothing
     * */
    public void addClothing(Clothing newCloth) {
        if (stock.size() >= maxNum) {
            throw new IllegalStateException("This clothing bank is full. Cannot add new clothing anymore");
        }
        stock.add(newCloth);
    }

    /**
     * Delete certain clothing from this bank
     * */
    public void deleteClothing(Clothing clothing) {
        stock.remove(clothing);
    }

    /**
     * Generate a iterator
     * if this bank never be sorted, then shuffle and sort it
     * the reason of shuffling is that the lab spec require player pick up a random gear if there isn't the best choice.
     * I don't wanna reimplement the iterator of linked list, so I just return the sdk link iterator.
     * */
    @Override
    public Iterator<Clothing> iterator() {
        if (sortFlag) {
            Collections.shuffle(stock);
            Collections.sort(stock);
            sortFlag = true;
        }
        return stock.listIterator();
    }
}