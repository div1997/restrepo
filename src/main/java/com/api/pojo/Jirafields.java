package com.api.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Builder(buildMethodName = "getbody")

public class Jirafields
{
    private Taskbody fields;
}
