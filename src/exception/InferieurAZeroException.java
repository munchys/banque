package exception;

public class InferieurAZeroException extends Exception{

    @Override
    public String getMessage(){
        StringBuilder sb = new StringBuilder("Vous devez passer un ontant supérieur à 0");
        return sb.toString();
    }
}
