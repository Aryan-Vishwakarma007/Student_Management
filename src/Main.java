import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        var sc = new Scanner(System.in);
        var hash = new HashMap<String, Students>();

        while(true){
            System.out.println("1--> See list || 2--> Add more || 3--> Exit || 4--> Remove" );
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
                while (true) {
                    System.out.println("1 -- to add hobby || 2 -- no hobby");
                    int opt1 = sc.nextInt();
                    sc.nextLine(); //

                    if (opt1 == 1) {
                        while (true) {
                            try {
                                System.out.println("Enter hobby:");
                                hobby = sc.nextLine();
                                if (hobby.isEmpty() || !hobby.matches("[a-zA-Z ]+"))
                                    throw new Exception("Invalid hobby");
                                break;
                            } catch (Exception e) {
                                System.out.println("Invalid, try again");
                            }
                        }
                        break; //
                    } else if (opt1 == 2) {
                        hobby = null;
                        break;
                    }
                }
                var s = new Students(name, age, address, hobby);
                hash.put(name, s);
            }

            else if(opt == 3){
                break;
            }
            else if(opt == 4){
                while(true){
                    try{
                        System.out.println("Enter the name of Student: ");
                        String remove = sc.nextLine();
                        if(hash.containsKey(remove)){
                            hash.remove(remove);
                            break;
                        }
                        else {
                            System.out.println("invalid name");
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}