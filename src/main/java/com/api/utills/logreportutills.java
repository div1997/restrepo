package com.api.utills;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.http.Header;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import lombok.NonNull;

public final class logreportutills
{
    private logreportutills () {}
    public static void pass (String message)
    {
        reportutillsmanager.getTest().pass(message);
    }
    public static void failed (String message)
    {
        reportutillsmanager.getTest().fail(MarkupHelper.createLabel(message, ExtentColor.RED));
    }
    public static void info_message(String message)
    {
        reportutillsmanager.getTest().info(message);
    }
    public static void logresponse(String message)
    {

        reportutillsmanager.getTest().pass(MarkupHelper.createCodeBlock(message, CodeLanguage.JSON));

    }
    /*public static void assignauthorandcategory(String author , frameworkenums category)
    {
        reportutillsmanager.getTest().assignAuthor(author).assignCategory(String.valueOf(category).toUpperCase());
    }*/
    public static void assignauthor(String [] authors)
    {
        for( String author : authors)
        {
            reportutillsmanager.getTest().assignAuthor(author);
        }
    }
    public static  void logrequest(RequestSpecification resquest)
    {
        QueryableRequestSpecification query = SpecificationQuerier.query(resquest);
        info_message("get details of request");
        //info(query.getBody());
        reportutillsmanager.getTest().info(MarkupHelper.createCodeBlock( query.getBody(), CodeLanguage.JSON));

        for( Header header : query.getHeaders())
        {
            info_message(header.getName() +":"+ header.getValue());
        }
    }


    public static  void assigncategory(String [] categories)
    {
        for( String category : categories)
        {
            reportutillsmanager.getTest().assignCategory(category);
        }
    }
}
