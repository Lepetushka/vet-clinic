package com.magicvet;//import main.java.com.magicvet.component.ApplicationRunner;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

	static String PASSWORD = "d";

	public static Scanner SCANNER = new Scanner(System.in);
	static String EMAIL_PATTERN="^[a-zA-z0-9_.+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
	static String NAME_PATTERN="^[a-zA-Z-]{3,}";

	public static void main(String[] args) {
		run();
	}

	static void run(){
		if(auht()){
			registerNewClient();
		}

	}

static boolean auht(){
	boolean assepted = false;
	for(int i=0; i<3; i++){
		System.out.print("Password: ");
		String input = SCANNER.nextLine();

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

static void registerNewClient(){
	System.out.println("Please provide client details. ");
	System.out.print("email: ");
	String email=SCANNER.nextLine();

	if(!isEmailValid(email)){
		System.out.println("Provided email is invalid");
	} else {
		System.out.print("First name: ");
		String firstName=SCANNER.nextLine();
		if(!isFirstNameValid(firstName)){
			System.out.println("Provided firstname is invalid. ");
		} else {
			System.out.print("Last name: ");
			String lastName=SCANNER.nextLine();
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

}

	static Client buildClient(String email, String firstName, String lastName) {
		Client client =new Client();
		client.setEmail(email);
        client.setFirstName(firstName);
        client.setLastName(lastName);
		return client;
	}

	static boolean isFirstNameValid(String firstName) {
		Pattern pattern=Pattern.compile(NAME_PATTERN);
		Matcher matcher= pattern.matcher(firstName);
		return matcher.matches();
	}

	static boolean isLastNameValid(String lastName) {
		Pattern pattern=Pattern.compile(NAME_PATTERN);
		Matcher matcher= pattern.matcher(lastName);
		return matcher.matches();
	}

	static boolean isEmailValid(String email) {
		Pattern pattern=Pattern.compile(EMAIL_PATTERN);
		Matcher matcher= pattern.matcher(email);
		return matcher.matches();
	}

}