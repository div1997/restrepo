package apirequestbuilder;

import com.api.frameworkenums;
import com.api.utills.configfile;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;

import static  io.restassured.RestAssured.*;
public final class BaseURI {
     private BaseURI() {} //shield the constructor so that no one extends

     public static RequestSpecification buildgeturi()
     {
         return given()
                 .baseUri(configfile.getvalue(frameworkenums.BASEURI)).
                 header("Content-Type","Application/JSON")
                 .log().all();
     }



}
