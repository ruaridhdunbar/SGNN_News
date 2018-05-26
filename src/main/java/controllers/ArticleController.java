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





        //        SHOW
        get("/articles/:id", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            Article manager = DBHelper.find(id, Article.class);
            HashMap<String, Object> model = new HashMap<>();
            model.put("article", manager);
            model.put("template", "templates/articles/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }
}
