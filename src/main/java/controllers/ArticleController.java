package controllers;

import db.DBHelper;
import models.Article;
import models.Journalist;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;


import static spark.Spark.get;


public class ArticleController {

    public ArticleController() {
        this.setupEndPoints();
    }

    private void setupEndPoints() {

        //        INDEX
        get("/articles", (req, res) -> {
            List<Article> articles = DBHelper.getAll(Article.class);
            HashMap<String, Object> model = new HashMap<>();
            model.put("articles", articles);
            model.put("template", "templates/articles/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        //        SHOW
        get("/articles/:id", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            Article article = DBHelper.find(id, Article.class);
//            article.addToPageViews();
//            String pageViews  = String.valueOf(article.getPageViews());
            Journalist journalist = article.getJournalist();
            HashMap<String, Object> model = new HashMap<>();
//            model.put("pageViews", pageViews);
            model.put("journalist", journalist);
            model.put("article", article);
            model.put("template", "templates/articles/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }

}
