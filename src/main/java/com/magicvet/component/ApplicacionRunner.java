package com.magicvet.component;

import com.magicvet.Main;
import com.magicvet.model.Client;
import com.magicvet.model.Pet;
import com.magicvet.servis.ClientService;
import com.magicvet.servis.PetService;

public class ApplicacionRunner {

    private final EntityRegister register=new EntityRegister();

    public void run() {
        if (Authenticator.auht()) {

            register.registerClient();

        }
    }
}
