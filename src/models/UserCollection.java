package models;

import java.util.ArrayList;
import java.util.List;

public class UserCollection {
    private static int numOfItems = 0;
    private static int totalPrice = 0;
    private static ArrayList<CollectibleCollection> collectorsItems = new ArrayList<>();

    public UserCollection(PrintMedia printMediaCollectable) {
        collectorsItems.add(printMediaCollectable);
        numOfItems += 1;
        totalPrice += printMediaCollectable.getPrice();
    }

    public UserCollection(VideoMedia videoMediaCollectable) {
        collectorsItems.add(videoMediaCollectable);
        numOfItems += 1;
        totalPrice += videoMediaCollectable.getPrice();
    }

    public UserCollection(Figure figureCollectable) {
        collectorsItems.add(figureCollectable);
        numOfItems += 1;
        totalPrice += figureCollectable.getPrice();
    }

    public static int getNumOfItems() {
        return numOfItems;
    }

    public static int getTotalPrice() {
        return totalPrice;
    }

    /**
     * Method that returns an arraylist of all print media in the user's collection
     * @return ArrayList
     */
    public ArrayList<CollectibleCollection> collectionPrintMedia() {
        ArrayList<CollectibleCollection> printMediaList = new ArrayList<>();
        List<String> printCategories = PrintMedia.printMediaCategories();
        for (CollectibleCollection collectible : collectorsItems) {
            if (printCategories.contains(collectible.getCollectibleCategory()))
                printMediaList.add(collectible);
        }
        return printMediaList;
    }

    /**
     * Method that returns an arraylist of all video media in the user's collection
     * @return ArrayList
     */
    public ArrayList<CollectibleCollection> collectionVideoMedia() {
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
    public ArrayList<CollectibleCollection> collectionFigure() {
        ArrayList<CollectibleCollection> figureList = new ArrayList<>();
        List<String> figureCategories = Figure.figureCategories();
        for (CollectibleCollection collectible : collectorsItems) {
            if (figureCategories.contains(collectible.getCollectibleCategory()))
                figureList.add(collectible);
        }
        return figureList;
    }

}
