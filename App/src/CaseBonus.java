public class CaseBonus extends Case {

    public CaseBonus() {
        super("Green");
    }
    @Override
    public void action(Joueur player,int a) {
        player.PartieDuJoeur.setScore(player.PartieDuJoeur.getScore()+10);
        player.PartieDuJoeur.setPosition(player.PartieDuJoeur.getPosition()+2);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

}
