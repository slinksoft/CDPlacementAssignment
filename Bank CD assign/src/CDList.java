
import java.text.DecimalFormat;
import java.util.ArrayList;

public class CDList
{
    public ArrayList<CD> theList = new ArrayList<>(); // create ArrayList of CD objects
    private DecimalFormat df = new DecimalFormat("#.00"); // decimal format for monetary values 
    private DecimalFormat dfForInterestRate = new DecimalFormat("#.0000"); // decimal format for interest rate
    private int currentYear; // handles current year for report
    private int numOfAnnualReports; // handles number of annual reports to calculate
    
    /**
      default constructor. Will set current year and number of desired annual reports
     */
    public CDList()
    {
        currentYear = 1;
        numOfAnnualReports = 10;
    }
    
    /**
     * adds new CD to the CD ArrayList
     * @param principal principal provided by user
     * @param maturity maturity provided by user
     * @param compoundingValue compounding value provided by user
     * @param interestRate interest rate provided by user
     */
    public void addCD(int principal, int maturity, int compoundingValue, double interestRate)
    {
        CD newCD = new CD(principal, maturity, compoundingValue, interestRate);
        theList.add(newCD);
    }
    
    /**
     * calculates and formats data and prints all annual reports
     */
    public void calculateAndPrintReport(){
            for (int i = 0; i < numOfAnnualReports; i++)
            {
                 System.out.println("Year " + currentYear + " - Active CDS");
                 System.out.println(" P   |   IR |  M | CV |   "
                         + "AV   |   IFY   |   IYTD");
                for (int j = 0; j < theList.size(); j++)
                {
                    if (currentYear <= theList.get(j).getMaturity())
                    {
                    double accumalatedValue = theList.get(j).calculateAccumulatedValue(currentYear);
                    double interestEarnedYear =  accumalatedValue - theList.get(j).getPrincipal();
                    double interestYTD = theList.get(j).getTotalInterestEarned();
                    System.out.print(theList.get(j).getPrincipal() + "   " + dfForInterestRate.format
        (theList.get(j).getInterestRate()) 
                            + "   " + theList.get(j).getMaturity() + "   " + 
                            theList.get(j).getCompoundingValue() + "   ");
                    System.out.println("$" + df.format(accumalatedValue) + "   $" + 
                            df.format(interestEarnedYear) + "   $" + df.format(interestYTD));
                    
                    }
                }
            currentYear++;
            }
    }
}