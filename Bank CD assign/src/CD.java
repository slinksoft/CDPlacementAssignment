
public class CD
{
    private int principal, maturity, compoundingValue; // values needed for CDS to calculate interest data
    private double interestRate, totalInterestEarned; // for storing interest data
    
    /**
     * default constructor. When CD object is created, the CD will set its needed values
     * @param principall principal provided by the user
     * @param maturityy  maturity provided by the user
     * @param compoundingValuee compounding value provided by the user
     * @param interestRatee  interest rate provided by the user
     */
    public CD(int principall, int maturityy, int compoundingValuee, double interestRatee){
        principal = principall;
        maturity = maturityy;
        compoundingValue = compoundingValuee;
        interestRate = interestRatee;
    }
    /**
        @return returns principal value
    */
    public int getPrincipal(){
    return principal;
    }
    /**
        @return returns maturity value
    */
    public int getMaturity(){
        return maturity;
    }
    /**
     * @return returns compounding value
     */
    public int getCompoundingValue(){
        return compoundingValue;
    }
    /**
     * 
     * @return returns interest rate 
     */
    public double getInterestRate(){
        return interestRate;
    }
    /**
     * @return returns total interest earned year to date 
     */
    public double getTotalInterestEarned(){
        return totalInterestEarned;
    }
    /**
     * adds interest for the year to the total interest YTD variable
     * @param addInterest interest to add to totalInterestEarned variable
     */
    public void addTotalInterestEarned(double addInterest){
        totalInterestEarned += addInterest;
    }
    /**
     * 
     * @param elapsed time in years
     * @return returns calculated accumlated value
     */
    public double calculateAccumulatedValue(int t){
        double accumalatedValue = principal*Math.pow(1+(interestRate/compoundingValue),compoundingValue*t);
        addTotalInterestEarned(accumalatedValue - principal);
        return accumalatedValue;
    }
}