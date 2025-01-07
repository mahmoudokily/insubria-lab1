package src;

public class Libro {
              private String titolo;
              private String autori;
              private String publishDate;
              private String category;
              private String bookId;

              public String getTitolo() {
                            return titolo;
              }

              public String getId() {
                            return bookId;
              }

              public String getCategory() {
                            return category;
              }

              public String getAutore() {
                            return autori;
              }

              public String getPublishDate() {
                            return publishDate;
              }

              public void setTitolo(String t) {
                            this.titolo = t;
              }

              public void setBookId(String id) {
                            this.bookId = id;
              }

              public void setCategory(String c) {
                            this.category = c;
              }

              public void setAutore(String a) {
                            this.autori = a;
              }

              public void setPublishDate(String d) {
                            this.publishDate = d;
              }

              public void showMe() {
                            System.out.println("Title : " + titolo);
                            System.out.println("Author : " + autori);
                            System.out.println("Category : " + category);
                            System.out.println("Published at :" + publishDate);

              }

}
