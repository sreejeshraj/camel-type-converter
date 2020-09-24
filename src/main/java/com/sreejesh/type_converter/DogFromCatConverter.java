package com.sreejesh.type_converter;

import com.sreejesh.model.Cat;
import com.sreejesh.model.Dog;
import org.apache.camel.Converter;

@Converter
public class DogFromCatConverter {
    @Converter
    public static Dog toDog(Cat cat)
    {
        Dog dog = new Dog("Kaiser",cat.getColour(), cat.getAge());
        return dog;
    }
}
