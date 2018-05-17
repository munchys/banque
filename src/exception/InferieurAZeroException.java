package exception;

public class InferieurAZeroException extends Exception{

    @Override
    public String getMessage(){
        StringBuilder sb = new StringBuilder("Vous devez passer un montant supérieur à 0");
        return sb.toString();
    }
}
