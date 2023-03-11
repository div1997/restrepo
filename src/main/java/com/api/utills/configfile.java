package com.api.utills;

import com.api.com.api.constant.Constantdata;
import com.api.frameworkenums;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class configfile
{

    private configfile() {}
    private static Properties property = new Properties();
    private static HashMap<String , String> map = new HashMap<>();


   static {

        try(  FileInputStream inpStream = new FileInputStream(Constantdata.getConfigfilepath()))
       {

            property.load(inpStream);


        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            //execute when class load so runtime not applicable to put
            System.exit(0);
        }
        catch (IOException e)
        {
            e.printStackTrace();

        }
        for (Map.Entry<Object, Object> objectObjectEntry : property.entrySet())
        {
            String key = String.valueOf(objectObjectEntry.getKey());
            String value = String.valueOf(objectObjectEntry.getValue());
            map.put(key, value);
        }
    }


     public static String getvalue(frameworkenums key)
     {
         return map.get(key.name().toLowerCase());
     }
}
