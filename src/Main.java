import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args){
        var sc = new Scanner(System.in);
        var hash = new HashMap<String, Students>();
        Path path = Paths.get("new_java");

        while(true){
            System.out.println("\n");
            System.out.println("1--> See list || 2--> Add more || 3--> Exit || 4--> Remove || 5--> Search" );
            int opt = sc.nextInt();
            sc.nextLine(); // FIXed

            // opt 1 = see list
            if(opt == 1){
                //Stream APIs!!
                hash.values().stream()
                        .sorted(Comparator.comparing(Students::name))
                        .forEach(n -> {
                            System.out.println("--- Student ---");
                            System.out.println(n);
                        });
            }

            //opt 2 = add more
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

                String json = "{\"name\":\"" + s.name() + "\",\"age\":" + s.age() +
                            ",\"address\":\"" + s.Address() + "\",\"hobbies\":\"" + s.hobbies() + "\"}\n";
                try {
                    Files.writeString(path, json, StandardOpenOption.APPEND,StandardOpenOption.CREATE);
                    System.out.println("Saved");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            //opt 3 = exit
            else if(opt == 3){
                break;
            }

            //opt 4 = remove
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
            } else if (opt == 5) {
                System.out.println("Search By: 1-->Name || 2-->Age || 3--> Hobby");
                int opt2 = sc.nextInt();
                sc.nextLine();
                switch (opt2){
                    case 1->{
                        System.out.println("Enter the name:");
                        String name_item = sc.nextLine();
                        hash.values().stream()
                                .filter(n -> n.name().equalsIgnoreCase(name_item) )
                                .forEach(a -> {
                                    System.out.println("--- Student ---");
                                    System.out.println(a);
                                });
                    }
                    case 2->{
                        System.out.println("Enter the Age: ");
                        int age_item = sc.nextInt();
                        hash.values().stream()
                                .filter(n -> n.age() == age_item)
                                .forEach( (n)-> {
                                    System.out.println("--- Student ---");
                                    System.out.println(n);
                                });
                    }
                    case 3->{
                        while (true){
                            try {
                                System.out.println("Enter the Hobby ('Exit' to exit): ");
                                String hobby_item = sc.nextLine();
                                if(hobby_item.equalsIgnoreCase("Exit")) break;
                                else{
                                    hash.values().stream()
                                            .filter(n -> n.hobbies().trim().equalsIgnoreCase(hobby_item))
                                            .forEach(n -> {
                                                System.out.println("--- Student ---");
                                                System.out.println(n);
                                            });
                                }
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }

                    }


                }

            }

        }
    }
}