import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(True){
            System.out.println("Enter name (or type Exit to Exit):");
            String name1 = sc.nextLine();
            sc.nextLine();
            if(name1.equalsIgnoreCase("exit")) break;


            System.out.println("Enter the age:");
            int age1 = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Address: ");
            String Add = sc.nextLine();

            System.out.println("Enter hobby: ");
            String hobby = sc.nextLine();
            sc.nextLine();

            Students s = new Students(name1, age1, Add, hobby);
            hash.put(s.getName(), s);

        }

//        Students s1 = new Students("Aryan",13, "123 new street road", "japanese" );
//        Students s2= new Students("harish",12, "123 old street road", "skating" );
//
//        HashMap<String, Students> hash =new HashMap<>();
//        hash.put(s1.getName(), s1);
//        hash.put(s2.getName() ,s2 );

//        System.out.println(hash.get("Aryan"));

    }
}