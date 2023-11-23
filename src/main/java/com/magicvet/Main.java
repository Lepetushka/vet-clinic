package main.java.com.magicvet;//import main.java.com.magicvet.component.ApplicationRunner;
import java.util.Scanner;

public class Main {

	static String PASSWORD = "default";

	public static Scanner SCANNER = new Scanner(System.in);

	public static void main(String[] args) {
		run();
	}

	static void run(){
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
	}

}