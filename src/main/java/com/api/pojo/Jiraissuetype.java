package com.api.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)

public class Jiraissuetype {
    private String name;

}
