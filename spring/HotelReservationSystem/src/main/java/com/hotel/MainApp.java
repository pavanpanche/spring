package com.hotel;

import com.hotel.config.AppConfig;
import com.hotel.model.Hotel;
import com.hotel.model.Reservation;
import com.hotel.service.HotelService;
import com.hotel.service.ReservationService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        HotelService hotelService = context.getBean(HotelService.class);
        ReservationService reservationService = context.getBean(ReservationService.class);

        Scanner sc = new Scanner(System.in);
        int choice = -1;

        do {
            System.out.println("\n=== Hotel Reservation System ===");
            System.out.println("1. List Hotels");
            System.out.println("2. Book Room");
            System.out.println("3. View Reservations");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    List<Hotel> hotels = hotelService.listAllHotels();
                    for (Hotel h : hotels) {
                        System.out.println(h.getHotelId() + ". " + h.getName() + " - " + h.getLocation());
                    }
                    break;

                case 2:
                    System.out.print("Enter Hotel ID: ");
                    int hotelId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Check-In Date (YYYY-MM-DD): ");
                    String checkIn = sc.nextLine();

                    System.out.print("Enter Check-Out Date (YYYY-MM-DD): ");
                    String checkOut = sc.nextLine();

                    System.out.println("-------------------------------");
                    System.out.println(" AC  | Non AC | Luxury with AC ");

                    System.out.print("Enter Your Choice: ");
                    String roomType = sc.nextLine();


                    boolean booked = reservationService.reserveRoom(hotelId, name, checkIn, checkOut, roomType);
                    if (booked) {
                        System.out.println("✅ Room booked successfully!");
                    } else {
                        System.out.println("❌ No available rooms or error occurred.");
                    }
                    break;

                case 3:
                    List<Reservation> reservations = reservationService.getAllReservationInfo();
                    for (Reservation r : reservations) {
                        System.out.println(r.getCustomerName() + " - Room ID: " + r.getRoomId() +
                                " - From: " + r.getCheck_In_Date() + " To: " + r.getCheck_Out_Date() + "  Room Type: " + r.getRoomType() );
                    }
                    break;

                case 0:
                    System.out.println("Exiting. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }while(choice !=0);

        context.close();
    }
}