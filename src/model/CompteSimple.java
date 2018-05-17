package model;

import exception.InferieurAZeroException;
import model.Compte;
import exception.SoldeInsuffisantException;

public class CompteSimple extends Compte {
    private float decouvert;

    public CompteSimple(float solde, float decouvert){
        super(solde);
        this.decouvert = decouvert;
    }

    public float getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(float decouvert) throws InferieurAZeroException {
        if(decouvert <0){
            throw new InferieurAZeroException();
        }
        this.decouvert = decouvert;
    }

    public void retirer(float montant) throws InferieurAZeroException, SoldeInsuffisantException {
        if(montant < 0){
            throw new InferieurAZeroException();
        }
        else if(montant > solde+decouvert){
            throw new SoldeInsuffisantException();
        }
        this.solde -= montant;
    }

    @Override
    public String toString(){
        return String.format("CompteSimple[code:%d, solde:%.2f, decouvert:%.2f]", this.getCode(), this.solde, this.decouvert);
    }

}
