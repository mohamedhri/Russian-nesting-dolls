package src;
import java.util.Scanner;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

 abstract class Poupee {
    private   int taille ;
    private boolean ouverte;

    public Poupee(int taille){
        this.taille=taille;
        this.ouverte=false;
    }
    public int getTaille(){
        return taille;
    }
    public void ouvrir() {
        ouverte= true;
        System.out.println("la poupee est ouverte .");

    }
    public void fermer (){
        ouverte=false;
        System.out.println("la poupee est fermee");
    }
    public abstract void placerDans(Poupee a);
    public abstract void sortirDe (Poupee a);



    
}
