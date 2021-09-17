package GUI;

public class Validation {


    public boolean isValidFormat(String format){
    	return format.matches("\\((-?\\d+(?:,\\s*-?\\d+)*)\\)");
    }


}
