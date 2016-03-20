import java.util.Comparator;
/**
 * For the collection of Airport data
 * 
 * @author Tibor (example from UC San Diego)
 * @version 0.01
 */
public class Airport implements Comparable<Airport>
{
    // instance variables - replace the example below with your own
    private static int ids = 0;
    private int id;
    private String name;
    private String city;
    private String country;
    private String code3;

    /**
     * Constructor for objects of class Airport
     */
    public Airport()
    {
        this.id = ids++;
        this.name = "Name"+this.id;
        this.city = "City"+this.id;
        this.country = "Country"+this.id;
        if (this.id < 10)
            this.code3 = "CO" + this.id;
        else if (this.id > 9 && this.id < 100)
            this.code3 = "C" + this.id;
        else if (this.id < 1000)
            this.code3 = "" + this.id;
        else
            this.code3 = "INF";
    }

    public Airport(String cit, String cou, String cd3)
    {
        this();
        this.name = cit;
        this.city = cit;
        this.country = cou;
        this.code3 = cd3;
    }
    
    public Airport(int aid, String cit, String cou, String cd3)
    {
        this(cit,cou,cd3);
        this.id = aid;
    }

    public Airport(int aid, String nam, String cit, String cou, String cd3)
    {
        this(aid,cit,cou,cd3);
        this.name = nam;
    }
    
    public int getId() { return this.id; }
    
    public String getName() { return this.name; }
    
    public String getCity() { return this.city; }
    
    public String getCountry() { return this.country; }
    
    public String getCode3() { return this.code3; }
    
    public int compareTo(Airport compair) 
    {
        return this.getCity().compareTo(compair.getCity());
    }
    
    public static Comparator<Airport> AirportCityComparator 
                          = new Comparator<Airport>() {

	    public int compare(Airport airp0, Airport airp1) {
	    	
	      String airpCit0 = airp0.getCity().toUpperCase();
	      String airpCit1 = airp1.getCity().toUpperCase();
	      
	      //ascending order
	      return airpCit0.compareTo(airpCit1);
	      
	      //descending order
	      //return airpCit1.compareTo(airpCit0);
	    }

	};
    
    public String toString()
    {
        return(this.id + "\t\"" + this.name + "\"\t\"" + this.city + "\"\t\"" + this.country 
                + "\"\t\"" + this.code3 + "\"");
    }
    
    /** main in Airport */
    public static void main(String[] argv)
    {
        Airport airp0 = new Airport();
        Airport airp1 = new Airport();
        assert(airp0.getId() == 0);
        System.out.println(airp0);
        assert(airp1.getId() == 1);
        System.out.println(airp1);
        assert(new String(airp0.getCity()).equals("City0"));
        assert(new String(airp0.getCountry()).equals("Country0"));
        assert(new String(airp0.getCode3()).equals("CO0"));
        airp1 = new Airport("London","United Kingdom","LON");
        System.out.println(airp1);
        assert(new String(airp1.getCity()).equals("London"));
        assert(new String(airp1.getCountry()).equals("United Kingdom"));
        assert(new String(airp1.getCode3()).equals("LON"));
        airp1 = new Airport(101,"London","United Kingdom","LON");
        System.out.println(airp1);
        assert(airp1.getId() == 101);
        airp1 = new Airport(101,"Heathrow","London","United Kingdom","LHR");
        System.out.println(airp1);
        assert(new String(airp1.getName()).equals("Heathrow"));
        assert(airp0.compareTo(airp1) < 0);
        assert(airp1.compareTo(airp0) > 0);
        airp0 = new Airport(174,"London","London","Canada","YXU");
        assert(airp0.compareTo(airp1) == 0);
        assert(airp1.compareTo(airp0) == 0);
    }
}
