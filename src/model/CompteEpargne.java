package model;

public class CompteEpargne extends Compte{
    private float tauxInteret;

    public CompteEpargne(float solde, float tauxInteret){
        super(solde);
        this.tauxInteret = tauxInteret;
    }

    public float getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(float tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    public void calculInteret(){
        this.solde += this.solde * tauxInteret;
    }

    @Override
    public String toString(){
        return String.format("CompteEpargne[code:%d, solde:%.2f, tauxInteret:%.2f]",this.getCode() ,this.solde, tauxInteret);
    }

}
