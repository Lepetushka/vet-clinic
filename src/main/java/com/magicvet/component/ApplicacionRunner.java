package com.magicvet.component;

import com.magicvet.Main;
import com.magicvet.model.Client;
import com.magicvet.model.Pet;
import com.magicvet.servis.ClientService;
import com.magicvet.servis.PetService;

public class ApplicacionRunner {

    private final ClientService clientService = new ClientService();
    private final PetService petService = new PetService();

    public void run() {
        if (Authenticator.auht()) {
            Client client = clientService.registerNewClient();

            if (client != null) {
                registerPats(client);
                System.out.println(client);

            }
        }
    }

    private void registerPats(Client client) {
        boolean continueAddPets = true;
        while (continueAddPets){
            addPet(client);

            System.out.print("Do you want add moe pets foe the current client? (y/n):");
            String answer=Main.SCANNER.next();

            if("n".equals(answer)){
                continueAddPets=false;
            }
        }
    }

    private void addPet(Client client) {
        System.out.println("Adding new pet. ");
        Pet pet = petService.registryNewPet();

        if (pet != null) {
            client.addPet(pet);
            pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
            System.out.println("Pet has been added.");
        }
    }
}
