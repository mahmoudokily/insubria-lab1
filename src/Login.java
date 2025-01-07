package src;

import java.util.ArrayList;
import java.util.Optional;

public class Login {
              public User authenticate(ArrayList<User> users, String enteredUserId, String enteredPassword) {

                            Optional<User> existUser = users.stream().filter(u -> u.getId().equals(enteredUserId))
                                                        .filter(u -> u.getPassword().equals(enteredPassword))
                                                        .findFirst();
                            if (existUser.isPresent()) {
                                          System.out.println("=============================== ");
                                          System.out.println("Ciao " + existUser.get().getNome()
                                                                      + " Hai effettuato l'accesso con successo :) ");

                                          return existUser.get();
                            } else {
                                          System.out.println("Invalid username or password.");
                                          return null;

                            }
              }
}
