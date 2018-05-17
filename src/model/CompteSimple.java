package model;

import model.Compte;

public class CompteSimple extends Compte {
    private float decouvert;

    CompteSimple(float solde, float decouvert){
        super(solde);
        this.decouvert = decouvert;
    }

    public float getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(float decouvert) {
        if(decouvert <0){
            System.out.println("pas de découvert négatif");
            return;
        }
        this.decouvert = decouvert;
    }

    public void retirer(float montant){
        if(montant <0){
            System.out.println("pas de montant négatif");
        }
        else if(montant > solde+decouvert){
            System.out.println("vous n'avez pas assez d'argent");
        }
    }
}
