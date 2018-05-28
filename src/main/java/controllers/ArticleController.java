package controllers;

import db.DBHelper;
import models.Article;
import models.CategoryType;
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

        //        INDEX ALL ARTICLES BY NEWEST FIRST
        get("/articles/newest", (req, res) -> {
            List<Article> articles = DBHelper.orderByDateCreatedNewestFirst();
            HashMap<String, Object> model = new HashMap<>();
            model.put("articles", articles);
            model.put("template", "templates/articles/index_all_articles.vtl");
            return new ModelAndView(model, "templates/newslayout.vtl");
        }, new VelocityTemplateEngine());

        //        INDEX ALL ARTICLES BY OLDEST FIRST
        get("/articles/oldest", (req, res) -> {
            List<Article> articles = DBHelper.orderByDateCreatedOldestFirst();
            HashMap<String, Object> model = new HashMap<>();
            model.put("articles", articles);
            model.put("template", "templates/articles/index_all_articles.vtl");
            return new ModelAndView(model, "templates/newslayout.vtl");
        }, new VelocityTemplateEngine());

        //        INDEX ALL ARTICLES BY MOST NUMBER OF VIEWS
        get("/articles/most", (req, res) -> {
            List<Article> articles = DBHelper.orderByPageViewsMostFirst();
            HashMap<String, Object> model = new HashMap<>();
            model.put("articles", articles);
            model.put("template", "templates/articles/index_all_articles.vtl");
            return new ModelAndView(model, "templates/newslayout.vtl");
        }, new VelocityTemplateEngine());

        //        INDEX ALL ARTICLES BY FEWEST NUMBER OF VIEWS
        get("/articles/fewest", (req, res) -> {
            List<Article> articles = DBHelper.orderByPageViewsFewestFirst();
            HashMap<String, Object> model = new HashMap<>();
            model.put("articles", articles);
            model.put("template", "templates/articles/index_all_articles.vtl");
            return new ModelAndView(model, "templates/newslayout.vtl");
        }, new VelocityTemplateEngine());

        //        FILTER ARTICLES BY CATEGORY - NEWEST FIRST
        get("/articles/:category/newest", (req, res) -> {
            CategoryType category = CategoryType.valueOf(req.params("category"));
            List<Article> articles = DBHelper.findByCategoryNewestFirst(category);
            HashMap<String, Object> model = new HashMap<>();
            model.put("articles", articles);
            model.put("template", "templates/articles/filter_by_category_newest_first.vtl");
            return new ModelAndView(model, "templates/newslayout.vtl");
        }, new VelocityTemplateEngine());

        //        FILTER ARTICLES BY CATEGORY - OLDEST FIRST
        get("/articles/:category/oldest", (req, res) -> {
            CategoryType category = CategoryType.valueOf(req.params("category"));
            List<Article> articles = DBHelper.findByCategoryOldestFirst(category);
            HashMap<String, Object> model = new HashMap<>();
            model.put("articles", articles);
            model.put("template", "templates/articles/filter_by_category_oldest_first.vtl");
            return new ModelAndView(model, "templates/newslayout.vtl");
        }, new VelocityTemplateEngine());


        //        SHOW
        get("/articles/:id", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            Article article = DBHelper.find(id, Article.class);
            List<Article> articles = DBHelper.orderByDateCreatedNewestFirst();
            DBHelper.save(article);
            Journalist journalist = article.getJournalist();
            HashMap<String, Object> model = new HashMap<>();
            model.put("articles", articles);
            model.put("journalist", journalist);
            model.put("article", article);
            model.put("template", "templates/articles/show.vtl");
            return new ModelAndView(model, "templates/newslayout.vtl");
        }, new VelocityTemplateEngine());
    }

}
