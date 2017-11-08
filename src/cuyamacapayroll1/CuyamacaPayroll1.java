/*
cs-182 
Sam Melero
10/6/17
calculating payroll
 */
package cuyamacapayroll1;
import java.util.Scanner;
enum payType {hourly, salary, temporary, quit};

/**
 *
 * @author samme
 */
public class CuyamacaPayroll1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       Scanner input = new Scanner(System.in);
       
       //get users payType (hourly, salary, part time, temporary)
      
       payType typeOfPay;
       String userPayType, firstName, lastName;
       double pay, hours, grossPay, netPay, tax, retirement;
       final int maxEmployees = 5;
       int count = 0;
       while (count < maxEmployees)
       {
           
           //get users name
            System.out.println("What is your pay type? ( hourly, salary, temporary, quit ):  ");
            userPayType = input.nextLine();
            typeOfPay = getPay (userPayType);
            
            //ask the user the right questions based on pay type
            //and perform calculations
            switch (typeOfPay)
            {
                case salary:
                     System.out.println ("What is your first name?: ");
                    firstName = input.nextLine();
                    System.out.println("What is your last name?: ");
                    lastName = input.nextLine();
                    
                    System.out.println("Enter " + firstName + " " + lastName +"'s yearly salary: ");
                    pay = input.nextDouble();
                    grossPay = pay / 52;
                    tax = grossPay *.18;
                    retirement = grossPay * .04;
                    netPay = grossPay - tax - retirement;   
                    System.out.printf ( " Employee: %s %s\n Gross wages: $%.2f\n Taxes withheld: $%.2f\n Retierment withheld: $%.2f\n Net wages: $%.2f\n", firstName, lastName, grossPay, tax, retirement, netPay );
                    break;
                
                case hourly:
                    System.out.println ("What is your first name?: ");
                    firstName = input.nextLine();
                    System.out.println("What is your last name?: ");
                    lastName = input.nextLine();
                    
                    System.out.println( "Enter " + firstName + " " + lastName +"'s hourly salary: $");
                    pay = input.nextDouble();
                    System.out.println( "Hours worked: " );
                    hours = input.nextDouble();
                   
                    if(hours > 40) //for overtime
                    {
                        grossPay = (hours - 40) * (1.5 * pay);
                        grossPay = grossPay + (pay * 40);
                    }
                    else
                        grossPay = pay * hours;
                    
                    tax = grossPay * .18;
                    netPay = grossPay - tax;
                    
                    //output info
                    System.out.printf ( " Employee: %s %s\n Gross wages: $%.2f\n Taxes withheld: $%.2f\n Net wages: $%.2f\n", firstName, lastName, grossPay, tax, netPay );
                    break;
                    
                case temporary:
                    System.out.println ("What is your first name?: ");
                    firstName = input.nextLine();
                    System.out.println("What is your last name?: ");
                    lastName = input.nextLine();
                    
                    System.out.println( "Enter " + firstName + " " + lastName +"'s hourly salary: ");
                    pay = input.nextDouble();
                    System.out.println( "Hours worked: " );
                    hours = input.nextDouble();
                   
                    if(hours > 40) //for overtime
                    {
                        grossPay = (hours - 40) * (1.5 * pay);
                        grossPay = grossPay + (pay * 40);
                    }
                    else
                        grossPay = pay * hours;                   
                    
                    //output info
                    System.out.printf ( " Employee: %s %s\n Gross wages: $%.2f\n No taxes withheld.", firstName, lastName, grossPay );
                    break;
               
                case quit:
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Unknown pay type. please retry." );
            }       
       count++;
       
        if ( input.hasNextLine()) // resets the input method
        input.nextLine();
       
       }              
 }

    static payType getPay (String input)
    {
       if (input.equalsIgnoreCase("salary"))
           return payType.salary ;
       
       if (input.equalsIgnoreCase("hourly"))
           return payType.hourly ;
       
       if (input.equalsIgnoreCase("temporary"))
           return payType.temporary ;
    
       else
           return payType.quit ;
    }
    
}
