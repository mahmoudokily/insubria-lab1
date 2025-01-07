package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Libraries {

              public static ArrayList<Library> getAllLibraries() {
                            ArrayList<Library> librerie = new ArrayList<Library>();
                            File file = new File("data/Librerie.dati.csv");
                            try {
                                          try (Scanner scanner = new Scanner(file)) {
                                                        scanner.useDelimiter("\n");
                                                        while (scanner.hasNext()) {
                                                                      Library library = new Library();
                                                                      String[] words = scanner.next().split(",");
                                                                      library.setLibraryName(words[0]);
                                                                      library.setLibraryUserId(words[1]);
                                                                      library.setLibraryLibri(words[2]);
                                                                      librerie.add(library);

                                                        }
                                          }

                            } catch (FileNotFoundException e) {

                                          e.printStackTrace();
                            }

                            return librerie;
              }

              public static void getListWithOptions(List<Library> libraries) {
                            try (Scanner scanner = new Scanner(System.in)) {
                                          Library selectedLibrary = null;
                                          System.out.println("=============================== ");
                                          System.out.println("Seleziona Un Libraria: ");
                                          System.out.println("=============================== ");
                                          for (Library library : libraries) {
                                                        System.out.print(libraries.indexOf(library) + 1);
                                                        System.out.print(": ");
                                                        System.out.println(library.getLibraryName());

                                          }
                                          int choice = scanner.nextInt();
                                          selectedLibrary = libraries.get(choice - 1);
                                          if (selectedLibrary != null) {
                                                        Menu.bookMenu(null, null);
                                          }
                            }

              }

              public static void aggiungeLibroInLibrary(Library library, Libro libro, User user) {
                            // search for library
                            // check if userid is owener if library
                            // check if libro is exist in library
                            // add libro to library libri

              }

              public static void visualizzaLibrerieUtente(User user) {
                            Scanner scanner = new Scanner(System.in);
                            int choice = 0;
                            ArrayList<Library> allLibraries = getAllLibraries();
                            List<Library> userLibraries = allLibraries.stream()
                                                        .filter(u -> u.getLibraryUserId().equals(user.getId()))
                                                        .collect(Collectors.toList());
                            System.out.println("=============================== ");
                            System.out.println("Seleziona Un Libraria: ");
                            System.out.println("=============================== ");
                            for (Library library : userLibraries) {
                                          System.out.print(userLibraries.indexOf(library) + 1);
                                          System.out.print(": ");
                                          System.out.println(library.getLibraryName());

                            }
                            Library selectedLibraria = null;
                            choice = scanner.nextInt();
                            if (choice != 0) {
                                          selectedLibraria = userLibraries.get(choice - 1);
                            }
                            if (selectedLibraria != null) {
                                          Menu.libraryMenu(selectedLibraria, user);
                            }

              }

              public static void createLibrary(User user) {
                            if (user == null) {
                                          System.out.println("Deve Accedere Prima Per Poter Aggiungre Una Libraria");
                                          return;
                            }
                            try (Scanner scanner = new Scanner(System.in)) {
                                          ArrayList<Library> librerie = getAllLibraries();
                                          Library newLibrary = new Library();
                                          newLibrary.setLibraryUserId(user.getId());
                                          System.out.println("Enter Library Name:");

                                          newLibrary.setLibraryName(scanner.nextLine());
                                          newLibrary.setLibraryLibri("2-3-4");

                                          librerie.add(newLibrary);
                                          try (FileWriter csvWriter = new FileWriter(
                                                                      "data/Librerie.dati.csv")) {

                                                        for (Library library : librerie) {
                                                                      csvWriter.append(library.getLibraryName())
                                                                                                  .append(",");
                                                                      csvWriter.append(library.getLibraryUserId())
                                                                                                  .append(",");
                                                                      csvWriter.append(library.getLibraryLibri())
                                                                                                  .append("\n");

                                                        }
                                                        csvWriter.close();

                                          } catch (IOException e) {
                                                        e.printStackTrace();
                                                        System.out.println("error" + e.getMessage());
                                          }
                                          Menu.homeMenu(user);

                            }

              }

}
