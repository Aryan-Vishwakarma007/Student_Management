import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        Students s1 = new Students("Aryan",13, "123 new street road", "japanese" );
        Students s2= new Students("harish",12, "123 old street road", "skating" );

        HashMap<String, Students> hash =new HashMap<>();
        hash.put(s1.getName(), s1);
        hash.put(s2.getName() ,s2 );
//        System.out.println(hash);
        System.out.println(hash.get("Aryan"));

    }
}