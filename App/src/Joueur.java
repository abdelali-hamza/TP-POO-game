import java.io.Serializable;

public class Joueur implements Serializable {

    protected String UserName;
    protected int MaxScore;
    protected Partie  PartieDuJoeur = new Partie();

    public Joueur(String userName) {
        UserName = userName;
        MaxScore = 0;
    }

    public String getNom() {
        return UserName;
    }

    public void setNom(String nom) {
        UserName = nom;
    }

    public int getScore() {
        return MaxScore;
    }

    public void setScore(int score) {
        MaxScore = score;
    }

    public int getPosition() {
        return PartieDuJoeur.getPosition();
    }

    public void setPosition(int position) {
        PartieDuJoeur.setPosition(position); 
    }
    

}