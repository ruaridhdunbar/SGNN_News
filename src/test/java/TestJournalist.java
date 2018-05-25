import models.Article;
import models.Journalist;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestJournalist {

    private Journalist journalist;
    private Article article;
    private Article article2;

    @Before
    public void before(){
        journalist = new Journalist("Hunter S Thompson");
        article = new Article();
        article2 = new Article();
    }

    @Test
    public void articleListStartsEmpty(){
        assertEquals(0, journalist.articleCount());
    }

    @Test
    public void canAddArticle(){
        journalist.addArticle(article);
        assertEquals(1, journalist.articleCount());
    }

    @Test
    public void canRemoveArticle(){
        journalist.addArticle(article);
        journalist.addArticle(article2);
        journalist.removeArticle(article);
        assertEquals(1, journalist.articleCount());

    }


}
