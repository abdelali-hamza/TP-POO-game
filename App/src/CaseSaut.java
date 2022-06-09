
public class CaseSaut extends Case {
    public CaseSaut() {
        super("orange");
    }
    @Override
    public void action (Joueur player,int a){
        System.out.println((int)(Math.random() * 100));
        player.PartieDuJoeur.setPosition((int)(Math.random() * 100));
    }

}
