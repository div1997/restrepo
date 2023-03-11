package com.api.com.api.constant;

import lombok.Getter;

// when non static then we can add  lombok @getter at class level in static add at field level
public class Constantdata {
    private static @Getter final String requestbody= System.getProperty("user.dir")
            +"/src/test/testresource/resource.json";
    private static @Getter final  String responsebody = System.getProperty("user.dir")
            +"/src/test/testresource/output.json";
    private static @Getter final  String configfilepath = System.getProperty("user.dir")
            +"/src/test/testresource/configproperties";




}
