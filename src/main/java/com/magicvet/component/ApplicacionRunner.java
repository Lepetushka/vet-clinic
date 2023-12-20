package com.magicvet.component;

import com.magicvet.Main;
import com.magicvet.model.Client;
import com.magicvet.model.Pet;
import com.magicvet.servis.ClientService;
import com.magicvet.servis.PetService;

public class ApplicacionRunner {

    private final ClientService clientService =new ClientService();
    private final PetService petService=new PetService();

    public  void run(){
        if(Authenticator.auht()){
            Client client= clientService.registerNewClient();

            if(client != null) {
                System.out.print("Do you really need to add a pet now? ( true / false ) :");
                boolean addPetNow = Main.SCANNER.nextBoolean();
                if (addPetNow) {
                    System.out.println("Adding new pet. ");
                    Pet pet = petService.registryNewPet();

                    if(pet != null) {
                        client.setPet(pet);
                        pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
                        System.out.println("Pet has been added.");
                    }
                    System.out.println(client);

                } else {
                    System.out.println("Add the animal later");

                }
            }
        }
    }
}
