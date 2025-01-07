package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Registration {

	public static void registerUser() {
		try (Scanner scanner = new Scanner(System.in)) {
			User user = new User();
			List<User> users = ReadCsv();
			Number lastId = users.size() + 1;
			System.out.println("Enter your nome:");
			user.setNome(scanner.nextLine());
			System.out.println("Enter your cognome:");
			user.setCognome(scanner.nextLine());
			System.out.println("Enter your codiceFiscale:");
			user.setCodiceFiscale(scanner.nextLine());
			System.out.println("Enter your email:");
			user.setEmail(scanner.nextLine());
			user.setId(lastId.toString());
			System.out.println("Enter your password:");
			user.setPassword(scanner.nextLine());
			if (checkIfExist(user)) {
				return;
			}
			users.add(user);
			try (FileWriter csvWriter = new FileWriter(
					"data/UtentiRegistrati.dati.csv")) {

				for (User u : users) {
					csvWriter.append(u.getNome()).append(",");
					csvWriter.append(u.getCognome()).append(",");
					csvWriter.append(u.getCodiceFiscale())
							.append(",");
					csvWriter.append(u.getEmail()).append(",");
					csvWriter.append(u.getId()).append(",");
					csvWriter.append(u.getPassword()).append("\n");

				}
				csvWriter.close();

			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("error" + e.getMessage());
			}
			System.out.println("=============================== ");
			System.out.println("user Registerd successfully ");
			System.out.println("your id is :" + user.getId());
			System.out.println("your password :" + user.getPassword());
			Menu.homeMenu(null);
		}

	}

	public static void loginUser() {
		try (Scanner scanner = new Scanner(System.in)) {
			ArrayList<User> users = ReadCsv();

			System.out.println("=============================== ");
			System.out.println("Accedi)");
			System.out.println("=============================== ");

			System.out.println("Inserire Il Tuo Id :");
			String userId = scanner.nextLine();

			System.out.println("Inserire La Tua Password :");
			String password = scanner.nextLine();

			Login login = new Login();
			User user = null;
			user = login.authenticate(
					users, userId,
					password);
			if (user != null) {
				Menu.homeMenu(user);

			} else {
				loginUser();
			}

		}
	}

	public static ArrayList<User> ReadCsv() {
		File file = new File("data/UtentiRegistrati.dati.csv");
		ArrayList<User> users = new ArrayList<User>();
		try (Scanner scanner = new Scanner(file)) {
			scanner.useDelimiter("\n");

			// hashNext() loops line-by-line
			while (scanner.hasNext()) {
				User user = new User();
				String[] words = scanner.next().split(",");
				user.setNome(words[0]);
				user.setCognome(words[1]);
				user.setCodiceFiscale(words[2]);
				user.setEmail(words[3]);
				user.setId(words[4]);
				user.setPassword(words[5]);
				users.add(user);

			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		return users;

	}

	public static Boolean checkIfExist(User user) {
		System.out.println("email" + user);
		List<User> users = ReadCsv();
		Boolean isExist = false;
		if (users.contains(user)) {
			System.out.println("User Is Exist , Try To Login");
			isExist = true;

		}

		return isExist;
	}

	// public static void saveUsers(User user) {

	// try (FileWriter csvWriter = new FileWriter(
	// "data/UtentiRegistrati.dati.csv")) {

	// StringBuilder csvContent = new StringBuilder();
	// csvContent.append(CSV_HEADER)
	// .append(user.nome).append(",")
	// .append(user.cognome).append(",")
	// .append(user.codiceFiscale).append(",")
	// .append(user.email).append(",")
	// .append("userID ").append(",")
	// .append(user.password).append("\n");
	// csvWriter.append(csvContent);

	// // // Write header row
	// // csvWriter.append(CSV_HEADER);

	// // csvWriter.append(user.nome).append(",");
	// // csvWriter.append(user.cognome).append(",");
	// // csvWriter.append(user.codiceFiscale).append(",");
	// // csvWriter.append(user.email).append(",");
	// // csvWriter.append("userID ").append(",");
	// // csvWriter.append(user.password).append("\n");

	// // Close the csvWriter to save the data
	// csvWriter.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }

	// public static boolean checkIfUserExist(User user) {
	// if (users.containsKey(user.nome)) {
	// System.out.println("User already exists.");
	// return false;
	// } else {
	// // users.put("nome", nome);
	// // users.put("cognome", cognome);
	// // users.put("codiceFiscale", codiceFiscale);
	// // users.put("email", email);
	// // users.put("userId", "1");
	// // users.put("password", password);
	// // System.out.println(users.toString());

	// System.out.println("Registration successful.");
	// return true;

	// }
	// }

}
