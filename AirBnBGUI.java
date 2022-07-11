
public class AirBnBBooking
{
   //Instance variables
   private int bookingNumber;
   private String date;
   private int numberOfNights; 
   private String address; 
   private int numberOfGuests; 
   private double costPerNight;
   private String propertyType; 
   private boolean petsAllowed;
   private static int nextBookingNumber = 100; 
     
   //Constructors
   public AirBnBBooking(String dateIn, int nights, String add, int noGuests, double cost) throws IllegalArgumentException
   {
      bookingNumber = nextBookingNumber++;
      date = dateIn;
      if(cost <= 0)
      {
         throw new IllegalArgumentException("Cost per night must be greater than 0");
      }
      else
      {
         costPerNight = calcCostPerNight(dateIn, cost); //Call method calcCostPerNight which will check date and return cost
      }
      if(nights < 1)
      {
         throw new IllegalArgumentException("Number of nights must be at least 1");
      }
      else
      {
         numberOfNights = nights;
      }
      address = add;
      if(noGuests < 1)
      {
         throw new IllegalArgumentException("Number of guests must be at least 1");
      }
      else if(noGuests > 20)
      {
         throw new IllegalArgumentException("Maximum number of guests is 20");
      }
      else
      {
         numberOfGuests = noGuests;
      }
      propertyType = "Apartment";
      petsAllowed = false;
   }  
   
   /*public AirBnBBooking(String dateIn, int nights, String add, int noGuests, String type, boolean pets)
   {
      bookingNumber = nextBookingNumber++;
      date = dateIn;
      costPerNight = calcCostPerNight();         
      if(noGuests > 20)
      {
         numberOfGuests = 20;  //Set maximum to 20
      }
      else
      {
         numberOfGuests = noGuests;
      }
      propertyType = type;
      petsAllowed = pets;
   }  */
   
   //Mutator Methods
   //Set Date
   public void setDate(String dateIn)
   {
      date = dateIn;
   }
   //Set Address
   public void setAddress(String add)
   {
      address = add; 
   }
   //Set number of nights
   public void setNights(int nights) throws IllegalArgumentException
   {
      if(nights > 0)
      {
         numberOfNights = nights;
      }
      else
      {
         throw new IllegalArgumentException("Number of nights must be greater\nthan 0");
      }
   }
   //Set  number of guests
   public void setGuests(int guests) throws IllegalArgumentException
   {
      if(guests < 1)
      {
         throw new IllegalArgumentException("Number of guests must be greater than 0");
      }
      else if(guests > 20)
      {
         throw new IllegalArgumentException("Maximum number of guests is 20");
      }
      else
      {
         numberOfGuests = guests;
      }
   }
   //Set cost per night
   public void setCostPerNight(double cost) throws IllegalArgumentException
   {
        if(cost <= 0)
        {
           throw new IllegalArgumentException("Cost must be greater than 0");
        }
        else
        {
           costPerNight = calcCostPerNight(date, cost);
        }
   
   }
   //Set Property type
   public void setPropertyType(String type) 
   {
      propertyType = type; 
   }
   //Set pets allowed
   public void setPetsAllowed(boolean allowPets) 
   {
      petsAllowed = allowPets; 
   }
   /**** Accessor Methods ****/
   //Get Booking number
   public int getBookingNumber()
   {
      return bookingNumber;
   }
   //Get date
   public String getDate()
   {
      return date;
   }
   //Get number of nights
   public int getNights() 
   {
      return numberOfNights; 
   }
   //Get address
   public String getAddress() 
   {
      return address; 
   }

   //Get number of guests
   public int getNoGuests() 
   {
      return numberOfGuests; 
   }
   //Get cost per night
   public double getCostPerNight() 
   {
      return costPerNight; 
   }
   //Get property type
   public String getPropertyType() 
   {
      return propertyType; 
   }
   //Get pets allowed
   public boolean petsAllowed()
   {
      if(petsAllowed)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
   //Calculate total booking price
   public double totalBookingPrice()
   {
      return costPerNight * numberOfNights;
   }
   
   //Calculate price per guest
   
   public double pricePerGuest() // return cost per guest
   {
      return costPerNight * numberOfNights / numberOfGuests;
      //Could also call method totalBookingPrice as code is same
      //return totalBookingPrice() / numberOfGuests; 
   }
   //Return all booking details
   public String toString() 
   {
      return "***** BOOKING DETAILS *****\n" +
            "Booking No: "+bookingNumber+
            "\nAddress: " + address +
            "\nDate: " + date+
            "\nNumber of Nights: "+numberOfNights+
            "\nCost Per Night: " + costPerNight +
            "\nGuests: "+numberOfGuests+
            "\nProperty Type: " + propertyType +
            "\nPets Allowed: " + petsAllowed + "\n";
   }
   //Check date to calculate costPerNight
   public double calcCostPerNight(String dateIn, double costIn)
   {
      double cost;
      if(dateIn.toLowerCase().contains("june")||dateIn.toLowerCase().contains("july")||dateIn.toLowerCase().contains("august"))
      {
         cost = costIn + 15; 
      }
      else if(dateIn.toLowerCase().contains("december"))
      {
         cost = costIn + 10;
      }
      else
      {
         cost = costIn;
      }
      return cost;
   }

   //This reverses the price adjustment for certain months, so that when the user edits their booking information, the price is not 
   //doubly inflated when they submit their edits
   public double calcCostPerNightReverse()
   {
      double cost;
      if(this.date.toLowerCase().contains("june")||this.date.toLowerCase().contains("july")||this.date.toLowerCase().contains("august"))
      {
         costPerNight = costPerNight - 15; 
      }
      else if(this.date.toLowerCase().contains("december"))
      {
         costPerNight = costPerNight - 10; 
      }
      else
      {
         costPerNight = costPerNight; 
      }
      return costPerNight;
   }

}
