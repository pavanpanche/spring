# 🏨 Hotel Reservation System

A Java-based Hotel Reservation System built using the **Spring Framework (without Spring Boot)** and **MySQL** for data persistence. The system handles hotel and room management, customer details, and room reservations.

## 📦 Technologies Used

- Java (JDK 8+)
- Spring Framework (Core, JDBC, Context)
- MySQL
- Maven (or manual JAR handling)
- JDBC Template
- XML-based Spring Configuration

---

## 📁 Project Structure

hotel-reservation-system/
├── com.hotel.config/
│ └── AppConfig.java (optional if using XML config)
├── com.hotel.model/
│ ├── Customer.java
│ ├── Hotel.java
│ ├── Room.java
│ └── Reservation.java
├── com.hotel.dao/
│ ├── CustomerDAO.java
│ ├── HotelDAO.java
│ ├── RoomDAO.java
│ └── ReservationDAO.java
├── com.hotel.service/
│ ├── CustomerService.java
│ ├── HotelService.java
│ ├── RoomService.java
│ └── ReservationService.java
├── com.hotel.main/
│ └── MainApp.java
└── resources/
└── applicationContext.xml

---

## 🛠️ Features

- Add and manage customers
- Add hotels and rooms
- Book rooms by date range
- Cancel reservations
- View available rooms
- List all reservations

---

## 🗃️ Database Setup

### Create a MySQL database:
```sql
CREATE DATABASE hotel_reservation_db;
USE hotel_reservation_db;
```


---

## ▶️ How to Run

- Compile and build the project in your IDE or using javac.

- Ensure MySQL is running and tables are created.

- Run MainApp.java to test functionality:

- Add customer, hotel, room

- Make reservation

- Print all reservations

---

## 📌 Notes
- This project uses Spring XML-based configuration, not Spring Boot.

- You must manually create the MySQL schema.

- For simplicity, business validation (like date conflicts) is minimal.

---

## ✍️Author
**Pavan panche**
- Github: ***@pavanpanche***

---

## 📃 License
This project is for educational/demo purposes.

---





