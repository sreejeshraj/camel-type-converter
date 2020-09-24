package com.sreejesh.type_converter;

import com.sreejesh.model.Cat;
import com.sreejesh.model.Dog;
import org.apache.camel.Converter;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


@Converter
public class InputStreamFromDogConverter {
    @Converter
    public static InputStream toInputStream(Dog dog)
    {
        String dogString = dog.toString();
        InputStream dogInputStream = new ByteArrayInputStream(dogString.getBytes());
        return dogInputStream;
    }
}
