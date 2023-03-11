package com.api.utills;

public final class Randomdatautills {
// business layeer data
    private Randomdatautills () {}
  static  String name ="";

    public static int getId()
    {
       return fakerutills.getnumber(100 ,200);
    }
public static String getname()
{

    name = fakerutills.getfullname();

    return name;
}

public static String getEmail()
{
    return name.replace(" ", "_")+"@gmail.com";
}

}
