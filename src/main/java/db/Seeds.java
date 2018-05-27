package db;

import models.Article;
import models.CategoryType;
import models.Journalist;

public class Seeds {

    public static void seedData(){
        DBHelper.deleteAll(Journalist.class);
        DBHelper.deleteAll(Article.class);

        Journalist journalist1 = new Journalist("Hunter S Thompson");
        DBHelper.save(journalist1);

        Journalist journalist2 = new Journalist("Walter Cronkite");
        DBHelper.save(journalist2);

        Article article1 = new Article(journalist1, "Scotland 'would keep pound' in years after independence", "A long awaited SNP report says the country could later move towards introducing it's own currency.", "Nicola Sturgeon spoke today at the unveiling of a 20-ft solid gold statue of Alex Salmond in which she espoused that Scotland would become the richest country ever mere seconds after independence.", CategoryType.SCOTLAND);
        DBHelper.save(article1);

        Article article2 = new Article(journalist1, "Kim Jong-Un gives up dictatorship to become a US-allied democracy", "In a shocking turn of events, Kim Jong-Un reveals he will have a US-style Senate and House by the end of the month", "Kim Jong-Un has revealed that a heart-to-heart with Donald Trump in which they confided their deepest fears was the catalyst for Kim to go from being a Supreme Leader to merely a normal leader. Donald Trump is expected to receive the Nobel Peace Prize next week, an honour he has described as 'yuge' and 'the most deserved peace prize ever given out in history'", CategoryType.WORLD);
        DBHelper.save(article2);

        Article article3 = new Article(journalist2, "War with Russia is imminent", "Get indoors now because its about to go off", "War with Russia is about to begin after Boris Johnson called Vladimir Putin a 'chicken' who doesnt have the 'balls' to go to war with the UK", CategoryType.UK);
        DBHelper.save(article3);

        Article article4 = new Article(journalist2, "Upul's Trumpet Store posts record profits", "As new stores open in New York, London and Tokyo, 'Upul's Trumpet Store posts record profits of £450 million","War with Russia is about to begin after Boris Johnson called Vladimir Putin a 'chicken' who doesnt have the 'balls' to go to war with the UK", CategoryType.UK);
        DBHelper.save(article4);

        Article article5 = new Article(journalist2, "Big Daddy Kane scores first UK #1", "The Scottish Gangsta Rap' star celebrated as hit record 'Not a Statement' topped the charts", "War with Russia is about to begin after Boris Johnson called Vladimir Putin a 'chicken' who doesnt have the 'balls' to go to war with the UK", CategoryType.UK);
        DBHelper.save(article5);

        Article article6 = new Article(journalist2, "Dragon Games owner still on the run", "The Scottish Gangsta Rap' star celebrated as hit record 'Not a Statement' topped the charts", "War with Russia is about to begin after Boris Johnson called Vladimir Putin a 'chicken' who doesnt have the 'balls' to go to war with the UK", CategoryType.UK);
        DBHelper.save(article6);


    }
}
