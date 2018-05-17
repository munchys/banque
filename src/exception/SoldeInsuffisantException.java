package exception;

public class SoldeInsuffisantException extends Exception{

    @Override
    public String getMessage(){
        StringBuilder sb = new StringBuilder("un problème à été rencontré");
        sb.append(" le solde est insufisant");
        return sb.toString();
    }
}
