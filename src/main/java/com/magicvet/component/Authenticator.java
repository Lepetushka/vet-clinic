package com.magicvet.component;

import com.magicvet.Main;

public class Authenticator {

    private static String PASSWORD = "d";
    public static boolean auht(){
        boolean assepted = false;
        for(int i=0; i<3; i++){
            System.out.print("Password: ");
            String input = Main.SCANNER.nextLine();

            if(PASSWORD.equals(input)){
                assepted=true;
                break;
            } else {
                System.out.println("Access denied. Please check your password.");
            }
        }
        System.out.println(assepted ? "Welcome to the Magic Vet!" : "Application has been blocked!");
        return assepted;

    }
}
