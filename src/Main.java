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
                String name = "";
                String address = "";
                int age = 0;
                String hobby = "";

                //Name
                while(true){
                    try{
                        System.out.println("Enter name (or type Exit to Exit):");
                         name = sc.nextLine();
                        if(name.equalsIgnoreCase("exit")) break;
                        if(name.isEmpty() || !name.matches("[a-z A-Z]+")) throw new Exception("Invalid name");
                        break;
                    } catch (Exception e) {
                        System.out.println(" Invalid Name ");
                    }
                }

                //Age
                while(true){
                    try{
                        System.out.println("Enter age:");
                         age = sc.nextInt();
                         sc.nextLine();
                         break;
                    } catch (Exception e) {
                        System.out.println("invalid age");
                        sc.nextLine();
                    }
                }
//                sc.nextLine();
//              address
                while(true){
                    try{
                        System.out.println("Enter Address:");
                         address = sc.nextLine();
                         if(address.isEmpty()) throw new Exception("Address invalid");
                         break;

                    } catch (Exception e) {
                        System.out.println("Invalid");
                    }
                }
                //hobby
                while (true){
                    try{
                        System.out.println("Enter hobby:");
                         hobby = sc.nextLine();
                         if(hobby.isEmpty()) throw new Exception("hobby invalid");
                        if(hobby.isEmpty() || !hobby.matches("[a-z A-Z]+")) throw new Exception("Invalid hobby");
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid");
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