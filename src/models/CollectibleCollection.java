package models;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class CollectibleCollection {
    private static int incrementingCount = 0;
    private int collectible_ID;
    private String itemName;
    private int price;
    private String itemCondition;
    private String collectibleCategory;

    /**
     * Constructor with 4 parameters
     * @param itemName - Name of the collectable
     * @param price - Price of the collectable
     * @param itemCondition - Collectable's condition (new, like-new, used, damaged)
     * @param collectibleCategory - Category of the collectable item (comic, manga, movie, cartoon, anime, figure, statue)
     */
    public CollectibleCollection(String itemName, int price, String itemCondition, String collectibleCategory) {
        setCollectible_ID(++incrementingCount);
        setItemName(itemName);
        setPrice(price);
        setItemCondition(itemCondition);
        setCollectibleCategory(collectibleCategory);
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price > 0)
            this.price = price;
        else
            throw new IllegalArgumentException("The input price must be greater than 0");
    }

    /**
     * This method returns a list of accepted item conditions of a collectible
     */
    public static List<String> acceptedItemConditions() {
        return Arrays.asList("New", "Like-New", "Used", "Damaged");
    }

    public String getItemCondition() {
        return itemCondition;
    }

    public void setItemCondition(String itemCondition) {
        itemCondition = itemCondition.trim();
        List<String> acceptedConditions = acceptedItemConditions();
        if (acceptedConditions.contains(itemCondition))
            this.itemCondition = itemCondition;
        else
            throw new IllegalArgumentException("Condition is not accepted, accepted item conditions are: " + acceptedItemConditions());
    }

    /**
     * This method returns a list of accepted collectible categories
     */
    public static List<String> acceptedCollectibleCategories() {
        return Arrays.asList("Comic book", "Manga", "TV show", "Movie", "Cartoon", "Anime", "Figure", "Statue");
    }

    public String getCollectibleCategory() {
        return collectibleCategory;
    }

    public void setCollectibleCategory(String collectibleCategory) {
        collectibleCategory = collectibleCategory.trim();
        List<String> acceptedCategories = acceptedCollectibleCategories();
        if (acceptedCategories.contains(collectibleCategory))
            this.collectibleCategory = collectibleCategory;
        else
            throw new IllegalArgumentException("Collectible category is not accepted, accepted categories are: " + acceptedCollectibleCategories());
    }

    @Override
    public String toString() {
        return String.format("ID: %d \nItem Name: %s \nPrice: $%d \nCondition: %s \nCategory: %s \n",getCollectible_ID(), getItemName(), getPrice(), getItemCondition(), getCollectibleCategory());
    }
}
