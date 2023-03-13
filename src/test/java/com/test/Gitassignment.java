package com.test;

import api.annotation.frameworkannotation;
import com.api.utills.logreportutills;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Gitassignment
{
    @Test
    @frameworkannotation(author={"divya"}, category = {"Smoke", "getclass"})

    public void gitcurdassignment() {
        //getrepolistsize
        Response getrepo = given()
                .headers("accept", "application/vnd.github+json", "X-GitHub-Api-Version", "2022-11-28", "Authorization",
                        "Bearer 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")
                .get(" https://api.github.com/repos/div1997/Api_automation");

        logreportutills.logresponse(getrepo.prettyPrint());


        //create repo
        Map<String, Object> gitrepobody = new LinkedHashMap<>();
        gitrepobody.put("name", "restrepo"+ new Faker().name().title());
        gitrepobody.put("description", " created through restassured api");
        gitrepobody.put("homepage", "https://github.com");
        gitrepobody.put("private", false);
        gitrepobody.put("is_template", true);

        Response postrepo = given()
                .headers("accept", "application/vnd.github+json", "X-GitHub-Api-Version", "2022-11-28", "Authorization",
                        "Bearer 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")
                .log()
                .all()
                .body(gitrepobody)
                .post("  https://api.github.com/user/repos");
        String reponame = postrepo.jsonPath().get("name");
        logreportutills.pass("repositry name " + reponame);
        logreportutills.logresponse(postrepo.prettyPrint());

/*
        //update repo

        Map<String, Object> updategitrepobody = new LinkedHashMap<>();
        gitrepobody.put("name", "updaterestrepo"+new Faker().name().title());
        gitrepobody.put("description", " created through restassured api");
        gitrepobody.put("homepage", "https://github.com");
        gitrepobody.put("private", false);
        gitrepobody.put("is_template", true);
        Response updatepostrepo = given()
                .headers("accept", "application/vnd.github+json", "X-GitHub-Api-Version", "2022-11-28", "Authorization",
                        "Bearer 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")
                .log()
                .all()
                .body(updategitrepobody)
                .put("  https://api.github.com/repos/div1997/"+reponame);
        String updatereponame =updatepostrepo.jsonPath().get("name");
        logreportutills.pass(updatereponame);
        logreportutills.logresponse(updatepostrepo.prettyPrint());

    }
*/
        //delete repo
        Response deleterepo = given()
                .headers("accept", "application/vnd.github+json", "X-GitHub-Api-Version", "2022-11-28", "Authorization",
                        "Bearer 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")
                .delete("  https://api.github.com/repos/div1997/"+reponame);

        Assertions.assertThat(deleterepo.statusCode()).isEqualTo(204);
        logreportutills.pass("deleted");






    }



}
