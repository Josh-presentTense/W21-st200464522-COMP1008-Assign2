package models;

import java.util.Arrays;
import java.util.List;

public class VideoMedia extends CollectibleCollection{
    private String director;
    private String studio;
    private int episodes;
    private int runTime;

    /**
     * Constructor with 8 parameters
     * @param itemName - Name of the collectable
     * @param price - Price of the collectable
     * @param itemCondition - Collectable's condition (new, like-new, used, damaged)
     * @param collectibleCategory - Category of the collectable item (comic, manga, movie, cartoon, anime, figure, statue)
     * @param director - Name of the director
     * @param studio - Name of the studio
     * @param episodes - Number of episodes, a movie should be treated as 1 episode
     * @param runTime - Run time in minutes, round up. ex: 300:31 becomes 301
     */
    public VideoMedia(String itemName, int price, String itemCondition, String collectibleCategory, String director, String studio, int episodes, int runTime) {
        super(itemName, price, itemCondition, collectibleCategory);
        setDirector(director);
        setStudio(studio);
        setEpisodes(episodes);
        setRunTime(runTime);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        director = director.trim();
        if (director.length() > 2)
            this.director = director;
        else
            throw new IllegalArgumentException("Director's name must be greater than 2 characters in length");
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        studio = studio.trim();
        if (studio.length() > 2)
            this.studio = studio;
        else
            throw new IllegalArgumentException("The studio's name must be greater than 2 characters in length");
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        if (episodes > 0)
            this.episodes = episodes;
        else
            throw new IllegalArgumentException("episode count must be greater than 0. For a movie, entering 1 is fine");
    }

    public int getRunTime() {
        return runTime;
    }

    public void setRunTime(int runTime) {
        if (runTime > 0)
            this.runTime = runTime;
        else
            throw new IllegalArgumentException("Video runtime must be greater than 1. Run time should entered, round up");
    }

    /**
     * This method returns a list of collectible categories for the VideoMedia subclass
     */
    public static List<String> videoMediaCategories() {
        return Arrays.asList("TV show", "Movie", "Cartoon", "Anime");
    }

    @Override
    public String toString() {
        return String.format("%s \tPrice: $%d \tCondition: %s \tCategory: %s \tDirector: %s \tStudio: %s \tepisodes: %d \tRun Time: %d", getItemName(), getPrice(), getItemCondition(), getCollectibleCategory(), director, studio, episodes, runTime);
    }
}
