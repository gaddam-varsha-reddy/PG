package com.wavemaker;

import com.wavemaker.manager.*;
import com.wavemaker.manager.implementation.*;
import com.wavemaker.model.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        UserdetailsManager userdetailsManager =new UserdetailsOperations();
        RoomManager roomManager=new RoomOperations();
        RoomBedManager roomBedManager=new RoomBedOperations();
        BookingManager bookingManager=new BookingOperations();
        BedManager bedManager=new BedOperations();
        MonthdetailsManager monthDetailsImplementation=new MonthdetailsImplementation();
        paymentManager paymentManager=new paymentOperations();
        int n= sc.nextInt();
        while(n!=20) {
            switch (n) {
                case 1:
                    System.out.println("Display Users");
                    List<Userdetails> userdetailsList;
                    userdetailsList = userdetailsManager.displayUsers();
                    for(Userdetails listItem: userdetailsList){
                        System.out.println("Id:" +listItem.getId()+"\tFirst_Name:" +listItem.getFirstName() + "\tLast_Name:"+ listItem.getLastName() +"\tMobile_No:" +listItem.getMobileNo() + "\tEmail:" +listItem.getEmail()+ "\tDob:" + listItem.getDob() + "\tisActive:" + listItem.getisActive());
                    }
                    System.out.println("enter n");
                    n = sc.nextInt();
                    break;
                case 2:
                    System.out.println("Add Room");
                    int id=0;
                    System.out.println("Enter roomno");
                    int roomno=sc.nextInt();
                    System.out.println("Enter floorno");
                    int floorno=sc.nextInt();
                    System.out.println("Enter totalbeds");
                    int totalbeds=sc.nextInt();
                    roomManager.addRoom(new Room(id,roomno,floorno,totalbeds));
                    System.out.println("Enter n");
                    n=sc.nextInt();
                    break;
                case 3:
                    System.out.println("display all rooms");
                    List<RoomBed> roombedList=roomBedManager.displayAllRooms();
                    for(RoomBed listItem:roombedList){
                        System.out.println("Room_No:" +listItem.getRoomNo()+"\tFloor_No:" +listItem.getFloorNo()+"\tTotalBeds:" + listItem.getTotalBeds()+"\tBed_No:" +listItem.getBedNo()+ "\tisfull:"+ listItem.getisFull() +"\tcost:" + listItem.getCost());
                    }
                    System.out.println("Enter n");
                    n=sc.nextInt();
                    break;
                case 4:
                    System.out.println("Enter first name");
                    String firstName=sc.next();
                    System.out.println("Enter last name");
                    String lastName=sc.next();
                    System.out.println("Enter mobile no");
                    String mobileNo=sc.next();
                    System.out.println("Enter email");
                    String email=sc.next();
                    System.out.println("Enter dob");
                    String dob=sc.next();
                    userdetailsManager.addUser(new Userdetails(1,firstName,lastName,mobileNo,email,dob,true));
                    System.out.println("Enter n");
                    n=sc.nextInt();
                    break;
                case 5:
                    System.out.println("Enter user to search");
                    email=sc.next();
                    id= userdetailsManager.searchUserId(email);
                    System.out.println(id);
                    System.out.println("Enter n");
                    n=sc.nextInt();
                    break;
                case 6:
                    System.out.println("Display Booking");
                    List<Bookingdetails> bookingList= bookingManager.displayBooking();
                    for(Bookingdetails listItem:bookingList){
                        System.out.println("Email:" +listItem.getEmail()+"\tisActive:" +listItem.getisActive()+"\troomNo:" + listItem.getRoomNo()+"\tBed_No:" +listItem.getBedNo()+ "\tfloorNo:"+ listItem.getFloorNo() +"\tcost:" + listItem.getCost());
                    }
                    System.out.println("Enter n");
                    n=sc.nextInt();
                    break;
                case 7:
                    System.out.println("Adding Booking");
                    int userId=sc.nextInt();
                    int bedId=sc.nextInt();
                    bookingManager.addBooking(userId,bedId);
                    System.out.println("enter n");
                    n=sc.nextInt();
                    break;
                case 8:
                    System.out.println("Update Userdetails Status");
                    id=sc.nextInt();
                    userdetailsManager.updateUserStatusVaccant(id);
                    System.out.println("enter n");
                    n=sc.nextInt();
                    break;
                case 9:
                    System.out.println("Update Booking Status");
                    userId=sc.nextInt();
                    bedId=sc.nextInt();
                    bookingManager.updateBookingStatusVaccant(userId,bedId);
                    System.out.println("enter n");
                    n=sc.nextInt();
                    break;
                case 10:
                    System.out.println("Update Bed Status occupied");
                    id=sc.nextInt();
                    bedManager.updateBedStatusOccupied(id);
                    System.out.println("enter n");
                    n=sc.nextInt();
                    break;
                case 11:
                    System.out.println("Update Bed Status vaccant");
                    id=sc.nextInt();
                    bedManager.updateBedStatusVaccant(id);
                    System.out.println("enter n");
                    n=sc.nextInt();
                    break;
                case 12:
                    System.out.println("Enter bed to search");
                    roomno= sc.nextInt();
                    floorno=sc.nextInt();
                    int bedno=sc.nextInt();
                    id=bedManager.searchBedId(roomno,floorno,bedno);
                    System.out.println(id);
                    System.out.println("Enter n");
                    n=sc.nextInt();
                    break;
                case 13:
                    System.out.println("add month");
                    String month=sc.next();
                    int year=sc.nextInt();
                    monthDetailsImplementation.addMonth(month,year);
                    System.out.println("Enter n");
                    n=sc.nextInt();
                    break;
                case 14:
                    System.out.println("Display month details");
                    List<MonthDetails> monthlist=monthDetailsImplementation.displayMonthDetails();
                    for(MonthDetails listItem:monthlist){
                        System.out.println("month" +listItem.getMonth()+"\tyear" +listItem.getYear());
                    }
                    System.out.println("Enter n");
                    n=sc.nextInt();
                    break;
                case 15:
                    System.out.println("search month id");
                    month=sc.next();
                    year=sc.nextInt();
                    id=monthDetailsImplementation.searchMonthId(month,year);
                    System.out.println(id);
                    System.out.println("Enter n");
                    n=sc.nextInt();
                    break;
                case 16:
                    System.out.println("add payment");
                    bedId=sc.nextInt();
                    int monthId=sc.nextInt();
                    paymentManager.addPayment(bedId,monthId);
                    System.out.println("Enter n");
                    n=sc.nextInt();
                    break;
                case 17:
                    System.out.println("Display payment");
                    List<Paymentdetails> paymentlist=paymentManager.displayPaymentDetails();
                    for(Paymentdetails listItem:paymentlist){
                        System.out.println("roomNo:" + listItem.getRoomNo() +"\tfloorNo" + listItem.getFloorNo() + "\tbedno:"+ listItem.getBedNo() +"\tmonth" +listItem.getMonth()+"\tyear" +listItem.getYear());
                    }
                    System.out.println("Enter n");
                    n=sc.nextInt();
                    break;
                case 18:
                    System.out.println("Add Booking ");
                    roomno= sc.nextInt();
                    floorno=sc.nextInt();
                    bedno=sc.nextInt();
                    int bedid=bedManager.searchBedId(roomno,floorno,bedno);
                    if(bedid!=-1){
                         firstName=sc.next();
                         System.out.println("Enter last name");
                         lastName=sc.next();
                        System.out.println("Enter mobile no");
                         mobileNo=sc.next();
                        System.out.println("Enter email");
                         email=sc.next();
                        System.out.println("Enter dob");
                         dob=sc.next();
                        userdetailsManager.addUser(new Userdetails(1,firstName,lastName,mobileNo,email,dob,true));
                        int userid= userdetailsManager.searchUserId(email);
                        if(userid!=-1){
                            bookingManager.addBooking(userid,bedid);
                            bedManager.updateBedStatusOccupied(bedid);
                        }
                        else {
                            System.out.println("user id error");
                        }
                    }

                    else {
                        System.out.println("Bed id error");
                    }
                    System.out.println("Enter n");
                    n=sc.nextInt();
                    break;
                case 19:
                    System.out.println("Delete booking");
                    roomno= sc.nextInt();
                    floorno=sc.nextInt();
                    bedno=sc.nextInt();
                    bedid=bedManager.searchBedId(roomno,floorno,bedno);
                    if(bedid!=-1){
                        email=sc.next();
                       int userid= userdetailsManager.searchUserId(email);
                       if(userid!=-1){
                           int bookingid=bookingManager.searchBookingId(userid,bedid);
                           if(bookingid!=-1){
                               bookingManager.updateBookingStatusVaccant(userid,bedid);
                               bedManager.updateBedStatusVaccant(bedid);
                               userdetailsManager.updateUserStatusVaccant(userid);
                           }
                           else {
                               System.out.println("Booking id error");
                           }
                       }
                       else {
                           System.out.println("user id error");
                       }
                    }

                    else {
                        System.out.println("Bed id error");
                    }
                    System.out.println("Enter n");
                    n=sc.nextInt();
                    break;
                case 21:
                    System.out.println("Add Payment");
                    roomno= sc.nextInt();
                    floorno=sc.nextInt();
                    bedno=sc.nextInt();
                    bedid=bedManager.searchBedId(roomno,floorno,bedno);
                    if(bedid!=-1){
                        month=sc.next();
                        year=sc.nextInt();
                        int monthid=monthDetailsImplementation.searchMonthId(month,year);
                        if(monthid!=-1){
                            paymentManager.addPayment(bedid,monthid);
                        }

                    }
                    System.out.println("Enter n");
                    n=sc.nextInt();
                    break;
                case 22:
                    System.out.println("display only rooms");
                    List<Room> roomList=roomManager.displayOnlyRoom();
                    for(Room listItem:roomList){
                        System.out.println("Id" +listItem.getId()+"\tFloor_No:" +listItem.getFloorNo()+"\tTotalBeds:" + listItem.getTotalBeds()+"\tRoom_No:" +listItem.getRoomNo());
                    }
                    System.out.println("Enter n");
                    n=sc.nextInt();
                    break;
                    case 23:
                        System.out.println("active users");
                        id=userdetailsManager.activeUserCount();
                        System.out.println(id);
                        System.out.println("Enter n");
                        n=sc.nextInt();
                        break;


            }
        }
    }
}
