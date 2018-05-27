package models;

import db.DBHelper;

import javax.persistence.*;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Entity
@Table(name = "articles")
public class Article {

    private int id;
    private Journalist journalist;
    private String headline;
    private String summary;
    private String story;
    private Calendar dateCreated;
    private CategoryType category;
    private int pageViews;

    public Article() {
    }

    public Article(Journalist journalist, String headline, String summary, String story, CategoryType category) {
        this.journalist = journalist;
        this.headline = headline;
        this.summary = summary;
        this.story = story;
        this.dateCreated = GregorianCalendar.getInstance();
        this.category = category;
        this.pageViews = 0;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "journalist_id", nullable = false)
    public Journalist getJournalist() {
        return journalist;
    }

    public void setJournalist(Journalist journalist) {
        this.journalist = journalist;
    }

    @Column(name="headline")
    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    @Column(name="summary", length = 1024)
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Column(name="story", length = 1024)
    public String getStory() {
        this.addToPageViews();
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    @Column(name = "date_created")
    public Calendar getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Calendar dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Column(name="category")
    public CategoryType getCategory() {
        return category;
    }

    public void setCategory(CategoryType category) {
        this.category = category;
    }

    @Column(name="page_views")
    public int getPageViews() {
        return pageViews;
    }

    public void setPageViews(int pageViews) {
        this.pageViews = pageViews;
    }

    public void addToPageViews() {
        this.pageViews ++;
    }

    public String prettyDate() {
        int month = dateCreated.get(Calendar.MONTH);
        String prettyMonth = new DateFormatSymbols().getMonths()[month];
        String prettyDate = String.valueOf(dateCreated.get(Calendar.DAY_OF_MONTH)) + " " + prettyMonth + " " + String.valueOf(dateCreated.get(Calendar.YEAR));
        return prettyDate;
    }

}
