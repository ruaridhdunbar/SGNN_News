package controllers;

import db.DBHelper;
import models.Journalist;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class JournalistController {

    public JournalistController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {


        //        SHOW
        get("/journalists/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Journalist journalist = DBHelper.find(intId, Journalist.class);
            Map<String, Object> model = new HashMap<>();
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            model.put("user", loggedInUser);
            model.put("journalist", journalist);
            model.put("template", "templates/journalists/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());



    }
}
