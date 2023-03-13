package com.test;

import api.annotation.frameworkannotation;
import apirequestbuilder.BaseURI;
import com.api.frameworkenums;
import com.api.utills.Reportutills;
import com.api.utills.logreportutills;
import com.api.utills.reportutillsmanager;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.response.Response;
import static org.assertj.core.api.Assertions.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class GetTests
{
    @Test
    @frameworkannotation(author={"divya123","alka"}, category = {"Smoke", "getclass"})
    public void getTest()
    {
        logreportutills.info_message("get all employee");
        Response res =BaseURI.buildgeturi().get("/employee");
        String response_m = res.prettyPrint();
         logreportutills.logresponse(response_m);
        assertThat(res.getStatusCode()).isEqualTo(200).isNotEqualTo(201);
        assertThat(res.jsonPath().getList("$").size()).
                as("get employee size").isGreaterThan(2).isPositive();

    }
    @Test(dataProvider = "getData", enabled= true)
    @frameworkannotation
    public void getEmployee( int id, String name)
    {
        logreportutills.info_message("get employee by id");
      Response resemp = BaseURI.buildgeturi()
                .pathParams("id", id)
                .when().get("/employee/{id}");
      assertThat(resemp.jsonPath().getString("name")).as("employee name").isEqualTo(name);

        logreportutills.logresponse(resemp.prettyPrint());
        logreportutills.info_message("test ");
    }
@DataProvider
    public Object [][] getData()
{
    return new Object[][]
            {
                    {1, "diya verma"},
                    {2, "riya verma"}

            };
}
}


