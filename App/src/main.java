import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class main {

    public static void main(String[] args) {

    Jeu Game = new Jeu();
    Joueur user = new Joueur("Username");
    //Game.Joueurs.put("Username", user);
    System.out.println("hello");
    /*try {
        //File file = new File("Data");
        FileOutputStream myFileOutStream= new FileOutputStream("DataBase");
        ObjectOutputStream myObjectOutStream= new ObjectOutputStream(myFileOutStream);
        myObjectOutStream.writeObject(Game.Joueurs);
        myObjectOutStream.close();
        myFileOutStream.close();
        //System.out.printf("Serialized data is saved in Data");
     } catch (IOException e) {
         //Joueurs =  new HashMap<>();
        e.printStackTrace();
     }*/
    }
}