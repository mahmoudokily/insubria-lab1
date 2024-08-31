import java.util.Scanner;

public class Main extends registrazione {
	public static void main(String[] args) {
		System.out.println("Welcome to BOOK RECOMMENDER \n");
		System.out.println("1. Login \n2. New User");
		System.out.println("Hai An Account ? click 1 to login or click 2 to register new user");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		switch (n) {
			case 1:
				login();
				break;
			case 2:
				registerNewUser();
				break;
			default:
				System.out.println(" error !");
				;
				break;
		}

	}

}
