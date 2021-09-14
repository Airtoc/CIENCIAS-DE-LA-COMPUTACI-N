package GUI;

public class Validation {


    public boolean isValidFormat(String format){
        return format.matches("\\((\\d{1,3}(?:,\\s*\\d{1,3}){0,2})\\)");
    }


}
