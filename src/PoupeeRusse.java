
package src;


public class PoupeeRusse extends Poupee {
    private PoupeeRusse poupeeInterne;


    public PoupeeRusse(int taille) {
        super(taille);
        this.poupeeInterne = null;
    }

    @Override
    public void ouvrir() {
        setOuverte(true);
        System.out.println("La poupée russe de taille " + getTaille() + " est ouverte.");
    }


    @Override
    public void fermer() {
        setOuverte(false);
        System.out.println("La poupée russe de taille " + getTaille() + " est fermée.");
    }

    @Override
    public void placerDans(Poupee p) {
        if (p != null && p instanceof PoupeeRusse) {
            ((PoupeeRusse) p).poupeeInterne = this;
            System.out.println("La poupée russe de taille " + getTaille() + " a été placée dans une autre poupée.");
        } else {
            System.out.println("Impossible de placer la poupée dans un objet non valide.");
        }
    }

    @Override
    public void sortirDe(Poupee p) {
        if (p != null && p instanceof PoupeeRusse) {
            ((PoupeeRusse) p).poupeeInterne = null;
            System.out.println("La poupée russe de taille " + getTaille() + " a été sortie de l'autre poupée.");
        } else {
            System.out.println("Impossible de sortir la poupée d'un objet non valide.");
        }
    }


    public PoupeeRusse getPoupeeInterne() {
        return poupeeInterne;
    }
}
