package emailApp;

import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 50;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "retailgroups.com";
    private String info;

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        //System.out.print("Email created: \n" + this.firstName + "." + this.lastName);
        this.department = setDepartment();
        System.out.println("Department: " + department);
        this.password = setRandomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        System.out.println("Your email is: " + email);


    }

    private String setDepartment() {
        System.out.print("New worker's name is: " + firstName + "\nDepartment codes:\n1 for Sales\n2 for Development\n3 for Sales\n4 for none\nEnter department code: \n");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {            return "sales";        }
        else if (depChoice == 2) {            return "development";        }
        else if (depChoice == 3) {            return "accounting";        }
        else {            return "none";        }
    }

    private String setRandomPassword(int length) {
        String passwordSet = "ABCDEFGHIGJKLMNOPRSTUVWXYZ0123456789!@#$%&";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int random = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }
        return new String(password);
    }

    //Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    //Change password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() { return mailboxCapacity; }
    public String getAlternateEmail() {return alternateEmail; }
    public String getPassword() {return password; }

    public String showInfo() {
        return "Display name: " + firstName + " " + lastName + "\nCompany email: " + email + "\nMailbox Capacity: " + mailboxCapacity + "mb";
    }
}
