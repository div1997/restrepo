package com.test;

import api.annotation.frameworkannotation;
import com.api.pojo.Jirafields;
import com.api.pojo.Jiraissuetype;
import com.api.pojo.Projectjira;
import com.api.pojo.Taskbody;
import com.api.utills.logreportutills;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class JiraAssignment
{

    @Test
    @frameworkannotation(author={"divya"}, category = {"Smoke", "getclass"})

    public void jiraassignment() {
        String uri= "http://172.17.48.1:8080";
        //create jira task
        Projectjira project = new Projectjira("DEM");
        Jiraissuetype issuename = new Jiraissuetype("Task");
        Taskbody fields = Taskbody.builder().project(project).summary("this is my automate first task").description("this is my description"
        ).issuetype(issuename).gettaskbody();
        Jirafields taskbody = Jirafields.builder().fields(fields).getbody();

        Response createtask = given().baseUri(uri)
                .headers("Content-Type", "Application/JSON", "Authorization",
                        "Basic ZGl5YTEyMzoxMjNAZGl5YQ==")
                .log()
                .all()
                .body(taskbody).post("/rest/api/2/issue/");

        logreportutills.logresponse(createtask.prettyPrint());

        String id = createtask.jsonPath().get("x.key");




        // update jira task
        Taskbody updatefields = Taskbody.builder().project(project).summary("this is my update automate first task").description("this is my description"
        ).issuetype(issuename).gettaskbody();
        Jirafields updatetaskbody = Jirafields.builder().fields(fields).getbody();

Response updatetask = given().baseUri(uri)
        .headers("Content-Type", "Application/JSON","Authorization","Basic ZGl5YTEyMzoxMjNAZGl5YQ=="
        )
        .body(updatetaskbody)
        .put("/rest/api/2/issue/"+id+"/editmeta");
        logreportutills.logresponse(updatetask.prettyPrint());
    }
        /*
        //add comment

        JSONObject addcomment = new JSONObject();
        addcomment.put("add", "this is my comment");
        JSONArray listcomment = new JSONArray();
        listcomment.put(addcomment);
        JSONObject update = new JSONObject();
        update.put("Comment", listcomment);

        Response comment = given()
                .headers("Content-type", "Application/JSON", "Authorization","Basic ZGl2eWFfMTIzOjEyM0BkaXY=")
                .body(update)
                .put("  http://localhost:8081/rest/api/2/issue/"+id);

        logreportutills.logresponse(comment.prettyPrint());

        // search jira task

        Response jiratask =given()
                .headers("Content-type", "Application/JSON", "Authorization","Basic ZGl2eWFfMTIzOjEyM0BkaXY=")
        .get("http://localhost:8080/rest/api/2/search?jql=summmary=this");

        logreportutills.logresponse(jiratask.prettyPrint());



    }
*/

}
