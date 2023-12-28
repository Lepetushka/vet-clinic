package com.magicvet;

import com.magicvet.comparator.AgeComparator;
import com.magicvet.comparator.DogSizeComparator;
import com.magicvet.model.Dog;
import com.magicvet.comparator.DogSizeComparator;
import com.magicvet.model.Pet;

import java.util.Arrays;

public class SandBox {
    public static void main(String[] args) {

        Pet[] pets={
                new Pet(5),
                new Pet( 8),

                new Pet(1),
                new Pet(4),
                new Pet(2),
                new Pet(1)

        };

        Arrays.sort(pets,new AgeComparator());
        for(Pet pet:pets){
            System.out.println(pet.getAge());
        }
    }
}
