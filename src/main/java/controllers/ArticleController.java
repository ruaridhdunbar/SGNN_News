package controllers;

import db.DBHelper;
import models.Article;
import models.CategoryType;
import models.Journalist;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Set;


import static spark.Spark.get;


public class ArticleController {

    public ArticleController() {
        this.setupEndPoints();
    }

    private void setupEndPoints() {

        //        INDEX ALL ARTICLES BY NEWEST FIRST
        get("/articles/newest-articles", (req, res) -> {
            List<Article> articles = DBHelper.orderByDateCreatedNewestFirst();
            HashMap<String, Object> model = new HashMap<>();
            model.put("articles", articles);
            model.put("template", "templates/articles/all-articles-newest.vtl");
            return new ModelAndView(model, "templates/newslayout.vtl");
        }, new VelocityTemplateEngine());

        //        INDEX ALL ARTICLES BY OLDEST FIRST
        get("/articles/oldest-articles", (req, res) -> {
            List<Article> articles = DBHelper.orderByDateCreatedOldestFirst();
            HashMap<String, Object> model = new HashMap<>();
            model.put("articles", articles);
            model.put("template", "templates/articles/all-articles-oldest.vtl");
            return new ModelAndView(model, "templates/newslayout.vtl");
        }, new VelocityTemplateEngine());

        //        INDEX ALL ARTICLES BY MOST NUMBER OF VIEWS
        get("/articles/most-popular", (req, res) -> {
            List<Article> articles = DBHelper.orderByPageViewsMostFirst();
            HashMap<String, Object> model = new HashMap<>();
            model.put("articles", articles);
            model.put("template", "templates/articles/all-articles-most-popular.vtl");
            return new ModelAndView(model, "templates/newslayout.vtl");
        }, new VelocityTemplateEngine());

        //        SHOW CATEGORIES MAIN PAGE (DEFAULT TO SCOTLAND)
        get("/articles/categories", (req, res) -> {
            List<Article> categoryArticles = DBHelper.findByCategoryNewestFirst(CategoryType.SCOTLAND);
            List<Article> articles = DBHelper.getAll(Article.class);
            HashMap<String, Object> model = new HashMap<>();
            Set<CategoryType> categories = EnumSet.allOf(CategoryType.class);
            model.put("categoryArticles", categoryArticles);
            model.put("categories", categories);
            model.put("articles", articles);
            model.put("template", "templates/articles/all-categories.vtl");
            return new ModelAndView(model, "templates/newslayout.vtl");
        }, new VelocityTemplateEngine());


        //        SHOW CATEGORIES ARTICLES
        get("/articles/categories/:category", (req, res) -> {
            CategoryType category = CategoryType.valueOf(req.params("category"));
            List<Article> categoryArticles = DBHelper.findByCategoryNewestFirst(category);
            List<Article> articles = DBHelper.getAll(Article.class);
            HashMap<String, Object> model = new HashMap<>();
            Set<CategoryType> categories = EnumSet.allOf(CategoryType.class);
            model.put("categoryArticles", categoryArticles);
            model.put("categories", categories);
            model.put("articles", articles);
            model.put("template", "templates/articles/all-categories.vtl");
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
