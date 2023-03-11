package com.api.utills;

import io.restassured.response.Response;
import lombok.NonNull;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;

public final class Readandwriteutills {

    private Readandwriteutills () {}
@SneakyThrows
    public static String readjsonfileasstring(String filepath)
    {
        return new String(Files.readAllBytes(Paths.get(filepath)));
    }
    @SneakyThrows
    @NonNull
    public static void writeresponseinjson( String filepath, Response res)
    {
        Files.write(Paths.get(filepath),res.asByteArray());
    }
}
