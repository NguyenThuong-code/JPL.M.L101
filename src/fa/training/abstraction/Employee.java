package fa.training.abstraction;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.SplittableRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  abstract class Employee implements Serializable {
    private static final String NAME_REGEX = "^[A-Za-z]\\w{5,29}$";
    private static final String ADDRESS_REGEX= "^(\\d{1,}) [a-zA-Z0-9\\s]+(\\,)? [a-zA-Z]+(\\,)? [A-Z]{2} [0-9]{5,6}$";
    private String employeeName ;
    private String dateOfBirth;
    private String address;
    private static String companyName;

    public static boolean validateName(String regex){
        Pattern pattern=Pattern.compile(NAME_REGEX);
        Matcher matcher=pattern.matcher(regex);
        return matcher.matches();
    }
    public static boolean validateDateOfBirth(String dob){
        SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy");
        sdf.setLenient(false);
Boolean valid =false;
        try {
          Date  date= sdf.parse(dob);
          valid =true;
        } catch (ParseException e) {
            e.printStackTrace();
            valid=false;
        }
        return valid;

    }
    public static boolean validateAddress( String address )
    {
        return address.matches(ADDRESS_REGEX);
    }

    public static void setCompanyName(String companyName) {
        Employee.companyName = companyName;
    }
    protected void inputData(Scanner scanner){
        System.out.println("Enter name: ");
        employeeName=scanner.nextLine();
        if (!validateName(employeeName))
            throw new IllegalArgumentException("Name is not valid!");
        System.out.println("Enter birth date: ");
        dateOfBirth=scanner.nextLine();
        if (!validateDateOfBirth(dateOfBirth)){
            throw new IllegalArgumentException("Date Of Birth is not valid!");
        }
        System.out.println("Address: ");
        address=scanner.nextLine();
        if (!validateAddress(address)){
            throw new IllegalArgumentException("Address is not valid!");
        }

    }
    protected void display() {
       System.out.print(employeeName + "\t" + dateOfBirth + "\t" + address +
        "\t" + companyName);
        }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static String getCompanyName() {
        return companyName;
    }
    public abstract double calcSalary();
}
