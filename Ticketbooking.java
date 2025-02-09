import java.util.*;
public class Ticketbooking{
        final static int berthlimit=1;
        static int ticketid=0;
        static ArrayList<String> availableberth=new ArrayList<>();
        static{
            while(availableberth.size()<3*berthlimit){
                availableberth.add("U");
                availableberth.add("M");
                availableberth.add("L");
            }

        }
        static final ArrayList<Passenger> confirmedtickets=new ArrayList<Passenger>();
        static final Queue<Passenger> raclist=new LinkedList<>();
        static final Queue<Passenger> waitinglist=new LinkedList<>();
    
        public static void bookticket(String name,int age,String gender,String preference){
            
            Passenger passenger;
            if(confirmedtickets.size()<3*berthlimit){
                ticketid++;
            String berth=allocateberth(name,age,gender,preference);
            
            passenger=new Passenger(name,age,gender,berth,ticketid);
            confirmedtickets.add(passenger);
            System.out.println("Tickets confirmed:"+passenger);
            }
            else if(raclist.size()<1){
                ticketid++;
                passenger=new Passenger(name,age,gender,"RAC",ticketid);
                raclist.offer(passenger);
                System.out.println("Ticket booked in RAC:"+passenger);
            }
            else if(waitinglist.size()<1){
                ticketid++;
                passenger=new Passenger(name,age,gender,"Waiting list",ticketid);
                waitinglist.offer(passenger);
                System.out.println("Ticket booked in Waitinglist:"+passenger);
            }
            else{
                System.out.println("Unable to Book Tickets");
            }

    }
    private static String allocateberth(String name, int age, String gender, String preference)
    {
        if((age>=60||gender.equals("Female"))&&availableberth.contains("L")){
            availableberth.remove("L");
            return "L";
        }
        else if(availableberth.contains(preference)){
            availableberth.remove(preference);
            return preference;
        }
        String s=availableberth.get(0);
        availableberth.remove(s);
        return s;
        
    }

    public static void addractoavailable(String berth){
        availableberth.add(berth);
    }

    
    
    public static void printconfirmedticket(){
        for(Passenger p:confirmedtickets){
            System.out.println(p);
        }
    }
    
    public static void printraclist(){
        for(Passenger p:raclist){
            System.out.println(p);
        }
    }
    
    public static void printwaitinglist(){
        for(Passenger p:waitinglist){
            System.out.println(p);
        }
    }
    
    public static void printavailableticket(){
            System.out.println("Available tickets:"+(3*berthlimit-confirmedtickets.size()));
            System.out.println("Rac tickets:"+(1-raclist.size()));
            System.out.println("Waiting tickets:"+(1-waitinglist.size()));
        
    }
}




