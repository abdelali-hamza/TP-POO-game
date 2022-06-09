public class CaseMalus extends Case {

    public CaseMalus() {
        super("Red");
    }
    @Override
    public void action(Joueur player,int a) {
        player.PartieDuJoeur.setScore(player.PartieDuJoeur.getScore()-10);
        player.PartieDuJoeur.setPosition(player.PartieDuJoeur.getPosition()-2);
    } 

}
