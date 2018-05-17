package model;

import exception.InferieurAZeroException;
import exception.SoldeInsuffisantException;

public class ComptePayant extends Compte {
    private float tauxPaiement = 0.05f;

    public ComptePayant(float solde){
        super(solde);
    }

    public void retirer(float montant) throws InferieurAZeroException, SoldeInsuffisantException {
        if(montant <0 ){
            throw new InferieurAZeroException();
        }
        montant += montant * tauxPaiement;
        this.solde -= montant;
    }
    public void verser(float montant) throws InferieurAZeroException{

        this.solde -= montant + montant * tauxPaiement;
    }

    @Override
    public String toString(){
        return String.format("ComptePayant[code:%d, solde:%.2f, tauxPaiement:%.2f]", this.getCode() ,this.solde, this.tauxPaiement);
    }

}
