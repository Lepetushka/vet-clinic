package com.magicvet;

import com.magicvet.comparator.DogSizeComparator;
import com.magicvet.model.Dog;
import com.magicvet.comparator.DogSizeComparator;
import java.util.Arrays;

public class SandBox {
    public static void main(String[] args) {

        Dog[] dogs={
                new Dog(Dog.M),
                new Dog(Dog.XS),
                new Dog(Dog.S),
                new Dog(Dog.L),
                new Dog(Dog.XL),
                new Dog(Dog.S)

        };

        Arrays.sort(dogs,new DogSizeComparator());
        for(Dog dog:dogs){
            System.out.println(dog.getSize());
        }
    }
}
