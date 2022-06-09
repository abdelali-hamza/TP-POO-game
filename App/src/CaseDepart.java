public  class CaseDepart extends Case {
    public CaseDepart() {
        super("Yellow");
    }

    @Override
    public void action(Joueur user,int a) {
        user.PartieDuJoeur.setPosition(user.PartieDuJoeur.getPosition()+a);
    }
}
