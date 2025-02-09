import java.util.*;

class Ticketcancelling extends Ticketbooking {
    public static void cancelticket(int id) {
        Iterator<Passenger> iterator = confirmedtickets.iterator();
        while (iterator.hasNext()) {
            Passenger p = iterator.next();
            if (p.id == id) {
                String berth = p.berth;
                System.out.println(p);
                iterator.remove(); // Safe removal

                if (raclist.isEmpty()) {
                    Ticketbooking.addractoavailable(berth);
                    moveracticket();
                } else {
                    Passenger x = raclist.poll();
                    if (x != null) {
                        x.berth = berth;
                        confirmedtickets.add(x);
                    }
                }
                System.out.println("Ticket cancelled successfully");
                return; // Exit after cancellation
            }
        }

        iterator = raclist.iterator();
        while (iterator.hasNext()) {
            Passenger p = iterator.next();
            if (p.id == id) {
                System.out.println(p);
                iterator.remove(); // Safe removal
                if (!waitinglist.isEmpty()) {
                    raclist.offer(waitinglist.poll());
                }
                movewaitingticket();
                System.out.println("Ticket cancelled successfully");
                return;
            }
        }

        iterator = waitinglist.iterator();
        while (iterator.hasNext()) {
            Passenger p = iterator.next();
            if (p.id == id) {
                System.out.println(p);
                iterator.remove();
                System.out.println("Ticket cancelled successfully");
                return;
            }
        }
    }

    public static void moveracticket() {
        if (!raclist.isEmpty()) {
            Passenger p = raclist.poll();
            if (p != null) {
                confirmedtickets.add(p);
            }
        }
    }

    public static void movewaitingticket() {
        if (!waitinglist.isEmpty()) {
            Passenger p = waitinglist.poll();
            if (p != null && raclist.size() <= 1) {
                raclist.offer(p);
            }
        }
    }
}
