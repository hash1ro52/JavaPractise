import java.util.HashMap;
public class Main{
    public static void main(String[] args){
         class Picture {
            private String name;
            private short year;
            private String author;

            public Picture(String name, short year, String author) {
                this.name = name;
                this.year = year;
                this.author = author;
            }

            public String getName() {
                return name;
            }

            public short getYear() {
                return year;
            }

            public String getAuthor() {
                return author;
            }

            @Override
            public String toString() {
                return "Picture{" +
                        "name='" + name + '\'' +
                        ", year=" + year +
                        ", author='" + author + '\'' +
                        '}';
            }
        }
        class Gallery {
            private HashMap<String, Picture> pictures;
            private String name;
            private String article;

            private static Gallery instance;

            private Gallery(String name) {
                this.name = name;
                this.pictures = new HashMap<>();
                this.article = "";
            }

            public static Gallery getInstance(String name) {
                if (instance == null) {
                    instance = new Gallery(name);
                }
                return instance;
            }

            public boolean addPicture(Picture picture) {
                if (!pictures.containsKey(picture.getName())) {
                    pictures.put(picture.getName(), picture);
                    return true;
                }
                return false;
            }

            public boolean removePicture(Picture picture) {
                return pictures.remove(picture.getName()) != null;
            }

            public String describePicture(Picture picture) {
                if (pictures.containsKey(picture.getName())) {
                    return picture.toString();
                }
                return "Picture not found in the gallery.";
            }

            public Picture getPicture(String name) {
                return pictures.get(name);
            }

            public HashMap<String, Picture> getPictures() {
                return new HashMap<>(pictures);
            }

            public int getPictureCount() {
                return pictures.size();
            }

            public String getName() {
                return name;
            }

            public String getArticle() {
                return article;
            }

            public void setArticle(String article) {
                this.article = article;
            }
        }
        Gallery gallery = Gallery.getInstance("Art Gallery");

        gallery.setArticle("Welcome to the Art Gallery");
        System.out.println("Article: " + gallery.getArticle());

        Picture picture1 = new Picture("Mona Lisa", (short) 1503, "Leonardo da Vinci");
        Picture picture2 = new Picture("Starry Night", (short) 1889, "Vincent van Gogh");

        gallery.addPicture(picture1);
        gallery.addPicture(picture2);

        System.out.println("Gallery Name: " + gallery.getName());
        System.out.println("Number of Pictures: " + gallery.getPictureCount());

        System.out.println(gallery.describePicture(picture1));
        System.out.println(gallery.describePicture(picture2));

        gallery.removePicture(picture1);
        System.out.println("Number of Pictures after removal: " + gallery.getPictureCount());



    }
}





