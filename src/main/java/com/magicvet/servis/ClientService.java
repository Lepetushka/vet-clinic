package com.magicvet.servis;

import com.magicvet.Main;
import com.magicvet.model.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

    private static String EMAIL_PATTERN="^[a-zA-z0-9_.+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static String NAME_PATTERN="^[a-zA-Z-]{3,}";
    public Client registerNewClient(){
        Client client=null;
        System.out.println("Please provide client details. ");
        System.out.print("email: ");
        String email= Main.SCANNER.nextLine();

        if(!isEmailValid(email)){
            System.out.println("Provided email is invalid");
        } else {
            System.out.print("First name: ");
            String firstName=Main.SCANNER.nextLine();
            if(!isFirstNameValid(firstName)){
                System.out.println("Provided firstname is invalid. ");
            } else {
                System.out.print("Last name: ");
                String lastName=Main.SCANNER.nextLine();
                if(!isFirstNameValid(lastName)){
                    System.out.println("Provided lastname is invalid. ");

                } else {
                    Client client = buildClient(email,
                            firstName,
                            lastName);
                    System.out.println("New client: "+client.getFirstName()+" "+
                            client.getLastName()+"( "+client.getEmail()+" )");
                }
            }
        }
        return client;

    }
    private static Client buildClient(String email, String firstName, String lastName) {
        Client client =new Client();
        client.setEmail(email);
        client.setFirstName(firstName);
        client.setLastName(lastName);
        return client;
    }

    private static boolean isFirstNameValid(String firstName) {
        Pattern pattern=Pattern.compile(NAME_PATTERN);
        Matcher matcher= pattern.matcher(firstName);
        return matcher.matches();
    }

    private static boolean isLastNameValid(String lastName) {
        Pattern pattern=Pattern.compile(NAME_PATTERN);
        Matcher matcher= pattern.matcher(lastName);
        return matcher.matches();
    }

    private static boolean isEmailValid(String email) {
        Pattern pattern=Pattern.compile(EMAIL_PATTERN);
        Matcher matcher= pattern.matcher(email);
        return matcher.matches();
    }
}
