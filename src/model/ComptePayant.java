package model;

public class ComptePayant extends Compte {
    private float tauxPaiement = 0.05f;

    ComptePayant(float solde){
        super(solde);
    }

    public void retirer(float montant){

        montant += montant * tauxPaiement;
        this.solde -= montant;
    }
    public void verser(float montant){

        this.solde -= montant + montant * tauxPaiement;
    }

}
