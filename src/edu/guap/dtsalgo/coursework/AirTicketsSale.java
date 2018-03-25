package edu.guap.dtsalgo.coursework;

import edu.guap.dtsalgo.coursework.collections.AVLTree;
import edu.guap.dtsalgo.coursework.collections.Hashtable;
import edu.guap.dtsalgo.coursework.collections.SortedLinkedList;
import edu.guap.dtsalgo.coursework.valueobj.Flight;
import edu.guap.dtsalgo.coursework.valueobj.Passenger;
import edu.guap.dtsalgo.coursework.valueobj.PassportId;
import edu.guap.dtsalgo.coursework.valueobj.Ticket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AirTicketsSale {

    static private Hashtable<PassportId, Passenger> passengers = new Hashtable<>();

    static private AVLTree<Flight> flights = new AVLTree<>();

    static private SortedLinkedList<Ticket> tickets = new SortedLinkedList<>();

    public static void main(String[] args) throws IOException {
        boolean quit = false;
        while (!quit) {
            printMenu();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int actionNo = 0;
            while (true) {
                try {
                    System.out.println("Choose menu (enter number): ");
                    actionNo = Integer.parseInt(br.readLine());
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e);
                }
            }
            switch (actionNo) {
                case 1:
                    Passenger p = createPassenger(br);
                    passengers.put(p.getPassportId(), p);
                    break;
                case 2:
                    System.out.println("Passport id: ");
                    passengers.remove(new PassportId(br.readLine()));
                    break;
                case 3:
                    System.out.println("Passenger:");
                    for (PassportId pid : passengers) {
                        System.out.println(passengers.get(pid));
                    }
                    break;
                case 7:
                   //Flight f = ;//Similar for other menus

                case 0:
                default:
                    quit = true;

            }
        }
    }

    private static Passenger createPassenger(BufferedReader br) throws IOException {
        PassportId pId = null;
        while (true) {
            try {
                System.out.println("Passport id: ");
                pId = new PassportId(br.readLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
        System.out.println("Issued by: ");
        String ib = br.readLine();
        System.out.println("Full name: ");
        String fn = br.readLine();
        System.out.println("Birth day: ");
        String bd = br.readLine();
        return new Passenger(pId, ib, fn, bd);
    }

    private static void printMenu() {
        System.out.println("==============");
        System.out.println("Menu");
        System.out.println();
        System.out.println("-- Passengers:");
        System.out.println("1 Add passenger");
        System.out.println("2 Remove passenger");
        System.out.println("3 List passenger");
        System.out.println("4 Remove all passengers");
        System.out.println("5 Search passenger by passport id");
        System.out.println("6 Search passengers by full name");
        System.out.println();
        System.out.println("-- Flights:");
        System.out.println("7 Add flight");
        System.out.println("8 Remove flight");
        System.out.println("9 Remove all flights");
        System.out.println("10 Search flights by arrival");
        System.out.println();
        System.out.println("-- Sell/Return");
        System.out.println("11 Sell ticket");
        System.out.println("12 Return ticket");
        System.out.println();
        System.out.println("0 Quit");
    }
}
