package com.magicvet.servis;

import com.magicvet.Main;
import com.magicvet.model.Dog;
import com.magicvet.model.Pet;

public class PetService {

    private static final String DOG_TYPE="dog";

    public Pet registryNewPet(){
        Pet pet =new Pet();


        System.out.print("Type ( dog / cat /other ): ");

        String type = Main.SCANNER.next();
        pet.setType(type);


        if(DOG_TYPE.equals(pet.getType())){
            pet =buildDog();
        } else {
            pet =buildPet(type);
        }

        return pet;

    }

    private Dog buildDog() {
        Pet pet = buildPet(DOG_TYPE);
        Dog dog=petToDog(pet);

        System.out.print("Size ( XS / S / M / L / XXL ): ");
        dog.setSize(Main.SCANNER.next());

        return dog;
    }

    private Dog petToDog(Pet pet) {
        Dog dog=new Dog();
        dog.setType(pet.getType());
        dog.setAge(pet.getAge());
        dog.setName(pet.getName());
        dog.setSex(pet.getSex());
        return dog;
    }

    private Pet buildPet(String type) {

        Pet pet =new Pet();
        pet.setType(type);

        System.out.print("Age:");
        pet.setAge(Main.SCANNER.next());

        System.out.print("Sex ( male / female ):");
        pet.setSex(Main.SCANNER.next());

        System.out.print("Name:");
        pet.setName(Main.SCANNER.next());

       System.out.print("Owner name:");
       pet.setOwnerName(Main.SCANNER.next());


        return pet;
    }
}
