package com.api.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


@Getter
@AllArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Builder(buildMethodName = "gettaskbody")
public class Taskbody
{
    private Projectjira project;

    private String summary;
    private String description;
    private Jiraissuetype issuetype;
 private  Taskbody () {};


}
