package com.api.pojo;

import lombok.Builder;
import lombok.Getter;

@Builder (setterPrefix = "set")
@Getter

public class employee {

    private String name;
    private int id;
    private String email;


}
