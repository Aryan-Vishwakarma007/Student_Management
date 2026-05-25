import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        Students s1 = new Students("Aryan",13, "123 new street road" , "games");

        System.out.println(s1.getAddress()+s1.getHobbies());
        HashMap<String, Students> hash =new HashMap<>();

    }
}