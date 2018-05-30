package db;

import com.sun.tools.corba.se.idl.constExpr.Not;
import models.Article;
import models.CategoryType;
import models.Journalist;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Seeds {

    public static void seedData() {
        DBHelper.deleteAll(Journalist.class);
        DBHelper.deleteAll(Article.class);

        Journalist journalist1 = new Journalist("Hunter S Thompson");
        DBHelper.save(journalist1);

        Journalist journalist2 = new Journalist("Walter Cronkite");
        DBHelper.save(journalist2);

        Journalist journalist3 = new Journalist("Bob Woodward");
        DBHelper.save(journalist3);

        Journalist journalist4 = new Journalist("Barbara Walters");
        DBHelper.save(journalist4);

        Journalist journalist5 = new Journalist("Carl Bernstein");
        DBHelper.save(journalist5);

        Journalist journalist6 = new Journalist("Gloria Steinem");
        DBHelper.save(journalist6);


        Article article1 = new Article(journalist1, "Scotland 'would keep pound' in years after independence", "A long awaited SNP report says the country could later move towards introducing it's own currency.", "Nicola Sturgeon spoke today at the unveiling of a 20-ft solid gold statue of Alex Salmond in which she espoused that Scotland would become the richest country ever mere seconds after independence.", CategoryType.SCOTLAND, "../../images/nicola1.jpg", "../../images/nicola2.jpg");
        Calendar cal1 = new GregorianCalendar();
        cal1.set(2018, Calendar.MAY, 19);
        article1.setDateCreated(cal1);
        article1.setPageViews(15);
        DBHelper.save(article1);

        Article article2 = new Article(journalist1, "Kim Jong-Un gives up dictatorship to become a US-allied democracy", "In a shocking turn of events, Kim Jong-Un reveals he will have a US-style Senate and House by the end of the month.", "Kim Jong-Un has revealed that a heart-to-heart with Donald Trump in which they confided their deepest fears was the catalyst for Kim to go from being a Supreme Leader to merely a normal leader. Donald Trump is expected to receive the Nobel Peace Prize next week, an honour he has described as 'yuge' and 'the most deserved peace prize ever given out in history'", CategoryType.WORLD, "../../images/kim1.jpg", "../../images/kim2.jpg");
//        Calendar cal2 = new GregorianCalendar();
//        cal2.set(2018, Calendar.MAY, 20);
//        article2.setDateCreated(cal2);
//        article2.setPageViews(40);
        DBHelper.save(article2);

        Article article3 = new Article(journalist2, "War with Russia is imminent", "Get indoors now because its about to go off.", "War with Russia is about to begin after Boris Johnson called Vladimir Putin a 'chicken' who doesnt have the 'balls' to go to war with the UK", CategoryType.WORLD, "../../images/vlad1.jpg", "../../images/vlad2.jpg");
        article3.setPageViews(45);
        Calendar cal3 = new GregorianCalendar();
        cal3.set(2018, Calendar.MAY, 19);
        article3.setDateCreated(cal3);
        DBHelper.save(article3);



        Article article4 = new Article(journalist2, "Upul's Trumpet Store posts record profits", "As new stores open in New York, London and Tokyo, 'Upul's Trumpet Store posts record profits of £450 million.", "UpulCo today posted scarcely believable profits, as global demand for trumpets surged. Company directors and shareholders will be partying long into the night on the back of these yearly results. The company director, notorious for avoiding media attention, offered a brief interview to SGNN news, in which he said the results were 'really cool'.", CategoryType.UK, "../../images/trumpet1.jpg", "../../images/trumpet2.jpg");
        Calendar cal4 = new GregorianCalendar();
        cal4.set(2018, Calendar.MAY, 23);
        article4.setDateCreated(cal4);
        article4.setPageViews(35);
        DBHelper.save(article4);

        Article article5 = new Article(journalist2, "Big Daddy Kane scores first UK #1", "The Scottish Gangsta Rap' star celebrated as hit record 'Not a Statement' topped the charts.", "Eminem is looking over his shoulder as Big Daddy Kane threatens to go global with his latest smash hit. The diss track, aimed at Eminem for his perceived 'softening' of attitude and lyrics, systematically dismantles the aging rapper and makes Big Daddy Kane favourite to steal his crown as the King of rap.", CategoryType.SCOTLAND, "../../images/bdc1.jpg", "../../images/bdc2.jpg");
        Calendar cal5 = new GregorianCalendar();
        cal5.set(2018, Calendar.MAY, 27);
        article5.setDateCreated(cal5);
        DBHelper.save(article5);

        Article article6 = new Article(journalist2, "Dragon Games considered 'better than Amazon' by industry leaders", "The Glasgow based startup launched their online shop recently to critical acclaim", "Hailed by Amazon Chief, Jeff Bezos, as 'pure brilliant', Dragon Games recently launched as the one-stop portal for all your gaming needs.  Despite initial teething problems with the online basket function, industry leaders and consumers have reacted with glowing reviews", CategoryType.TECH,"../../images/dragon1.jpg", "../../images/dragon2.jpg");
        Calendar cal6 = new GregorianCalendar();
        cal6.set(2018, Calendar.MAY, 25);
        article6.setDateCreated(cal6);
        article6.setPageViews(18);
        DBHelper.save(article6);


        Article article7 = new Article(journalist3, "Trump: 'Solution found to prevent any more school shootings'", "The President today announced that he has found a solution to the scourge of school violence after working closely with NRA chiefs.", "The President today announced that he has been in close talks with NRA leader Wayne LaPierre, in relation to an epidemic of school shootings that shows no signs of stopping. Following on from LaPierre's recent assertion that 'The only thing that can stop a bad guy with a gun, is a good guy with a gun', Trump said this was the catalyst for a revelation. 'We sat down in my office, trying to think of solutions to this terrible situation. Then it came to us. If we need more good guys to stop the bad guys - who is more good and more innocent, than our nation's children? What's more, children are literally incapable of becoming a criminal until the age of 11, as they are under the federal criminal age of responsibility! Therefore, effective immediately, the 2nd Amendment will extend to all children as soon as they enter school at the age of 5. Gym classes will be scrapped and in their place will be self-defense exercises, in which they will train to exercise their right to defend themselves and their classmates.", CategoryType.WORLD, "https://s.abcnews.com/images/GMA/140131_gma_sawyer_wg.jpg", "https://upload.wikimedia.org/wikipedia/commons/c/c6/Job_Shadow_Day_-_Military_Child_%28USA%29.jpg");
        Calendar cal7 = new GregorianCalendar();
        cal7.set(2018, Calendar.MAY, 27);
        article7.setDateCreated(cal7);
        article7.setPageViews(40);
        DBHelper.save(article7);

        Article article8 = new Article(journalist4, "Real Madrid win 4th Champions League title in the last 5 years", "Led by top scorer Cristiano Ronaldo, the team beat champions of France, Germany and Italy on their way to winning the competition for the 3rd year in a row.", "Gareth Bale scored one of European football's great goals to help Real Madrid overcome Liverpool and win their third successive Champions League title as goalkeeper Loris Karius suffered a personal nightmare.Bale made his mark on another Champions League final with a magnificent overhead kick to put Real 2-1 up after 64 minutes.For Liverpool manager Jurgen Klopp, it was disappointment again - he lost his third successive final since arriving at Anfield, having suffered defeats in the League Cup and Europa League finals of 2016.", CategoryType.SPORTS, "https://statics.sportskeeda.com/editor/2018/05/34e21-1527365718-800.jpg", "https://static.standard.co.uk/s3fs-public/thumbnails/image/2018/05/26/22/203212015-soccer-football-champions-league-final-real-madrid-v-liverpool-nsc-olympic-stadium-k.jpg");
        Calendar cal8 = new GregorianCalendar();
        cal8.set(2018, Calendar.MAY, 26);
        article8.setDateCreated(cal8);
        article8.setPageViews(120);
        DBHelper.save(article8);


        Article article9 = new Article(journalist5, "'Ban cartoon characters' on unhealthy food, MPs say", "'That smug tiger is the worst and I will strike him down like Turkey Twizzlers and Irn-Bru' Jamie Oliver tells MPs to rapturous applause", "Jamie Oliver has been put under armed guard after MPs approved his plans to get rid of cartoon characters on sugary cereals, in the first stage of a plan to ban sugary cereals altogether. Police have become increasingly concerned with his security as resentment grows in Scotland. Police fear that if he goes after square sausage next, as is feared, that he could be assassinated.", CategoryType.POLITICS, "https://www.pinknews.co.uk/images/2017/10/tony-the-tiger-sq_640x345_acf_cropped.jpg", "http://www.southwalesguardian.co.uk/resources/images/4359076.jpg");
        Calendar cal9 = new GregorianCalendar();
        cal9.set(2018, Calendar.APRIL, 28);
        article9.setDateCreated(cal9);
        article9.setPageViews(160);
        DBHelper.save(article9);


        Article article10 = new Article(journalist6, "'Don't toast marshmallows on Hawaii volcano' says US government", "The US Geological Survey has responded to a social media query on whether it is safe to roast marshmallows over a volcanic vent. The answer is no.", "Kilauea in the US state of Hawaii is one of the world's most active volcanoes and it has been very active in recent weeks. Its red-hot rivers of lava have destroyed dozens of homes on Hawaii's Big Island, with 2,000 people being told to leave their properties.", CategoryType.WORLD, "https://static.independent.co.uk/s3fs-public/thumbnails/image/2018/05/28/13/hawaii-volcano.jpg", "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/hawaii-volcano-eruption-kilauea-lava-lake-soldier-1527165224.jpg");
        Calendar cal10 = new GregorianCalendar();
        cal10.set(2018, Calendar.MAY, 10);
        article10.setDateCreated(cal10);
        article10.setPageViews(95);
        DBHelper.save(article10);

        Article article11 = new Article(journalist5, "Google just gave a stunning demo of Assistant making an actual phone call", "Onstage at I/O 2018, Google showed off a jaw-dropping new capability of Google Assistant: in the not too distant future, it’s going to make phone calls on your behalf.", "The demonstration, showcased at the I/O conference by Google CEO Sundar Pichai, reveals an AI voice that sounds wholly real. Able to respond to a person who doesn’t always offer straightforward responses, the Google Assistant can maintain a conversation and intelligently complete a task with a minimal amount of instruction. Perfectly mimicking a person’s inflection, the machine’s casual “mm hmm” as the receptionist checks her schedule is spot-on.", CategoryType.TECH, "https://c.tribune.com.pk/2017/05/1412765-image-1495096501-220-640x480.jpg", "https://c.slashgear.com/wp-content/uploads/2018/05/Assistant-6-new-voices-980x620.jpg");
        Calendar cal11 = new GregorianCalendar();
        cal11.set(2018, Calendar.MAY, 15);
        article11.setDateCreated(cal11);
        article11.setPageViews(30);
        DBHelper.save(article11);

    }
}
