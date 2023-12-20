package com.magicvet.servis;

import com.magicvet.Main;
import com.magicvet.model.Cat;
import com.magicvet.model.Dog;
import com.magicvet.model.Pet;

public class PetService {

    private static final String DOG_TYPE="dog";
    private static final String CAT_TYPE="cat";

    public Pet registryNewPet(){
        Pet pet =null;
        System.out.print("Type (dog / cat): ");
        String type = Main.SCANNER.next();

        if(DOG_TYPE.equals(type) || CAT_TYPE.equals(type)){
            pet =buildPet(type);
        } else {
            System.out.println("Unknown pet type: " + type);
        }
        return pet;
    }


    private Pet buildPet(String type) {

        Pet pet =type.equals(CAT_TYPE)? new Cat():new Dog();
        pet.setType(type);

        System.out.print("Age:");
        pet.setAge(Main.SCANNER.next());

        System.out.print("Sex ( male / female ):");
        pet.setSex(Main.SCANNER.next());

        System.out.print("Name:");
        pet.setName(Main.SCANNER.next());

       System.out.print("Owner name:");
       pet.setOwnerName(Main.SCANNER.next());

       if(type.equals(DOG_TYPE)){
           System.out.print("Size ( XS / S / M / L / XXL ): ");
           ((Dog)pet).setSize(Main.SCANNER.next());
       }


        return pet;
    }
}
