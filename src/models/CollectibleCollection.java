package models;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class CollectibleCollection {
    private static int incrementingCount = 0;
    private int collectible_ID;
    private String itemName;
    private double price;
    private String itemCondition;
    private String collectibeCategory;

    public CollectibleCollection(String itemName, double price, String itemCondition, String collectibeCategory) {
        setCollectible_ID(++incrementingCount);
        setItemName(itemName);
        setPrice(price);
        setItemCondition(itemCondition);
        setCollectibeCategory(collectibeCategory);
    }

    public int getCollectible_ID() {
        return collectible_ID;
    }

    public void setCollectible_ID(int collectible_ID) {
        this.collectible_ID = collectible_ID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        itemName = itemName.trim();
        if (itemName.length() > 3)
            this.itemName = itemName;
        else
            throw new IllegalArgumentException("Item name must be greater than 3 characters");
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0)
            this.price = price;
        else
            throw new IllegalArgumentException("The input price must be greater than 0");
    }

    /**
     * This method returns a list of accepted item conditions of a collectible
     */
    public static List<String> acceptedItemConditions() {
        return Arrays.asList("new", "like-new", "used", "damaged");
    }

    public String getItemCondition() {
        return itemCondition;
    }

    public void setItemCondition(String itemCondition) {
        itemCondition = itemCondition.toLowerCase().trim();
        List<String> acceptedConditions = acceptedItemConditions();
        if (acceptedConditions.contains(itemCondition))
            this.itemCondition = itemCondition;
        else
            throw new IllegalArgumentException("Item condition is not accepted, accepted item conditions are: " + acceptedItemConditions());
    }

    /**
     * This method returns a list of accepted collectible categories
     */
    public static List<String> acceptedCollectibleCategories() {
        return Arrays.asList("comic", "manga", "movie", "cartoon", "anime", "figure", "statue");
    }

    public String getCollectibeCategory() {
        return collectibeCategory;
    }

    public void setCollectibeCategory(String collectibeCategory) {
        collectibeCategory = collectibeCategory.toLowerCase().trim();
        List<String> acceptedCategories = acceptedCollectibleCategories();
        if (acceptedCategories.contains(collectibeCategory))
            this.collectibeCategory = collectibeCategory;
        else
            throw new IllegalArgumentException("Collectible category is not accepted, accepted categories are: " + acceptedCollectibleCategories());
    }
}
