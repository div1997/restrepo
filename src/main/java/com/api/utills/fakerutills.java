package com.api.utills;

import com.github.javafaker.Faker;

public final class fakerutills {
    private fakerutills() {}
    public static Faker faker = new Faker();
      static int getnumber( int start , int end)
     {
         return faker.number().numberBetween(start, end);

     }

     static String getfullname()
     {
         return faker.name().fullName();
     }


}
