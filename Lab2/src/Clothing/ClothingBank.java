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
     * Get the current size of clothing bank
     * */
    public int getSize() {
        return stock.size();
    }

    /**
     * Add new clothing
     * */
    public void addClothing(Clothing newCloth) throws IllegalArgumentException, IllegalStateException {
        if (this.stock.contains(newCloth)) {
            throw new IllegalArgumentException("This clothes is already exists in the stock");
        }
        if (stock.size() >= maxNum) {
            throw new IllegalStateException("This clothing bank is full. Cannot add new clothing anymore");
        }
        stock.add(newCloth);
    }

    /**
     * Delete certain clothing from this bank
     * Removes the first occurrence of the specified element from this stock.
     * @throws ClassCastException if the type of the specified element
     *         is not Clothing.
     */
    public boolean deleteClothing(Clothing clothing) {
        return stock.remove(clothing);
    }

    /**
     * Generate an iterator
     * if this bank never be sorted, then shuffle and sort it
     * the reason of shuffling is that the lab spec require player pick up a random gear if there isn't the best choice.
     * I don't want to reimplement the iterator of linked list, so I just return the sdk link iterator.
     * */
    @Override
    public Iterator<Clothing> iterator() {
        if (!sortFlag) {
            Collections.shuffle(stock, new Random(5010));
            Collections.sort(stock);
            sortFlag = true;
        }
        return stock.listIterator();
    }
}
