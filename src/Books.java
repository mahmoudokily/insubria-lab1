package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Books {
              public static List<Libro> getAllEntireBooks() {
                            List<Libro> libri = getAllBooks();
                            return libri;

              }

              public static int getCount() {
                            List<Libro> libri = getAllBooks();
                            return libri.size();
              }

              public static int getBookIndex(Libro l) {
                            List<Libro> libri = getAllBooks();
                            return libri.indexOf(l);
              }

              public static List<String> getAllBooksTitle() {
                            List<Libro> libri = getAllBooks();
                            List<String> booksTitles = new ArrayList<>();
                            for (Libro libro : libri) {
                                          booksTitles.add(libro.getTitolo());
                            }
                            return booksTitles;
              }

              public static void cercaLibro() {
                            System.out.println("=============================== ");
                            System.out.println("Cerca Libro");
                            System.out.println("=============================== ");
                            System.out.println("1: ricerca per titolo ");
                            System.out.println("2: ricerca per autore ");
                            System.out.println("3: ricerca per autore e anno ");
                            System.out.println("4: Go Back");

                            try (Scanner scanner = new Scanner(System.in)) {
                                          int choice = scanner.nextInt();
                                          scanner.nextLine();
                                          switch (choice) {
                                                        case 1:
                                                                      cercaLibroPerTitolo();
                                                                      break;
                                                        case 2:
                                                                      circaLibroPerAutore();
                                                                      break;

                                                        case 3:
                                                                      circaLibroPerAutoreEAnno();
                                                                      break;
                                                        case 4:
                                                                      Menu.homeMenu(null);
                                                                      break;

                                                        default:
                                                                      cercaLibroPerTitolo();

                                          }
                            }

              }

              public static void cercaLibroPerTitolo() {
                            System.out.println("=============================== ");
                            System.out.println(" Inserire un Titolo");
                            System.out.println("=============================== ");

                            try (Scanner scanner = new Scanner(System.in)) {
                                          String title = scanner.nextLine();

                                          List<Libro> libri = getAllBooks();

                                          List<Libro> foundBooks = libri.stream()
                                                                      .filter(u -> u.getTitolo().toLowerCase().contains(
                                                                                                  title.toLowerCase()))
                                                                      .collect(Collectors.toList());

                                          if (foundBooks.size() > 0) {
                                                        getListWithOptions(foundBooks);

                                          } else {
                                                        System.out.println("No Books Found");

                                          }
                            }

              }

              public static void circaLibroPerAutore() {
                            System.out.println("=============================== ");
                            System.out.println(" Inserire un Autore");
                            System.out.println("=============================== ");

                            try (Scanner scanner = new Scanner(System.in)) {
                                          String autore = scanner.nextLine();

                                          List<Libro> libri = getAllBooks();

                                          List<Libro> foundBooks = libri.stream()
                                                                      .filter(u -> u.getAutore().toLowerCase().contains(
                                                                                                  autore.toLowerCase()))
                                                                      .collect(Collectors.toList());

                                          if (foundBooks.size() > 0) {
                                                        getListWithOptions(foundBooks);

                                          } else {
                                                        System.out.println("No Books Found");

                                          }
                            }

              }

              public static void circaLibroPerAutoreEAnno() {
                            try (Scanner scanner = new Scanner(System.in)) {
                                          System.out.println("=============================== ");
                                          System.out.println(" Inserire un Autore");
                                          String autore = scanner.nextLine();
                                          System.out.println(" Inserire un Anno");
                                          String anno = scanner.nextLine();
                                          System.out.println("=============================== ");

                                          List<Libro> libri = getAllBooks();

                                          List<Libro> foundBooks = libri.stream()
                                                                      .filter(u -> u.getAutore().toLowerCase().contains(
                                                                                                  autore.toLowerCase()))
                                                                      .filter(u -> u.getPublishDate().contains(
                                                                                                  anno))
                                                                      .collect(Collectors.toList());

                                          if (foundBooks.size() > 0) {
                                                        getListWithOptions(foundBooks);

                                          } else {
                                                        System.out.println("No Books Found");

                                          }
                            }

              }

              public static List<Libro> getAllBooks() {

                            List<Libro> libri = new ArrayList<Libro>();
                            File file = new File("data/Libri.new.dati.csv");
                            try {
                                          try (Scanner scanner = new Scanner(file)) {
                                                        scanner.useDelimiter("\n");
                                                        while (scanner.hasNext()) {
                                                                      Libro libro = new Libro();
                                                                      String[] words = scanner.next().split(",");
                                                                      libro.setTitolo(words[0]);
                                                                      libro.setAutore(words[1]);
                                                                      libro.setCategory(words[2]);
                                                                      libro.setPublishDate(words[3]);
                                                                      libro.setBookId(words[4]);
                                                                      libri.add(libro);

                                                        }
                                          }

                                          // after loop, close scanner

                            } catch (FileNotFoundException e) {

                                          e.printStackTrace();
                            }

                            return libri;
              }

              public static void getListWithOptions(List<Libro> books) {
                            Scanner scanner = new Scanner(System.in);

                            Libro selectedBook = null;
                            System.out.println("=============================== ");
                            System.out.println("Seleziona Un Libro: ");
                            System.out.println("=============================== ");
                            for (Libro libro : books) {
                                          System.out.print(books.indexOf(libro) + 1);
                                          System.out.print(": ");
                                          System.out.println(libro.getTitolo());

                            }
                            int choice = scanner.nextInt();
                            selectedBook = books.get(choice - 1);
                            if (selectedBook != null) {
                            }

              }

              public static void visualizzaLibro(Libro libro) {
                            libro.showMe();
                            System.out.println("Valutazione:  non sono disponibili valutazioni degli utenti Per Quest Libro");
                            System.out.println("Libri Consigliati:  non ci sono consigli dagli utenti");
              }

}
