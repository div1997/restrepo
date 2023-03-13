package com.test;

import api.annotation.frameworkannotation;
import apirequestbuilder.BaseURI;
import com.api.utills.Randomdatautills;
import com.api.utills.logreportutills;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class JSONAssignment
{
    @Test
    @frameworkannotation(author={"divya"}, category = {"Smoke", "getclass"})
    public void Jsonassignment() {

        // get call
        Response res = BaseURI.buildgeturi()
                .when().get("/employee");
        int size = res.jsonPath().getList("$").size();
        logreportutills.pass(" no of user :" + size);

        //pojo


        JSONObject jobj = new JSONObject();
        jobj.put("name", Randomdatautills.getname());
        jobj.put("id", Randomdatautills.getId());
        jobj.put("email", Randomdatautills.getEmail());
        JSONObject jaddress = new JSONObject();
        jaddress.put("city", "delhi");
        jaddress.put("pincode", new Faker().number().digits(6));
        jaddress.put("houseno", new Faker().number().digit());
        jobj.put("address", jaddress);
        JSONArray jjobs = new JSONArray();
        jjobs.put("qa");
        jjobs.put("fullstack");
        jobj.put("jobs", jjobs);
        jobj.put("department", "IT");

        // postcall

        Response post_res = BaseURI.buildgeturi()
                .log()
                .all()
                .body(jobj.toString()).when().post("/employee");

        logreportutills.logresponse(post_res.prettyPrint());


        // update postcall
        int id = post_res.jsonPath().getInt("id");



        JSONObject jobj2 = new JSONObject();
        jobj2.put("name", Randomdatautills.getname());

        Response update_res =BaseURI.buildgeturi()
                .log()
                .all()
                .body(jobj2.toString()).when().patch("/employee/"+id);
        logreportutills.logresponse(update_res.prettyPrint());


        Response delete_res = BaseURI.buildgeturi().delete("/employee/"+id);
        logreportutills.logresponse(delete_res.prettyPrint());


        // verify the size
        Response res_update =BaseURI.buildgeturi()
                .when().get("/employee");
        int updatesize =res_update.jsonPath().getList("$").size();
        if(size==updatesize)
        {
            logreportutills.info_message("curd operation executed");
        }
        else {
            logreportutills.info_message("curd operation did not execute");
        }

    }



}
