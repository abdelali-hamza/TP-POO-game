import java.io.Serializable;


public class Case implements Serializable {
    protected String color ;

    public Case(String color) {
        this.color = color;
    }
    public void action(Joueur user, int a){

    }
    public String getColor(){
        return this.color;

    }

}