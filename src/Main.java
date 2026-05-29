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
                String name;
                String address;
                int age;
                String hobby;
                while(true){
                    try{
                        System.out.println("Enter name (or type Exit to Exit):");
                         name = sc.nextLine();
                        if(name.equalsIgnoreCase("exit")) break;
                        break;
                    } catch (Exception e) {
                        System.out.println(" Invalid Name ");
                        sc.nextLine();
                    }
                }
                sc.nextLine();
                while(true){
                    try{
                        System.out.println("Enter age:");
                         age = sc.nextInt();
                         break;
                    } catch (Exception e) {
                        System.out.println("invalid age");
                        sc.nextLine();
                    }
                }
//                sc.nextLine();

                while(true){
                    try{
                        System.out.println("Enter Address:");
                         address = sc.nextLine();
//                         break;

                    } catch (Exception e) {
                        System.out.println("Invalid");
                        sc.nextLine();
                    }
                }
                sc.nextLine();
                while (true){
                    try{
                        System.out.println("Enter hobby:");
                         hobby = sc.nextLine();
                         break;
                    } catch (Exception e) {
                        System.out.println("Invalid");
                        sc.nextLine();
                    }
                }

                Students s = new Students(name, age, address, hobby);
                hash.put(name, s);
            }

            else if(opt == 3){
                break;
            }
        }
    }
}