package models;

import java.util.ArrayList;
import java.util.List;

public class UserCollection {
    private ArrayList<CollectibleCollection> collectorsItems;

    public UserCollection() {
        collectorsItems = new ArrayList<>();
    }

    /**
     * This method returns the number of items in the user's collection
     * @return int
     */
    public int getNumOfItems() {
        return collectorsItems.size();
    }

    /**
     * This method returns the total price of the user's collection
     * @return int
     */
    public int getTotalPrice() {
        int totalPrice = 0;
        for (CollectibleCollection collectible : collectorsItems)
            totalPrice += collectible.getPrice();
        return totalPrice;
    }

    /**
     * This method adds a collectable to the users collection
     * @param collectable - an object of CollectibleCollection (A collectable item)
     */
    public void addCollectable(CollectibleCollection collectable){
        collectorsItems.add(collectable);
    }

    /**
     * Method that returns an arraylist of all print media in the user's collection
     * @return ArrayList
     */
    public ArrayList<CollectibleCollection> getPrintMediaCollection() {
        ArrayList<CollectibleCollection> printMediaList = new ArrayList<>();
        List<String> printCategories = PrintMedia.printMediaCategories();
        for (CollectibleCollection collectible : collectorsItems) {
            if (collectible.getClass() == PrintMedia.class)
            {

            }
            if (printCategories.contains(collectible.getCollectibleCategory()))
                printMediaList.add(collectible);
        }
        return printMediaList;
    }

    /**
     * Method that returns an arraylist of all video media in the user's collection
     * @return ArrayList
     */
    public ArrayList<CollectibleCollection> getVideoMediaCollection() {
        ArrayList<CollectibleCollection> videoMediaList = new ArrayList<>();
        List<String> videoCategories = VideoMedia.videoMediaCategories();
        for (CollectibleCollection collectible : collectorsItems) {
            if (videoCategories.contains(collectible.getCollectibleCategory()))
                videoMediaList.add(collectible);
        }
        return videoMediaList;
    }

    /**
     * Method that returns an arraylist of all figures in the user's collection
     * @return ArrayList
     */
    public ArrayList<CollectibleCollection> getFigureCollection() {
        ArrayList<CollectibleCollection> figureList = new ArrayList<>();
        List<String> figureCategories = Figure.figureCategories();
        for (CollectibleCollection collectible : collectorsItems) {
            if (figureCategories.contains(collectible.getCollectibleCategory()))
                figureList.add(collectible);
        }
        return figureList;
    }

}
