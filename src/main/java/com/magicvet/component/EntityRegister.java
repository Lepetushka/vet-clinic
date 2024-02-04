package com.magicvet.component;

import com.magicvet.Main;
import com.magicvet.model.Client;
import com.magicvet.model.Pet;
import com.magicvet.servis.ClientService;
import com.magicvet.servis.PetService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityRegister {

    private final ClientService clientService = new ClientService();
    private final PetService petService = new PetService();

    public void registerClient() {
        List<Client> clients = new ArrayList<>();
        String message="Do you want registry more clients? (y/n):";
        do {
           Client client= addClient();
           if(client != null){
               clients.add(client);
           }

        } while (verifyRepeating(message));

        Map<Client.Location, List<Client>> cliensByLocation=groupCliens(clients);
        printCliens(cliensByLocation);

    }

    private void printCliens(Map<Client.Location, List<Client>> cliensByLocation) {
        for (Map.Entry<Client.Location, List<Client>> cliens : cliensByLocation.entrySet()){
            String content ="\nLocation: " + cliens.getKey()
                    +"\nClients (" +cliens.getValue().size()+" ):"
                    +"\n\t" + cliens.getValue();

            System.out.println(content);
        }

    }

    private Map<Client.Location, List<Client>> groupCliens(List<Client> clients) {
       List<Client> fromKyiv = new ArrayList<>();
       List<Client> fromLviv = new ArrayList<>();
       List<Client> fromOdesa = new ArrayList<>();

       for(Client client:clients){
           switch (client.getLocation()){
               case KYIV -> fromKyiv.add(client);
               case LVIV -> fromLviv.add(client);
               case ODESA -> fromOdesa.add(client);
           }
       }

        Map<Client.Location, List<Client>>  cliensByLocation=new HashMap<>();
        cliensByLocation.put(Client.Location.KYIV, fromKyiv);
        cliensByLocation.put(Client.Location.LVIV, fromLviv);
        cliensByLocation.put(Client.Location.ODESA, fromOdesa);

        return cliensByLocation;
    }

    private  Client addClient() {
        Client client = clientService.registerNewClient();

        if (client != null) {
            registerPats(client);
            System.out.println(client);

        }
        return client;
    }


    private void registerPats(Client client) {
        String massage="Do you want add more pets foe the current client? (y/n):";
        do {
            addPet(client);

        } while (verifyRepeating(massage));
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

    private boolean verifyRepeating(String message){
        System.out.println(message);
        String answer = Main.SCANNER.next();
        if("y".equals(answer)){
            return true;
        } else if("n".equals(answer)){
            return false;
        } else {
            System.out.print("Incorrect answer. Please try again.");
            return verifyRepeating(message);
        }
    }
}
