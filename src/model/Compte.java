package model;

import exception.SoldeInsuffisantException;
import exception.InferieurAZeroException;

public abstract class Compte {
//    private static List<Compte> listeCompte;
    private static int nbComptes = 0;
    private int code;
    protected float solde;

    public static int getNbComptes(){
        return nbComptes;
    }

    Compte(float solde){
        Compte.nbComptes++;
        this.code = Compte.nbComptes;
//        Compte.listeCompte.add(this);
        this.solde = solde;
    }
    public void verser(float montant) throws InferieurAZeroException{
        if(montant < 0){
            throw new InferieurAZeroException();
        }
        this.solde += montant;
    }
    public void retirer(float montant) throws InferieurAZeroException, SoldeInsuffisantException{
        if(montant < 0){
            throw new InferieurAZeroException();
        }
        else if(montant > solde){
            throw new SoldeInsuffisantException();
        }
        this.solde -= montant;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString(){
        return String.format("Compte[code:%d,solde:%.2f]", this.getCode(), this.solde);
    }

}
