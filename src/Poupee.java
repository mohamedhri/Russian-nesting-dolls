
package src;


public abstract class Poupee {
    private int taille;
    private boolean ouverte;

    public Poupee(int taille) {
        this.taille = taille;
        this.ouverte = false;
    }


    public int getTaille() {

        return taille;
    }
    public boolean isOuverte (){
        return ouverte;
    }
    public void setOuverte (boolean ouverte){
        this.ouverte=ouverte;
    }

    public boolean estOuverte() {
        return ouverte;
    }

    public abstract void ouvrir();


    public abstract void fermer();


    public abstract void placerDans(Poupee p);

    public abstract void sortirDe(Poupee p);
}
