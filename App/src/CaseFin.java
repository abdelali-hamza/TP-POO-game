public class CaseFin extends Case {

    public CaseFin() {
        super("Black");
    }
    @Override
    public void action(Joueur user,int a){
        Jeu game = new Jeu();
        System.out.println("Case Fin");
        System.out.println("Vous avez gagne");
        if (Jeu.meilleur_score_global < user.PartieDuJoeur.getScore()) {
          Jeu.meilleur_score_global = user.PartieDuJoeur.getScore();
        }
        System.out.println(Jeu.meilleur_score_global);
      
    }
    
}
