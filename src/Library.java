package src;

import java.util.ArrayList;

public class Library {
              private String name;
              private String libri;
              private String userId;

              public String getLibraryName() {
                            return this.name;
              }

              public String getLibraryUserId() {
                            return this.userId;
              }

              public String getLibraryLibri() {
                            return this.libri;
              }

              public int getLibraryLibriCount() {
                            return this.libri.split("-").length;
              }

              public void setLibraryName(String name) {
                            this.name = name;
              }

              public void setLibraryUserId(String userId) {
                            this.userId = userId;
              }

              public void setLibraryLibri(String libro) {
                            if (libri != null) {
                                          libri += "-" + libro;
                            } else {
                                          libri = libro;
                            }
              }

              public void visualizzaLibraria() {
                            System.out.println("Nome :" + this.name);
                            System.out.println("Libri :" + this.libri);

              }

}
