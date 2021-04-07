package models;

public class VideoMedia extends CollectibleCollection{
    private String director;
    private String studio;
    private int episodes;
    private int runTime;

    public VideoMedia(String itemName, double price, String itemCondition, String collectibeCategory, String director, String studio, int episodes, int runTime) {
        super(itemName, price, itemCondition, collectibeCategory);
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
}
