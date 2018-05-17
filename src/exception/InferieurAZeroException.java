package exception;

public class InferieurAZeroException extends Exception{

    @Override
    public String getMessage(){
        StringBuilder sb = new StringBuilder("un montant inférieur à 0 à été passé");
        return sb.toString();
    }
}
