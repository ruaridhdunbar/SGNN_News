import models.Article;
import models.Journalist;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestArticle {

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
    public void testInitiatedWithNoPageViews() {
        assertEquals(0, article.getPageViews());
    }

    @Test
    public void testAddToPageViews() {
        article.addToPageViews();
        assertEquals(1, article.getPageViews());
    }


}
