package models;

import java.util.Arrays;
import java.util.List;

public class PrintMedia extends CollectibleCollection{
    private String author;
    private String illustrator;
    private String publisher;
    private int pageCount;

    /**
     * Constructor with 8 parameters
     * @param itemName - Name of the collectable
     * @param price - Price of the collectable
     * @param itemCondition - Collectable's condition (new, like-new, used, damaged)
     * @param collectibleCategory - Category of the collectable item (comic, manga, movie, cartoon, anime, figure, statue)
     * @param author - Name of the author
     * @param illustrator - Name of the illustrator
     * @param publisher - Name of the publishing company
     * @param pageCount - Page count
     */
    public PrintMedia(String itemName, int price, String itemCondition, String collectibleCategory, String author, String illustrator, String publisher, int pageCount) {
        super(itemName, price, itemCondition, collectibleCategory);
        setAuthor(author);
        setIllustrator(illustrator);
        setPublisher(publisher);
        setPageCount(pageCount);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        author = author.trim();
        if (author.length() > 2)
            this.author = author;
        else
            throw new IllegalArgumentException("Author name must be greater than 2 characters in length");
    }

    public String getIllustrator() {
        return illustrator;
    }

    public void setIllustrator(String illustrator) {
        illustrator = illustrator.trim();
        if (illustrator.length() > 2)
            this.illustrator = illustrator;
        else
            throw new IllegalArgumentException("Illustrator name must be greater than 2 characters in length");
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        publisher = publisher.trim();
        if (publisher.length() > 2)
            this.publisher = publisher;
        else
            throw new IllegalArgumentException("Publisher name must be greater than 2 characters in length");
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        if (pageCount > 0)
            this.pageCount = pageCount;
        else
            throw new IllegalArgumentException("Page count must be greater than 0");
    }

    /**
     * This method returns a list of collectible categories for the PrintMedia subclass
     */
    public static List<String> printMediaCategories() {
        return Arrays.asList("Comic book", "Manga");
    }

    @Override
    public String toString() {
        return String.format("ID:%d %s - $%d, %s, %s, %s, %s, %s, Page Count: %d",getCollectible_ID(), getItemName(), getPrice(), getItemCondition(), getCollectibleCategory(), author, illustrator, publisher, pageCount);
    }
}
