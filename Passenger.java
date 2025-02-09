import java.util.*;
class Passenger{
    String name;
    int age;
    String gender;
    String berth;
    int id;

    Passenger(String name,int age,String gender,String berth,int id){
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.berth=berth;
        this.id=id;
    }
    

    public String toString(){
        return "Passenger id = "+id+"\nPasseneger Name : "+name+"\n Passenger age = "+age+"\n Passenger berth = "+berth;
    }

}