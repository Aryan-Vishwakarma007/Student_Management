public class Students {
       private String name;
       private int age;
       private String Address;
       private String hobbies;


       // Constructor
       public Students(String name,int age, String Address,String hobbies){
           this.name = name;
           this.age = age;
           this.Address =Address;
           this.hobbies = "No Hobbies";
       }public Students(String name,int age, String Address){
           this.name = name;
           this.age = age;
           this.Address =Address;
           this.hobbies = "No Hobbies";
       }
       public void setinfo(String name,int age, String Address,String hobbies ){
           this.name = name;
           this.age = age;
           this.Address =Address;
           this.hobbies = "No Hobbies";
       }

        public int getAge() {
           return this.age;
        }
        public String getAddress() {
            return this.Address;
        }
        public String getHobbies() {
            return this.hobbies;
        }
        public String  getName() {
            return this.name;
        }
}
