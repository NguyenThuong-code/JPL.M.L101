package fa.training.abstraction;

import java.util.PrimitiveIterator;
import java.util.Scanner;

public class DailyStaff extends Employee{
    private static final int WAGE_DAY=15;
    private double numberOfWorkday;
    @Override
    public double calcSalary() {
        return numberOfWorkday*WAGE_DAY;
    }
    @Override
    protected void inputData(Scanner scanner){
        super.inputData(scanner);
        System.out.println("Enter number of workday: ");
        numberOfWorkday=Double.parseDouble(scanner.nextLine());
        System.out.println("---------------------------");
    }
    @Override
    protected void display(){
        super.display();
        System.out.print("\t" + numberOfWorkday + "\t" + this.calcSalary() + "\n");
    }
}
