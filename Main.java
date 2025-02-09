import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        boolean loop=true;
        
        while(loop){
        System.out.println("1. Book Ticket");
        System.out.println("2. Cancel Ticket");
        System.out.println("3. view confirmed ticket");
        System.out.println("4. view rac ticket");
        System.out.println("5. view waiting ticket");
        System.out.println("6. view available ticket");
        System.out.println("7. exit");
        int a=sc.nextInt();

            switch(a){
                case 1:
                    System.out.println("Enter Name:");
                    String name=sc.next();
                    System.out.println("Enter age:");
                    int age=sc.nextInt();
                    System.out.println("Enter Gender");
                    String gender=sc.next();
                    System.out.println("Enter Preference:");
                    String preference=sc.next();
                    Ticketbooking.bookticket(name,age,gender,preference);
                    break;

                case 2:
                    System.out.println("Enter Ticket id:");
                    int id=sc.nextInt();
                    Ticketcancelling.cancelticket(id);
                    break;

                case 3:
                    Ticketbooking.printconfirmedticket();
                    break;

                case 4:
                    Ticketbooking.printraclist();
                    break;

                case 5:
                    Ticketbooking.printwaitinglist();
                    break;

                case 6:
                    Ticketbooking.printavailableticket();
                    break;

                case 7:
                    loop=false;
                    System.out.println("Thank You");
                    break;
                

            }

        }
    }
}