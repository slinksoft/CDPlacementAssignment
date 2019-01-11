import java.util.Scanner;
public class testClass
{
    Scanner input = new Scanner(System.in);
    CDList list = new CDList();
    boolean finishAdding;
    public static void main (String[] args){
       new testClass();
    }
    
    public testClass()
    {
        addCDDataUserInput();
    }
    
    private void addCDDataUserInput()
    {
        while (finishAdding == false)
        {
        System.out.print("Enter Principal: ");
        int principal = input.nextInt();
        System.out.print("Enter Maturity: ");
        int maturity = input.nextInt();
        System.out.print("1. Monthly(12)\n2.Quarterly(4)\n3.Daily(365)\nEnter compounding value (1-3): ");
        int maturityChoice = input.nextInt();
        int compoundValue;
        switch (maturityChoice)
        {
            case 1:{
                compoundValue = 12;
                break;
            }
            case 2:{
                compoundValue = 4;
                break;
            }
            case 3:{
                compoundValue = 365;
                break;
            }
            default:{
                compoundValue = 12;
            }
        }
        System.out.print("Enter Interest Rate %: ");
        double interestRate = input.nextDouble()*0.01;
        list.addCD(principal, maturity, compoundValue, interestRate);
        System.out.print("CD Successfully added.\nWould you like to add another CD? (Y/N): ");
        String choice = input.next();
        String formatChoice = choice.toUpperCase();
           if (formatChoice.equals("N"))
              finishAdding = true;
        }
       printReport();
    }
    
    private void printReport()
    {
        list.calculateAndPrintReport();
    }
}