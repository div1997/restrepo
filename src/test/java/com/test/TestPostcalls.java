package com.test;

import api.annotation.frameworkannotation;
import com.api.com.api.constant.Constantdata;
import com.api.pojo.employee;
import apirequestbuilder.BaseURI;
import com.api.utills.*;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.*;
public class TestPostcalls
{
    @Test
    @frameworkannotation
    public void create_employee()
    {
        logreportutills.info_message("create employee with builder design pattern");

        employee emp = employee.builder().setName(Randomdatautills.getname())
                .setId(Randomdatautills.getId())
                .setEmail(Randomdatautills.getEmail()).build();
        RequestSpecification requestdetails  = BaseURI.buildgeturi().body(emp);
       logreportutills.logrequest(requestdetails);
        Response post_res = requestdetails
                .when().post("/employee");
        logreportutills.logresponse(post_res.prettyPrint());
        assertThat(post_res.getStatusCode()).isEqualTo(201);
    }

    @Test
    @frameworkannotation
    public void createandreplace_employee(Method method)
    {
        logreportutills.info_message("create employee with external files");
        String resource = Readandwriteutills
                .readjsonfileasstring(Constantdata.getRequestbody());
        String update = resource.replace("0", String.valueOf(Randomdatautills.getId()))
                .replace("fullname", Randomdatautills.getname())
                .replace("useremail", Randomdatautills.getEmail());
        Response post_res = BaseURI.buildgeturi()
                .body(update)
                .when().post("/employee");
        logreportutills.logresponse(post_res.prettyPrint());
        assertThat(post_res.getStatusCode()).isEqualTo(201);
        Readandwriteutills.writeresponseinjson(Constantdata.getResponsebody(), post_res);

    }
}
