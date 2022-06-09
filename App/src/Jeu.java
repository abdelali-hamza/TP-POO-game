import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.io.*;
import javax.naming.AuthenticationException;

public class Jeu {
    static int meilleur_score_global;
    HashMap<String,Joueur> Joueurs = new HashMap();
    public Jeu() {
        //clearData();
       GetData();
       set_meilleur_score_global();
    }
    public void clearData(){
        Joueurs.clear();
        SaveData();
    }

    public Joueur Login(String UserName){
        if (Joueurs.containsKey(UserName)) {
            return Joueurs.get(UserName);
            
        }else{
            return null;
        }
    }
    public Joueur Signin(String UserName){
        if (Joueurs.containsKey(UserName)) {
            return null;
            
            
        }else{
            Joueur player=new Joueur(UserName);
            Joueurs.put(UserName, player); 
            SaveData();
            return player; 
        }
        

        
    }
    public void SaveData(){
        try {
            FileOutputStream myFileOutStream= new FileOutputStream("Data");
            ObjectOutputStream myObjectOutStream= new ObjectOutputStream(myFileOutStream);
            myObjectOutStream.writeObject(Joueurs);
            myObjectOutStream.close();
            myFileOutStream.close();
         } catch (IOException e) {
             Joueurs =  new HashMap<>();
            e.printStackTrace();
         }
    }
    public void GetData(){
        try {
            
            FileInputStream fileInput = new FileInputStream("Data");
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            Joueurs = (HashMap)objectInput.readObject();
            objectInput.close();
            fileInput.close();
        }
        catch (IOException obj1) {
            System.out.println("Deserializing  HashMap..");
            obj1.printStackTrace();
            return;
        }
        catch (ClassNotFoundException obj2) {
            System.out.println("Class not found");
            obj2.printStackTrace();
            return;
        }
        
    }  
    public String set_meilleur_score_global() {
        List<Integer> intValues = new ArrayList<>();
        for (String name : Joueurs.keySet()) {
          intValues.add(Joueurs.get(name).getScore());
        }
        Jeu.meilleur_score_global = Collections.max(intValues);
        return Integer.toString(Collections.max(intValues));
      }
}