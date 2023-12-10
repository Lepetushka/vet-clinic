package com.magicvet.component;

import com.magicvet.model.Client;
import com.magicvet.model.Pet;
import com.magicvet.servis.ClientService;
import com.magicvet.servis.PetService;

public class ApplicacionRunner {

    private ClientService clientService =new ClientService();
    private PetService petService=new PetService();

    public  void run(){
        if(Authenticator.auht()){
            Client client= clientService.registerNewClient();

            if(client != null){
                System.out.println("Adding new pet. ");
                Pet pet= petService.registryNewPet();

                client.setPet(pet);
                pet.setOwnerName(client.getFirstName()+" "+ client.getLastName());
                System.out.println("Pet has been added.");

            }
        }
    }
}
