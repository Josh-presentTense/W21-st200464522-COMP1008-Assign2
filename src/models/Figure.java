package models;

import java.util.Arrays;
import java.util.List;

public class Figure extends CollectibleCollection{
    private String companyName;
    private String characterName;
    private String origin;
    private String scale;

    /**
     *
     * @param itemName - Name of the collectable
     * @param price - Price of the collectable
     * @param itemCondition - Collectable's condition (new, like-new, used, damaged)
     * @param collectibleCategory - Category of the collectable item (comic, manga, movie, cartoon, anime, figure, statue)
     * @param companyName - Name of the company
     * @param characterName - Name of the character the figure is based on
     * @param origin - Name of the series the character is from
     * @param scale - scale category (1/12, 1/10, 1/8, 1/7, 1/6, 1/4, 1/3, 1/2, 1/1, n/a)
     */
    public Figure(String itemName, int price, String itemCondition, String collectibleCategory, String companyName, String characterName, String origin, String scale) {
        super(itemName, price, itemCondition, collectibleCategory);
        setCompanyName(companyName);
        setCharacterName(characterName);
        setOrigin(origin);
        setScale(scale);
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        companyName = companyName.trim();
        if (companyName.length() > 2)
            this.companyName = companyName;
        else
            throw new IllegalArgumentException("Company name must be greater than 2 characters in length");
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        characterName = characterName.trim();
        if (characterName.length() > 2)
            this.characterName = characterName;
        else
            throw new IllegalArgumentException("Character name must be greater than 2 characters in length");
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        origin = origin.trim();
        if (origin.length() > 2)
            this.origin = origin;
        else
            throw new IllegalArgumentException("Figure/Statue's source material must be greater than 2 characters in length");
    }

    /**
     * This method returns a list of accepted scale classifications
     */
    public static List<String> acceptedScaleClassifications() {
        return Arrays.asList("1/12", "1/10", "1/8", "1/7", "1/6", "1/4", "1/3", "1/2", "1/1", "n/a");
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        scale = scale.toLowerCase().trim();
        List<String> acceptedScale = acceptedScaleClassifications();
        if (acceptedScale.contains(scale))
            this.scale = scale;
        else
            throw new IllegalArgumentException("Scale classification is not accepted, accepted classifications are: " + acceptedScaleClassifications());
    }

    /**
     * This method returns a list of collectible categories for the Figure subclass
     */
    public static List<String> figureCategories() {
        return Arrays.asList("Figure", "Statue");
    }

    @Override
    public String toString() {
        return String.format("%s", getItemName());
    }
}
