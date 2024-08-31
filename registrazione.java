import java.util.Scanner;
import java.io.*;
import java.util.*;

public class registrazione {
	static String nome;
	static String cognome;
	static String codiceFiscale;
	static String email;
	static String userId;
	static String password;
	static String confirmPassword;

	private static Boolean checkIfEmpty(String field) {
		if (field.isBlank() || field.isEmpty()) {
			System.out.println("Field Is Required");
			return false;
		} else {
			return true;
		}
	}

	public static void registerNewUser() {
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome !");
		System.out.println("Enter Your Name: \r");
		nome = in.nextLine();
		System.out.println("Enter Your cogname: \r");
		cognome = in.nextLine();
		System.out.println("Enter Your Email: \r");
		email = in.nextLine();
		System.out.println("Enter Your Codice Fiscale: \r");
		codiceFiscale = in.nextLine();
		System.out.println("Enter Your password: \r");
		password = in.nextLine();
		System.out.println("Enter Your password confirm: \r");
		confirmPassword = in.nextLine();
		// check form ;

	}

	public static void login() {
		try (Scanner in = new Scanner(System.in)) {
			System.out.println("Email: \n");
			String email = in.nextLine();
			checkIfEmpty(email);
			System.out.println("password: \n");
			String password = in.nextLine();
			if (email.isBlank() || password.isBlank()) {
				System.out.println("Email And Password Are Required Fields");
			} else {
				System.out.println("email is " + email + " \r password is "
						+ password);
			}
		}
	}
}
