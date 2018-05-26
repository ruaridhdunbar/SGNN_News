package controllers;

import db.DBHelper;
import models.Article;
import models.CategoryType;
import models.Journalist;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.head;
import static spark.Spark.post;

public class ArticleController {

    public ArticleController() {
        this.setupEndPoints();
    }

    private void setupEndPoints() {

        //        INDEX
        get("/articles", (req, res) -> {
            List<Article> managers = DBHelper.getAll(Article.class);
            HashMap<String, Object> model = new HashMap<>();
            model.put("articles", managers);
            model.put("template", "templates/articles/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        //          NEW
        get("/admin/articles/new", (req, res) -> {
            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
            HashMap<String, Object> model = new HashMap<>();
            model.put("journalist", journalists);
            model.put("template", "templates/articles/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        //        SHOW
        get("/articles/:id", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            Article manager = DBHelper.find(id, Article.class);
            HashMap<String, Object> model = new HashMap<>();
            model.put("article", manager);
            model.put("template", "templates/articles/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        //        CREATE
        post("/admin/articles", (req, res) -> {
            int journalistId = Integer.parseInt(req.queryParams("journalist"));
            Journalist journalist = DBHelper.find(journalistId, Journalist.class);
            String headline = req.queryParams("headline");
            String summary = req.queryParams("summary");
            String story = req.queryParams("story");
            int ordinal = Integer.parseInt(req.queryParams("category"));
            CategoryType category = CategoryType.values()[ordinal];

            Article newArticle = new Article(journalist, headline, summary, story, category);

            DBHelper.save(newArticle);
            res.redirect("/admin");
            return null;
        });


        //        EDIT
        get("/admin/articles/:id/edit", (req, res) -> {
            String stringId = req.params(":id");
            Integer intId = Integer.parseInt(stringId);
            Article article = DBHelper.find(intId, Article.class);
            List<Journalist> journalists = DBHelper.getAll(Journalist.class);

            Map<String, Object> model = new HashMap<>();
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            model.put("user", loggedInUser);
            model.put("journalists", journalists);
            model.put("template", "templates/article/edit.vtl");
            model.put("article", article);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        //        UPDATE
        post("/admin/articles/:id", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            Article article = DBHelper.find(id, Article.class);
            int journalistId = Integer.parseInt(req.queryParams("journalist"));
            Journalist journalist = DBHelper.find(journalistId, Journalist.class);
            article.setHeadline(req.queryParams("headline"));
            article.setSummary(req.queryParams("summary"));
            article.setStory(req.queryParams("story"));
            int ordinal = Integer.parseInt(req.queryParams("category"));
            CategoryType category = CategoryType.values()[ordinal];
            article.setCategory(category);

            DBHelper.save(article);
            res.redirect("/admin");
            return null;
        });


        //        DELETE
        post("/admin/article/:id/delete", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            Article article = DBHelper.find(id, Article.class);
            DBHelper.delete(article);
            res.redirect("/admin");
            return null;
        });


    }
}
