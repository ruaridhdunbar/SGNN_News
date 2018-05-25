import db.DBHelper;
import models.Article;
import models.CategoryType;
import models.Journalist;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class RunnerTest {

    public static void main(String[] args) {

        DBHelper.deleteAll(Journalist.class);
        DBHelper.deleteAll(Article.class);

        Journalist journalist1 = new Journalist("Hunter S Thompson");
        DBHelper.save(journalist1);

        Journalist journalist2 = new Journalist("Walter Cronkite");
        DBHelper.save(journalist2);

        Article article1 = new Article(journalist1, "Scotland 'would keep pound' in years after independence", "A long awaited SNP report says the country could later move towards introducing it's own currency.", "Nicola Sturgeon spoke today at the unveiling of a 20-ft solid gold statue of Alex Salmond in which she espoused that Scotland would become the richest country ever mere seconds after independence.", CategoryType.SCOTLAND);
        article1.setPageViews(3);
        Calendar cal = new GregorianCalendar();
        cal.set(2014, Calendar.FEBRUARY, 11);
        article1.setDateCreated(cal);

        DBHelper.save(article1);

        Article article2 = new Article(journalist1, "Kim Jong-Un gives up dictatorship to become a US-allied democracy", "In a shocking turn of events, Kim Jong-Un reveals he will have a US-style Senate and House by the end of the month", "Kim Jong-Un has revealed that a heart-to-heart with Donald Trump in which they confided their deepest fears was the catalyst for Kim to go from being a Supreme Leader to merely a normal leader. Donald Trump is expected to receive the Nobel Peace Prize next week, an honour he has described as 'yuge' and 'the most deserved peace prize ever given out in history'", CategoryType.WORLD);
        article2.setPageViews(15);
        Calendar cal2 = new GregorianCalendar();
        cal2.set(2014, Calendar.DECEMBER, 30);
        article2.setDateCreated(cal2);
        DBHelper.save(article2);

        Article article3 = new Article(journalist2, "War with Russia is imminent", "Get indoors now because its about to go off", "War with Russia is about to begin after Boris Johnson called Vladimir Putin a 'chicken' who doesn't have the 'balls' to go to war with the UK", CategoryType.UK);
        article3.setPageViews(10);
        Calendar cal3 = new GregorianCalendar();
        cal3.set(2013, Calendar.JUNE, 14);
        article3.setDateCreated(cal3);
        DBHelper.save(article3);

        Article article4 = new Article(journalist2, "War with Russia is imminent", "Get indoors now because its about to go off", "War with Russia is about to begin after Boris Johnson called Vladimir Putin a 'chicken' who doesn't have the 'balls' to go to war with the UK", CategoryType.UK);
        article4.setPageViews(8);
        DBHelper.save(article4);


        List<Article> articlesByPageViewsDescending = DBHelper.orderByPageViewsMostFirst();
        List<Article> articlesByPageViewsAscending = DBHelper.orderByPageViewsFewestFirst();

        List<Article> articlesByDateCreatedDescending = DBHelper.orderByDateCreatedNewestFirst();
        List<Article> articlesByDateCreatedAscending = DBHelper.orderByDateCreatedOldestFirst();

        List<Article> articlesByCategory = DBHelper.findByCategory(CategoryType.UK);

        List<Article> articlesByJournalist = DBHelper.articlesForJournalist(journalist1);


    }
}
