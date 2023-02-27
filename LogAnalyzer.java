/**
 * Read web server data and analyze hourly access patterns.
 * 
 * @author Salvatore Anzalone
 * @version    2/27/2023
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        
        // Create the reader to obtain the data.
        reader = new LogfileReader("demo.log");
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext())
        {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        
        for(int hour = 0; hour < hourCounts.length; hour++)
        {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    /**
     * Print the busiest hour.
     * This will call analyzeHourlyData to
     * do this.
     */
    public void busiestHour()
    {
        for(int hour = 0; hour < hourCounts.length; hour++)
        {
            if(hour > 3)
            {
                System.out.println("Hr: Count");
            }
        }
    }
    
    /**
     * Print the busiest day.
     * This will call analyzeHourlyData to
     * do this.
     */
    public void busiestDay()
    {
        for(int hour = 0; hour < hourCounts.length; hour++)
        {
            if(hour > 3)
            {
                System.out.println("Day: Count");
            }
        }
    }
    
    /**
     * Print the busiest 2-Hour increments.
     * This will call analyzeHourlyData to
     * do this.
     */
    public void busiestTwoHour()
    {
        for(int hour = 0; hour < hourCounts.length; hour++)
        {
            System.out.println(hour * 2);
            
            if(hour > 6)
            {
                System.out.println("Hr: Count");
            }
        }
    }
    
    /**
     * Print the busiest month.
     * This will call analyzeHourlyData to
     * do this.
     */
    public void busiestMonth()
    {
        for(int hour = 0; hour < hourCounts.length; hour++)
        {
            //Provides the total amount of hours accumulated,
            //regardless if it's through the busiest or quietest hours
            //in a day.
            int hourTotal = hour;
            
            if(hourTotal / 28  >= 100 || hourTotal / 28 <= 100)
            {
                System.out.println("Month: Count");
            }
        }
    }
    
    /**
     * Print the quietest hour.
     * This will call analyzeHourlyData to
     * do this.
     */
    public void quietestHour()
    {
        for(int hour = 0; hour < hourCounts.length; hour++)
        {
            if(hour <= 3)
            {
                System.out.println("Hr: Count");
            }
        }
    }
    
    /**
     * Print the quietest day.
     * This will call analyzeHourlyData to
     * do this.
     */
    public void quietestDay()
    {
        for(int hour = 0; hour < hourCounts.length; hour++)
        {
            if(hour <= 3)
            {
                System.out.println("Day: Count");
            }
        }
    }
    
    /**
     * Print the quietest month.
     * This will call analyzeHourlyData to
     * do this.
     */
    public void quietestMonth()
    {
        for(int hour = 0; hour < hourCounts.length; hour++)
        {
            //Provides the total amount of hours accumulated,
            //regardless if it's through the busiest or quietest hours
            //in a day.
            int hourTotal = hour;
            
            if(hourTotal / 28  >= 50 || hourTotal / 28 <= 50)
            {
                System.out.println("Month: Count");
            }
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
    
    /**
     * Print the times a site was accessed.
     */
    public void numberOfAccesses()
    {
        //The number of accesses
        int access = 0;
        
        for(int hour = 0; hour < hourCounts.length; access++)
        {
            System.out.println("Number of Accesses: " + access);
        }
    }
    
    /**
     * Print the times a site was accessed per month.
     */
    public void totalAccessesPerMonth()
    {
        //Provides the total amount of times the
        //analyzer was accessed.
        int accessTotal = 0;
        
        for(int hour = 0; hour < hourCounts.length; accessTotal++)
        {
            int hourTotal = hour;
            
            //Total accesses per month
            int monthTotal = hourTotal * 28;
            
            System.out.println("Total Number of Accesses per Month: " +
                                monthTotal);
        }
    }
    
    /**
     * Print the average amount of times a
     * site was accessed in a month.
     */
    public void averageAccessesPerMonth()
    {
        //Provides the total amount of times the
        //analyzer was accessed.
        int accessTotal = 0;
        
        //The average of the total
        int accessAverage = accessTotal / 28;
        
        for(int hour = 0; hour < hourCounts.length; accessTotal++)
        {
            System.out.println("Average Number of Accesses: " +
                                accessAverage);
        }
    }
}