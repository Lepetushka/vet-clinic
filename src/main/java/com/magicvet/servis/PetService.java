package com.magicvet.servis;

import com.magicvet.Main;
import com.magicvet.model.Dog;
import com.magicvet.model.Pet;

public class PetService {

    private static String DOG_TYPE="dog";

    public Pet registryNewPet(){
        Pet pet =new Pet();
        System.out.println("Type ( dog / cat /other ): ");

        String type = Main.SCANNER.nextLine();


        if(DOG_TYPE.equals(type)){
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
        dog.setSize(Main.SCANNER.nextLine());

        return dog;
    }

    private Dog petToDog(Pet pet) {
        Dog dog=new Dog();
        dog.setAge(pet.getAge());
        dog.setName(pet.getName());
        dog.setSex(pet.getSex());
        return dog;
    }

    private Pet buildPet(String type) {

        Pet pet =new Pet();
        pet.setType(type);

        System.out.print("Age:");
        pet.setAge(Main.SCANNER.nextLine());

        System.out.print("Sex ( male / female ):");
        pet.setSex(Main.SCANNER.nextLine());

        System.out.print("Name:");
        pet.setName(Main.SCANNER.nextLine());

//        System.out.print("Owner name:");
//        pet.setOwnerName(Main.SCANNER.nextLine());


        return pet;
    }
}
