package model;

public class CompteEpargne extends Compte{
    private float tauxInteret;

    CompteEpargne(float solde, float tauxInteret){
        super(solde);
        this.tauxInteret = tauxInteret;
    }
    public void calculInteret(){
        this.solde += this.solde*tauxInteret;
    }
}
