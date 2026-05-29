import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashMap<String, Students> hash = new HashMap<>();

        while(true){
            System.out.println("1--> See list || 2--> Add more || 3--> Exit");
            int opt = sc.nextInt();
            sc.nextLine(); // FIX buffer

            if(opt == 1){
                for(String key : hash.keySet()){
                    System.out.println("\n--- Student ---");
                    System.out.println(hash.get(key));
                }
            }

            else if(opt == 2){
                System.out.println("Enter name (or type Exit to Exit):");
                String name = sc.nextLine();

                if(name.equalsIgnoreCase("exit")) break;

                System.out.println("Enter age:");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter Address:");
                String address = sc.nextLine();

                System.out.println("Enter hobby:");
                String hobby = sc.nextLine();

                Students s = new Students(name, age, address, hobby);
                hash.put(name, s);
            }

            else if(opt == 3){
                break;
            }
        }
    }
}