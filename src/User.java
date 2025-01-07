package src;

public class User {
              private String nome;
              private String cognome;
              private String codiceFiscale;
              private String email;
              private String useId;
              private String password;

              public String getId() {
                            return useId;
              }

              public void setId(String id) {
                            this.useId = id;
              }

              public String getNome() {
                            return nome;
              }

              public void setNome(String nome) {
                            this.nome = nome;
              }

              public String getCognome() {
                            return cognome;
              }

              public String setCognome(String cognome) {
                            return this.cognome = cognome;
              }

              public String getCodiceFiscale() {
                            return codiceFiscale;
              }

              public void setCodiceFiscale(String codiceFiscale) {
                            this.codiceFiscale = codiceFiscale;
              }

              public String getEmail() {
                            return email;
              }

              public void setEmail(String email) {
                            this.email = email;
              }

              public void setPassword(String password) {
                            this.password = password;
              }

              public String getPassword() {
                            return password;
              }

              @Override
              public String toString() {
                            return "{" + useId + "::" + nome + "::" + cognome + "::" + codiceFiscale + email + "::"
                                                        + password + "::" + "}";
              }
}
