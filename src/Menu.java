package src;

import java.util.List;
import java.util.Scanner;

public class Menu extends Books {

              public static void homeMenu(User user) {
                            try (Scanner scanner = new Scanner(System.in)) {
                                          System.out.println("=============================== ");
                                          System.out.println("Select an option: ");
                                          System.out.println("=============================== ");
                                          if (user != null) {
                                                        System.out.println("1. Visualizza tutti i libri disponibili");
                                                        System.out.println("2. cerca Libro");
                                                        System.out.println("3. cerea una libraria");
                                                        System.out.println("4. visualizza i miei librerie");
                                                        System.out.println("5. Esci");

                                                        switch (scanner.nextInt()) {

                                                                      case 1:
                                                                                    getListWithOptions(getAllEntireBooks());
                                                                                    break;
                                                                      case 2:
                                                                                    cercaLibro();
                                                                                    break;
                                                                      case 3:
                                                                                    Libraries.createLibrary(user);
                                                                                    break;
                                                                      case 4:
                                                                                    Libraries.visualizzaLibrerieUtente(
                                                                                                                user);
                                                                                    break;
                                                                      case 5:
                                                                                    System.out.println("Arrivederci :)");
                                                                                    break;
                                                                      default:
                                                                                    System.out.println("Invalid choice");
                                                        }
                                          } else {
                                                        System.out.println("1. Registrati");
                                                        System.out.println("2. Accedi");
                                                        System.out.println("3. Visualizza tutti i libri disponibili");
                                                        System.out.println("4. cerca Libro");
                                                        System.out.println("5. Esci");
                                                        switch (scanner.nextInt()) {
                                                                      case 1:
                                                                                    Registration.registerUser();
                                                                                    break;
                                                                      case 2:
                                                                                    Registration.loginUser();

                                                                                    break;
                                                                      case 3:
                                                                                    getListWithOptions(getAllEntireBooks());
                                                                                    break;
                                                                      case 4:
                                                                                    cercaLibro();
                                                                                    break;
                                                                      case 5:
                                                                                    System.out.println("Arrivederci :)");
                                                                                    break;
                                                                      default:
                                                                                    System.out.println("Invalid choice");
                                                        }
                                          }

                            }

              }

              public static void bookMenu(Libro book, User user) {
                            Scanner scanner = new Scanner(System.in);
                            int choice = 0;
                            System.out.println("Select an option: ");
                            System.out.println("1. show");
                            System.out.println("2. Add To My Library");
                            System.out.println("3. Add una valutazione");
                            System.out.println("4. Add un libro consigliato");
                            System.out.println("5. Torna indietro");
                            choice = scanner.nextInt();
                            switch (choice) {
                                          case 1:
                                                        Books.visualizzaLibro(book);
                                                        break;

                                          case 2:
                                                        Libraries.aggiungeLibroInLibrary(null, null, null);
                                                        break;
                                          case 3:
                                                        Books.visualizzaLibro(book);
                                                        break;
                                          case 4:
                                                        Books.visualizzaLibro(book);
                                                        break;
                                          case 5:
                                                        homeMenu(null);
                                                        break;

                                          default:
                                                        break;
                            }

              }

              public static void libraryMenu(Library library, User user) {

                            Scanner scanner = new Scanner(System.in);
                            int choice = 0;
                            System.out.println("========================= ");
                            System.out.println("Select an option: ");
                            System.out.println("=========================");

                            System.out.println("1. show");
                            System.out.println("2. Add Libro in questa libraria");
                            System.out.println("3. remove libraria");
                            System.out.println("4. Torna indietro");
                            choice = scanner.nextInt();
                            switch (choice) {
                                          case 1:
                                                        library.visualizzaLibraria();
                                                        break;

                                          case 2:
                                                        // Libraries.aggiungeLibroInLibrary(null, null, null);
                                                        break;
                                          case 3:
                                                        // Books.visualizzaLibro(book);
                                                        break;

                                          case 4:
                                                        homeMenu(user);
                                                        break;

                                          default:
                                                        break;
                            }
              }

              public static void secondList(User loggedUser) {
                            int choice = 0;
                            try (Scanner scanner = new Scanner(System.in)) {
                                          List<Libro> libri = getAllEntireBooks();
                                          System.out.println("Select an option: ");
                                          System.out.println("1. Libri");

                                          choice = scanner.nextInt();
                                          scanner.nextLine();
                                          switch (choice) {
                                                        case 1:
                                                                      getListWithOptions(libri);
                                                                      break;
                                                        case 3:
                                                                      break;
                                                        default:
                                                                      System.out.println("Invalid choice");
                                          }
                            }

              }

}
