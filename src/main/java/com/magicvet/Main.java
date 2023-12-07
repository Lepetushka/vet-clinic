package com.magicvet;//import main.java.com.magicvet.component.ApplicationRunner;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

	static String PASSWORD = "default";

	public static Scanner SCANNER = new Scanner(System.in);
	static String EMAIL_PATTERN="^[a-zA-z0-9._%+-]+@[a-zA-z0-9.-]\\.[a-zA-Z]{2,}$";

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

	if(isEmailValid(email)){
		Client client = buildClient(email);
		System.out.println("New client: " + client.getFirstName() +" "+ client.getLastName()+ "( " + client.getEmail()+ " )");
	} else {
		System.out.println("Provided email is invalid");
	}

}

	static Client buildClient(String email) {
		Client client =new Client();
		client.setEmail(email);

		System.out.print("First name: ");
		client.setFirstName(SCANNER.nextLine());

		System.out.print("Last name: ");
		client.setLastName(SCANNER.nextLine());

		return client;

	}

	static boolean isEmailValid(String email) {
		Pattern pattern=Pattern.compile(EMAIL_PATTERN);
		Matcher matcher= pattern.matcher(email);
		return matcher.matches();
	}

}