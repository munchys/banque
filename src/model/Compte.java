package model;

import java.util.List;

public abstract class Compte {
//    private static List<Compte> listeCompte;
    private static int nbComptes = 0;
    private int code;
    protected float solde;

    Compte(float solde){
        Compte.nbComptes++;
        this.code = Compte.nbComptes;
//        Compte.listeCompte.add(this);
        this.solde = solde;

    }
    protected boolean verifieMontantSuperieurA0(float montant){
        return montant > 0;
    }
    protected void verser(float montant){
        if(montant < 0){
            System.out.println("pas de montant négatif");
            return;
        }
        this.solde += montant;
    }
    protected void retirer(float montant){
        if(montant < 0){
            System.out.println("pas de montant négatif");
            return;
        }
        else if(solde - montant <0){
            System.out.println("pas assez d'argent");
            return;
        }
        this.solde -= montant;
    }

    public int getCode() {
        return code;
    }


    @Override
    public String toString(){
        return String.format("Compte[solde:%f]", this.solde);
    }

}
