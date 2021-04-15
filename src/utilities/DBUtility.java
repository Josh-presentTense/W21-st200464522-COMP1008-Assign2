package utilities;

import models.CollectibleCollection;
import models.Figure;
import models.PrintMedia;
import models.VideoMedia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBUtility {

    /**
     * This method returns the selectable categories when needing to create a new entry to the CollectionManager
     * @return ArrayList : String
     */
    public static ArrayList<String> getEntryCategories() {
        ArrayList<String> categories = new ArrayList<>();
        categories.addAll(Arrays.asList("Comic book, Manga", "TV show, Movie, Cartoon, Anime", "Figure, Statue"));
        return categories;
    }

    /**
     * This method returns the possible item conditions that a collectable could be under
     * @return ArrayList : String
     */
    public static ArrayList<String> getItemCondition() {
        ArrayList<String> conditions = new ArrayList<>();
        conditions.addAll(CollectibleCollection.acceptedItemConditions());
        return conditions;
    }

    /**
     * This method returns the categories of a collectable in the Print Media family
     * @return ArrayList : String
     */
    public static ArrayList<String> getPrintMediaCategories() {
        ArrayList<String> pmCategories = new ArrayList<>();
        pmCategories.addAll(PrintMedia.printMediaCategories());
        return pmCategories;
    }

    /**
     * This method returns the categories of a collectable in the Video Media family
     * @return ArrayList : String
     */
    public static ArrayList<String> getVideoMediaCategories() {
        ArrayList<String> vmCategories = new ArrayList<>();
        vmCategories.addAll(VideoMedia.videoMediaCategories());
        return vmCategories;
    }

    /**
     * This method returns the categories of a collectable in the Figure family
     * @return ArrayList : String
     */
    public static ArrayList<String> getFigureCategories() {
        ArrayList<String> fgCategories = new ArrayList<>();
        fgCategories.addAll(Figure.figureCategories());
        return fgCategories;
    }

    /**
     * This method returns the scale classifications
     * @return ArrayList : String
     */
    public static ArrayList<String> getScaleClassifications() {
        ArrayList<String> scaleClassifications = new ArrayList<>();
        scaleClassifications.addAll(Figure.acceptedScaleClassifications());
        return scaleClassifications;
    }
}
