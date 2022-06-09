public class CaseParcours extends Case {

    


    public CaseParcours() {
        super("Grey");
    }

    @Override
    public void action(Joueur user,int a) {
        user.PartieDuJoeur.setPosition(user.PartieDuJoeur.getPosition()+a);
    }

}
