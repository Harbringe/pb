package java;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;


public class App {
    Scanner sc = new Scanner(System.in);
    Dbms db = new Dbms();
    

    public User register(Connection con){
        User user = new User(null, null, null, null, null, null, -1);

        System.out.print("Enter your first name: ");
        String fname = sc.nextLine();
        System.out.print("Enter your last name: ");
        String lname = sc.nextLine();
        System.out.print("Enter your email: ");
        String email= sc.nextLine();
        System.out.print("Enter your phone number: ");
        String phno = sc.nextLine();
        System.out.print("Enter type: ");
        int type = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter username of choice: ");
        String username = sc.nextLine();
        System.out.print("Enter your password: ");
        String pwd = sc.nextLine();
        System.out.println(pwd);
        System.out.print("Confirm your password again: ");
        String confirm_pwd = sc.nextLine();
        System.out.println(confirm_pwd);


        int counter = 0;

        while(!pwd.equals(confirm_pwd)){
            System.out.println("Password doesn't match, try again.");
            System.out.print("Enter your password: ");
            pwd = sc.nextLine();
            System.out.print("Confirm your password: ");
            confirm_pwd = sc.nextLine();
            counter++;

            if(counter > 5){
                System.out.println("Too many attempts, registeration terminated.");
                user = null;
                return user;
            }
        }

        user.set_fname(fname);
        user.set_lname(lname);
        user.set_email(email);
        user.set_phno(phno);
        user.set_type(type);
        user.set_pass(pwd);
        user.set_username(username);

        try{
            db.update(user, con);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return user;
    }


    public User login(Connection con){
        System.out.print("Please enter your email ID: ");
        String email = sc.nextLine();

        try{
            User user = db.read(email, con);
            
            System.out.print("Enter password: ");
            String password = sc.nextLine();
            
            int counter = 0;
            while(!user.get_pass().equals(password)){
                System.out.println("Incorrect password. Please re-enter password.");
                System.out.print("Password: ");
                password = sc.nextLine();
                counter++;
                
                if(counter > 5){
                    System.out.println("Too many attempts. Please try again.");
                    user = null;
                }
            }
            
            db.display(email, con);
            return user;
        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;

    }

}
