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

        //        SHOW SCOTLAND ARTICLES (DEFAULT)
        get("/articles/categories/SCOTLAND", (req, res) -> {
            List<Article> categoryArticles = DBHelper.findByCategoryNewestFirst(CategoryType.SCOTLAND);
            List<Article> articles = DBHelper.getAll(Article.class);
            HashMap<String, Object> model = new HashMap<>();
            Set<CategoryType> categories = EnumSet.allOf(CategoryType.class);
            model.put("categoryArticles", categoryArticles);
            model.put("categories", categories);
            model.put("articles", articles);
            model.put("template", "templates/articles/all-categories-SCOTLAND.vtl");
            return new ModelAndView(model, "templates/newslayout.vtl");
        }, new VelocityTemplateEngine());

        //        SHOW UK ARTICLES
        get("/articles/categories/UK", (req, res) -> {
            List<Article> categoryArticles = DBHelper.findByCategoryNewestFirst(CategoryType.UK);
            List<Article> articles = DBHelper.getAll(Article.class);
            HashMap<String, Object> model = new HashMap<>();
            Set<CategoryType> categories = EnumSet.allOf(CategoryType.class);
            model.put("categoryArticles", categoryArticles);
            model.put("categories", categories);
            model.put("articles", articles);
            model.put("template", "templates/articles/all-categories-UK.vtl");
            return new ModelAndView(model, "templates/newslayout.vtl");
        }, new VelocityTemplateEngine());

        //        SHOW WORLD ARTICLES
        get("/articles/categories/WORLD", (req, res) -> {
            List<Article> categoryArticles = DBHelper.findByCategoryNewestFirst(CategoryType.WORLD);
            List<Article> articles = DBHelper.getAll(Article.class);
            HashMap<String, Object> model = new HashMap<>();
            Set<CategoryType> categories = EnumSet.allOf(CategoryType.class);
            model.put("categoryArticles", categoryArticles);
            model.put("categories", categories);
            model.put("articles", articles);
            model.put("template", "templates/articles/all-categories-WORLD.vtl");
            return new ModelAndView(model, "templates/newslayout.vtl");
        }, new VelocityTemplateEngine());

        //        SHOW TECH ARTICLES
        get("/articles/categories/TECH", (req, res) -> {
            List<Article> categoryArticles = DBHelper.findByCategoryNewestFirst(CategoryType.TECH);
            List<Article> articles = DBHelper.getAll(Article.class);
            HashMap<String, Object> model = new HashMap<>();
            Set<CategoryType> categories = EnumSet.allOf(CategoryType.class);
            model.put("categoryArticles", categoryArticles);
            model.put("categories", categories);
            model.put("articles", articles);
            model.put("template", "templates/articles/all-categories-TECH.vtl");
            return new ModelAndView(model, "templates/newslayout.vtl");
        }, new VelocityTemplateEngine());

        //        SHOW SPORTS ARTICLES
        get("/articles/categories/SPORTS", (req, res) -> {
            List<Article> categoryArticles = DBHelper.findByCategoryNewestFirst(CategoryType.SPORTS);
            List<Article> articles = DBHelper.getAll(Article.class);
            HashMap<String, Object> model = new HashMap<>();
            Set<CategoryType> categories = EnumSet.allOf(CategoryType.class);
            model.put("categoryArticles", categoryArticles);
            model.put("categories", categories);
            model.put("articles", articles);
            model.put("template", "templates/articles/all-categories-SPORTS.vtl");
            return new ModelAndView(model, "templates/newslayout.vtl");
        }, new VelocityTemplateEngine());

        //        SHOW POLITICS ARTICLES
        get("/articles/categories/POLITICS", (req, res) -> {
            List<Article> categoryArticles = DBHelper.findByCategoryNewestFirst(CategoryType.POLITICS);
            List<Article> articles = DBHelper.getAll(Article.class);
            HashMap<String, Object> model = new HashMap<>();
            Set<CategoryType> categories = EnumSet.allOf(CategoryType.class);
            model.put("categoryArticles", categoryArticles);
            model.put("categories", categories);
            model.put("articles", articles);
            model.put("template", "templates/articles/all-categories-POLITICS.vtl");
            return new ModelAndView(model, "templates/newslayout.vtl");
        }, new VelocityTemplateEngine());

        //        SHOW SCIENCE ARTICLES
        get("/articles/categories/SCIENCE", (req, res) -> {
            List<Article> categoryArticles = DBHelper.findByCategoryNewestFirst(CategoryType.SCIENCE);
            List<Article> articles = DBHelper.getAll(Article.class);
            HashMap<String, Object> model = new HashMap<>();
            Set<CategoryType> categories = EnumSet.allOf(CategoryType.class);
            model.put("categoryArticles", categoryArticles);
            model.put("categories", categories);
            model.put("articles", articles);
            model.put("template", "templates/articles/all-categories-SCIENCE.vtl");
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
