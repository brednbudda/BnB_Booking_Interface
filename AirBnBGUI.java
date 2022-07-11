
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.event.ActionEvent;
import java.util.ArrayList;

public class AirBnBGUI extends Application
{
   ArrayList<AirBnBBooking> bookingList = new ArrayList<>();

   //Controls for main scene
   TextField txtDate;
   TextField txtAddress; 
   TextField txtBookingNum;
   TextField txtNumGuests;
   TextField txtNumNights;
   TextField txtCostPerNight; 
   Button btnAddBooking;
   Button btnViewAllBookings;
   Button btnEditBooking;
   Button btnCancelBooking;
   Button btnSearchAddress;
   Button btnCalcBookingCost;
   TextArea txtOutput;

   //For Cancel Booking Scene
   TextField txtBookingNumCancel;
   Button btnSearchBooking;
   Button btnClearCancelSearch;
   Button btnConfirmCancel; 
   Button btnReturnToMain;
   TextArea txtCancelOutput;

   //for Edit Booking scene
   TextField txtBookingNumEdit;
   TextField txtDateEdit;
   TextField txtAddressEdit; 
   TextField txtNumGuestsEdit;
   TextField txtNumNightsEdit;
   TextField txtCostPerNightEdit; 
   TextField txtPropertyTypeEdit;
   TextField txtPetsAllowedEdit;
   Button btnSearchBookingEdit;
   Button btnUpdateBooking;
   Button btnClearUpdate;
   Button btnReturnEdit;
   TextArea txtEditOutput;


   public void start(Stage stage)
   {
      //Labels for main scene
      Label lblwelcomeTitle = new Label("**********AirBnB Booking**********");
      Label lblDate = new Label("Date");
      Label lblAddress = new Label("Address");
      Label lblBookingNum = new Label("Search Booking Number");
      Label lblNumGuests = new Label("No of Guests");
      Label lblNumNights = new Label("No of Nights");
      Label lblCostPerNight = new Label("Cost per Night");
      Label lblDivider = new Label("**********************************");
      
      //TextFields for main scene
      txtDate = new TextField();
      txtDate.setMaxWidth(100);
      txtAddress = new TextField(); 
      txtAddress.setMaxWidth(150);
      txtBookingNum = new TextField();
      txtBookingNum.setMaxWidth(50);
      txtNumGuests = new TextField();
      txtNumGuests.setMaxWidth(80);
      txtNumNights = new TextField();
      txtNumNights.setMaxWidth(80);
      txtCostPerNight = new TextField();
      txtCostPerNight.setMaxWidth(80);

      //Buttons for main scene
      btnAddBooking = new Button("Add Booking");
      btnAddBooking.setOnAction(e -> addBooking(e));
      btnViewAllBookings = new Button("View All Bookings");
      btnViewAllBookings.setOnAction(e -> viewBookings(e));
      btnEditBooking = new Button("Edit Booking");
      btnCancelBooking = new Button("Cancel Booking");
      btnSearchAddress = new Button("Search by Address");
      btnSearchAddress.setOnAction(e -> searchAddress(e));
      btnCalcBookingCost = new Button("Calculate Booking Cost");
      btnCalcBookingCost.setOnAction(e -> calcBookingCost(e));

      //TextArea for main scene
      txtOutput = new TextArea();
      txtOutput.setMaxSize(600,300); 
      txtOutput.setText("Please enter your booking information in\nthe above fields");
      txtOutput.setEditable(false);

      //Layout boxes for main scene
      HBox titleBox = new HBox();
      titleBox.getChildren().add(lblwelcomeTitle);
      titleBox.setAlignment(Pos.CENTER);
      HBox inputBox = new HBox(10);
      inputBox.getChildren().addAll(lblDate,txtDate,lblAddress,txtAddress);
      inputBox.setAlignment(Pos.CENTER);
      HBox inputBox2 = new HBox(10);
      inputBox2.getChildren().addAll(lblNumGuests,txtNumGuests,lblNumNights,txtNumNights,lblCostPerNight,txtCostPerNight);
      inputBox2.setAlignment(Pos.CENTER);
      HBox dividerBox = new HBox();
      dividerBox.getChildren().add(lblDivider);
      dividerBox.setAlignment(Pos.CENTER);
      HBox btnBox1 = new HBox(10);
      btnBox1.getChildren().addAll(btnAddBooking,btnViewAllBookings,btnSearchAddress);
      btnBox1.setAlignment(Pos.CENTER);
      HBox dividerBox2 = new HBox();
      dividerBox2.getChildren().add(lblDivider);
      dividerBox2.setAlignment(Pos.CENTER);
      HBox navigateBox = new HBox(10);
      navigateBox.getChildren().addAll(btnEditBooking,btnCancelBooking);
      navigateBox.setAlignment(Pos.CENTER);
      HBox btnBox2 = new HBox(10);
      btnBox2.getChildren().addAll(lblBookingNum,txtBookingNum,btnCalcBookingCost);
      btnBox2.setAlignment(Pos.CENTER);
      HBox outputBox = new HBox();
      outputBox.getChildren().add(txtOutput);
      outputBox.setAlignment(Pos.CENTER);

      //root layout for main scene
      VBox root = new VBox(10);
      root.getChildren().addAll(titleBox,inputBox,inputBox2,dividerBox,btnBox1,navigateBox,dividerBox2,btnBox2,outputBox);
      root.setAlignment(Pos.CENTER);

      //setting main scene
      Scene scene = new Scene(root, 1000,500);
      stage.setScene(scene);
      stage.setTitle("AirBnb Bookings");
      stage.show();

      //CONTROLS FOR CANCEL BOOKING SCENE
      //Label for cancel booking scene
      Label lblBookingNumCancel = new Label("Enter Booking Number");

      //TextFields for cancel booking scene
      txtBookingNumCancel = new TextField();
      txtBookingNumCancel.setMaxWidth(50);

      //Buttons for cancel booking scene
      btnSearchBooking = new Button("Search Booking Number");
      btnSearchBooking.setOnAction(e -> searchBookingNum(e));
      btnClearCancelSearch = new Button("Clear Previous Search");
      btnClearCancelSearch.setOnAction(e -> cancelSceneReset());
      btnConfirmCancel = new Button("Delete Booking");
      btnConfirmCancel.setOnAction(e -> confirmCancel(e));
      btnReturnToMain = new Button("Return to Main Window");

      //TextArea for cancel booking scene
      txtCancelOutput = new TextArea();
      txtCancelOutput.setMaxSize(300,300);
      txtCancelOutput.setEditable(false);

      //Layout boxes for cancel booking scene
      HBox cancelInput = new HBox(8);
      cancelInput.getChildren().addAll(lblBookingNumCancel,txtBookingNumCancel,btnSearchBooking);
      cancelInput.setAlignment(Pos.CENTER);
      HBox cancelBtnBox = new HBox(8);
      cancelBtnBox.getChildren().addAll(btnClearCancelSearch,btnConfirmCancel);
      cancelBtnBox.setAlignment(Pos.CENTER);
      HBox cancelOutputBox = new HBox(8);
      cancelOutputBox.getChildren().add(txtCancelOutput);
      cancelOutputBox.setAlignment(Pos.CENTER);
      HBox cancelCloseBox = new HBox();
      cancelCloseBox.getChildren().add(btnReturnToMain);
      cancelCloseBox.setAlignment(Pos.CENTER);

      //Root layout box for cancel booking scene
      VBox cancelRoot= new VBox(10); 
      cancelRoot.getChildren().addAll(cancelInput,cancelBtnBox,cancelOutputBox,cancelCloseBox);
      cancelRoot.setAlignment(Pos.CENTER);
      //cancel booking scene
      Scene cancelScene = new Scene(cancelRoot, 1000,500);

      //CONTROLS FOR EDIT BOOKING SCENE
      //Labels for Edit Scene
      Label lblEditTitle = new Label("********** Edit Booking **********");
      Label lblEnterBookingEdit = new Label("Enter Booking Number");
      Label lblDateEdit = new Label("Date");
      Label lblAddressEdit = new Label("Address");
      Label lblNumGuestsEdit = new Label("No of Guests");
      Label lblNumNightsEdit = new Label("No of Nights");
      Label lblCostPerNightEdit = new Label("Cost per Night");
      Label lblPropertyTypeEdit= new Label("Property Type");
      Label lblPetsAllowedEdit = new Label("Pets Allowed");

      //TextFields for Edit scene
      txtBookingNumEdit = new TextField();
      txtBookingNumEdit.setMaxWidth(50);
      txtDateEdit = new TextField();
      txtDateEdit.setMaxWidth(100); 
      txtAddressEdit = new TextField(); 
      txtAddressEdit.setMaxWidth(150); 
      txtNumGuestsEdit = new TextField();
      txtNumGuestsEdit.setMaxWidth(80); 
      txtNumNightsEdit = new TextField();
      txtNumNightsEdit.setMaxWidth(80); 
      txtCostPerNightEdit = new TextField();
      txtCostPerNightEdit.setMaxWidth(80);
      txtPropertyTypeEdit = new TextField();
      txtPropertyTypeEdit.setMaxWidth(150); 
      txtPetsAllowedEdit = new TextField();
      txtPetsAllowedEdit.setMaxWidth(100); 

      //Buttons for Edit Scene
      btnSearchBookingEdit = new Button("Search for Booking");
      btnSearchBookingEdit.setOnAction(e -> searchBookingEdit(e));
      btnUpdateBooking = new Button("Update");
      btnUpdateBooking.setOnAction(e -> updateBooking(e));
      btnClearUpdate = new Button("Clear Search");
      btnClearUpdate.setOnAction(e -> 
      {
         txtEditOutput.clear();
         editScreenReset();
      });
      btnReturnEdit = new Button("Return To Main Screen"); 

      //TextArea output for Edit scene
      txtEditOutput = new TextArea();
      txtEditOutput.setMaxSize(300,100);
      txtEditOutput.setEditable(false);

      //Set up layout boxes for Edit scene
      HBox hboxEditTitle = new HBox(10);
      hboxEditTitle.getChildren().add(lblEditTitle); 
      hboxEditTitle.setAlignment(Pos.CENTER); 
      HBox hboxBookingSearch = new HBox(10);
      hboxBookingSearch.getChildren().addAll(lblEnterBookingEdit,txtBookingNumEdit,btnSearchBookingEdit);
      hboxBookingSearch.setAlignment(Pos.CENTER);
      HBox hboxEditInput1 = new HBox(10);
      hboxEditInput1.getChildren().addAll(lblDateEdit,txtDateEdit,lblAddressEdit,txtAddressEdit,lblNumGuestsEdit,txtNumGuestsEdit,lblNumNightsEdit,txtNumNightsEdit);
      hboxEditInput1.setAlignment(Pos.CENTER);
      HBox hboxEditInput2 = new HBox(10);
      hboxEditInput2.getChildren().addAll(lblCostPerNightEdit,txtCostPerNightEdit,lblPropertyTypeEdit,txtPropertyTypeEdit,lblPetsAllowedEdit,txtPetsAllowedEdit);
      hboxEditInput2.setAlignment(Pos.CENTER);
      HBox hboxEditBtns = new HBox(10);
      hboxEditBtns.getChildren().addAll(btnUpdateBooking,btnClearUpdate);
      hboxEditBtns.setAlignment(Pos.CENTER);
      HBox hboxEditOutput = new HBox(10);
      hboxEditOutput.getChildren().add(txtEditOutput);
      hboxEditOutput.setAlignment(Pos.CENTER);
      HBox hboxEditReturn = new HBox(10);
      hboxEditReturn.getChildren().add(btnReturnEdit);
      hboxEditReturn.setAlignment(Pos.CENTER);


      VBox editRoot = new VBox(10);
      editRoot.getChildren().addAll(hboxEditTitle,hboxBookingSearch,hboxEditInput1,hboxEditInput2,hboxEditBtns,hboxEditOutput,hboxEditReturn);
      editRoot.setAlignment(Pos.CENTER);

      Scene editScene = new Scene(editRoot,1000,500);

      //Button actions to navigate between scenes
      btnCancelBooking.setOnAction(e -> 
      {
         stage.setScene(cancelScene);
         cancelSceneReset();
      });
      btnReturnToMain.setOnAction(e -> 
      {
         stage.setScene(scene);
         txtOutput.clear();
         mainScreenReset();
      });
      btnEditBooking.setOnAction(e -> 
      {
         stage.setScene(editScene);
         txtEditOutput.clear();
         editScreenReset();
      });
      btnReturnEdit.setOnAction(e -> 
      {
         stage.setScene(scene);
         txtOutput.clear();
         mainScreenReset(); 
      });
      

   }//end start Stage Method

   /* Method to use constructor and take input from textfields in main scene to create a
   booking object. Includes error checking for proper data type input within try/catch 
   statement. Checking for data limits (i.e. negative numbers, limit of 20 guests) taken
   care of within AirBnBBooking class methods.
   */

   //This method resets the main scene text fields and areas, and prompts user for input
   public void mainScreenReset()
   {
      txtOutput.appendText("Enter in your booking information in the above text fields.\n\nOr search for the price of a booking in the system.");
      txtDate.clear();
      txtAddress.clear();
      txtNumGuests.clear();
      txtNumNights.clear();
      txtCostPerNight.clear();

   }

   //Method to create a new Booking object and add it to the bookingList array
   public void addBooking(ActionEvent e)
   {
      String dateIn;
      int nights;
      String address;
      int numGuests;
      double costPerNight;

      txtOutput.clear();

      try 
      {
         if(txtDate.getText().isEmpty() || txtAddress.getText().isEmpty() || txtNumGuests.getText().isEmpty() || txtNumNights.getText().isEmpty() || txtCostPerNight.getText().isEmpty())
         {
            txtOutput.setText("Please enter values into all fields");
         }
         else
         {
            //assign variables from TextField input
            dateIn = txtDate.getText();
            nights = Integer.parseInt(txtNumNights.getText());
            address = txtAddress.getText();
            numGuests = Integer.parseInt(txtNumGuests.getText());
            costPerNight = Double.parseDouble(txtCostPerNight.getText());

            //call constructor of AirBnBBooking class and add to ArrayList
            bookingList.add(new AirBnBBooking(dateIn,nights,address,numGuests,costPerNight));
            txtOutput.clear();
            txtOutput.setText("Booking successfully created\n\n");
            mainScreenReset();
         }
      }//close try
      catch(NumberFormatException ex)
      {
         txtOutput.setText("Please enter correct values in text fields.");
      }
      catch(IllegalArgumentException ex)
      {
         txtOutput.setText(ex + "");
      }


   }

   //Prints out all of the bookings in the system to the output window
   public void viewBookings(ActionEvent event)
   {
      txtOutput.clear();
      if(bookingList.isEmpty())
      {
         txtOutput.setText("There are no bookings in the system");
      }
      else
      {
         for(AirBnBBooking b:bookingList)
         {
            txtOutput.appendText(b + " \n");
         }
      }
   }

   //Searches for bookings based on an address. 
   public void searchAddress(ActionEvent event)
   {
      txtOutput.clear();

      if(txtAddress.getText().isEmpty())
      {
         txtOutput.setText("Please enter an address in the 'Address' field");
      }
      else if(bookingList.isEmpty())
      {
         txtOutput.setText("There are no bookings in the system.");
      }
      else
      {
         String search = txtAddress.getText();
         boolean addressFound = false;
         for(int i=0; i<bookingList.size();i++)
         {
            if(bookingList.get(i).getAddress().equalsIgnoreCase(search))
            {
               txtOutput.appendText(bookingList.get(i) + "\n");
               addressFound = true;
            }
         }
         if(!addressFound)
         {
            txtOutput.setText("No bookings found for that address.");
         }
      }
   }

   //This method allows the user to view the price breakdown for a booking based on the booking number
   public void calcBookingCost(ActionEvent event)
   {
      txtOutput.clear();

      if(txtBookingNum.getText().isEmpty())
      {
         txtOutput.setText("Please Enter a Booking Number");
      }
      else if(bookingList.isEmpty())
      {
         txtOutput.setText("There are no bookings in the system.");
      }
      else
      {
         try 
         {
            boolean bookingFound = false;
            int bookingSearch = Integer.parseInt(txtBookingNum.getText());
            for(int i = 0; i < bookingList.size(); i++)
            {
               if(bookingSearch == bookingList.get(i).getBookingNumber())
               {
                  txtOutput.setText("The price of booking " + bookingList.get(i).getBookingNumber() + " is as follows: " +
                                    "\nCost Per Night: " + bookingList.get(i).getCostPerNight() +
                                    "\nTotal Price: " + bookingList.get(i).totalBookingPrice() +
                                    "\nPrice Per Guest: " + bookingList.get(i).pricePerGuest());
                  bookingFound = true;
               }
            }//close for loop
            if(!bookingFound)
            {
               txtOutput.setText("No Booking Found");
            }
         }
         catch(NumberFormatException ex)
         {
            txtOutput.setText("Please Enter a Valid Number in the Text Field.");
         }
      }
   }

   /*
   ***********METHODS FOR CANCEL BOOKING SCENE****************
   */

   //This method resets the text areas and fields for the Cancel scene
   public void cancelSceneReset()
   {
      txtCancelOutput.clear();
      txtBookingNumCancel.clear();
      txtBookingNumCancel.setEditable(true);
      txtCancelOutput.appendText("Please search for a booking number in the field above");
   }

   //This method searches the system for a booking  based on booking number
   //It freezes the input field until the user either deletes the selected booking or clears the search.
   //This prevents the user from deleting unintended bookings
   public void searchBookingNum(ActionEvent event)
   {
      txtCancelOutput.clear();

      if(txtBookingNumCancel.getText().isEmpty())
      {
         txtCancelOutput.setText("Please Enter a Booking Number");
      }
      else
      {
         try 
         {
            boolean bookingFound = false;
            int bookingSearch = Integer.parseInt(txtBookingNumCancel.getText());
            for(int i = 0; i < bookingList.size(); i++)
            {
               if(bookingSearch == bookingList.get(i).getBookingNumber())
               {
                  txtCancelOutput.appendText(bookingList.get(i) + "\nPress 'Delete Booking' to delete booking");
                  bookingFound = true;
                  txtBookingNumCancel.setEditable(false);
               }
            }//close for loop
            if(!bookingFound)
            {
               txtCancelOutput.setText("No Booking Found");
            }
         }
         catch(NumberFormatException ex)
         {
            txtCancelOutput.setText("Please Enter a Valid Number in the Text Field.");
         }
      }
   }

   //This method removes a booking object based on booking number from the bookingList array
   public void confirmCancel(ActionEvent event)
   {
      txtCancelOutput.clear();

      if(txtBookingNumCancel.getText().isEmpty())
      {
         txtCancelOutput.setText("Please search for a booking number in the text field.");
      }
      else
      {
         try
         {
            boolean bookingFound = false;
            int bookingSearch = Integer.parseInt(txtBookingNumCancel.getText());
            for(int i = 0; i < bookingList.size(); i++)
            {
               if(bookingSearch == bookingList.get(i).getBookingNumber())
               {
                  bookingList.remove(i);
                  txtBookingNumCancel.clear();
                  txtCancelOutput.appendText("You Have Successfully Deleted the Booking");
                  bookingFound = true;
               }
            }
            if(!bookingFound)
            {
               txtCancelOutput.setText("No Booking Found");
            }
         }
         catch(NumberFormatException ex)
         {
            txtCancelOutput.setText("Please Enter a Valid Number in the Text Field.");
         }
      }
      
   }
   
   /*
   ********METHODS FOR EDIT SCREEN*********
   */

   //This method resets the edit scene text fields and areas
   public void editScreenReset()
   {
      txtEditOutput.appendText("Please search for a booking number in\nthe above text field.");
      txtBookingNumEdit.setEditable(true);
      txtBookingNumEdit.clear();
      txtDateEdit.clear();
      txtAddressEdit.clear(); 
      txtNumGuestsEdit.clear();
      txtNumNightsEdit.clear();
      txtCostPerNightEdit.clear(); 
      txtPropertyTypeEdit.clear();
      txtPetsAllowedEdit.clear();

   }

   //This method searched based on booking number, and fills in the appropriate text fields with the relevant booking data
   //This will also freeze input to the bookingNum textfield until the user clears the search, or updates the search
   //This is to prevent changes from being applied to the incorrect booking number
   public void searchBookingEdit(ActionEvent event)
   {

      if(bookingList.isEmpty())
      {
         txtEditOutput.setText("There Are No Bookings in the System");
      }
      else if(txtBookingNumEdit.getText().isEmpty())
      {
         txtEditOutput.setText("Please Enter a Booking Number");
      }
      else
      {
         try
         {
            int bookingSearch = Integer.parseInt(txtBookingNumEdit.getText());
            boolean bookingFound = false;
            for(int i=0; i < bookingList.size(); i++)
            {
               if(bookingSearch == bookingList.get(i).getBookingNumber())
               {
                  txtDateEdit.setText(bookingList.get(i).getDate());
                  txtAddressEdit.setText(bookingList.get(i).getAddress());
                  txtNumGuestsEdit.setText(Integer.toString(bookingList.get(i).getNoGuests()));
                  txtNumNightsEdit.setText(Integer.toString(bookingList.get(i).getNights()));
                  //The below method readjusts the cost per night during special months, so that the cost is not then adjusted higher again.
                  //This was happening when the user would update their booking during those months, it would add an additional cost onto the price.
                  txtCostPerNightEdit.setText(Double.toString(bookingList.get(i).calcCostPerNightReverse()));
                  txtPropertyTypeEdit.setText(bookingList.get(i).getPropertyType());
                  txtPetsAllowedEdit.setText(Boolean.toString(bookingList.get(i).petsAllowed()));
                  txtEditOutput.setText("Please edit the booking information\nin the above text fields.\nPress Clear to begin a new search.");
                  bookingFound = true;
                  txtBookingNumEdit.setEditable(false);
               }
               if(!bookingFound)
               {
                  txtEditOutput.setText("No booking found under that booking number.");
               }
            }
         }
         catch(NumberFormatException ex)
         {
            txtEditOutput.setText("Please Enter a Valid Number");
         }
      }


   }

   //This method updates any changed information to the booking 
   public void updateBooking(ActionEvent event)
   {
      txtEditOutput.clear();
      if(txtDateEdit.getText().isEmpty() || txtAddressEdit.getText().isEmpty() || txtNumGuestsEdit.getText().isEmpty() || txtNumNightsEdit.getText().isEmpty() || txtCostPerNightEdit.getText().isEmpty() || txtPropertyTypeEdit.getText().isEmpty() || txtPetsAllowedEdit.getText().isEmpty())
      {
         txtEditOutput.setText("Please enter values into all fields");
      }
      else if(bookingList.isEmpty())
      {
         txtEditOutput.setText("There are no bookings in the system");
      }
      //I decided to do error checking this way for petsAllowed, because when parsing a Boolean, anything besides 'true' gets parsed as false.
      else if(!(txtPetsAllowedEdit.getText().equalsIgnoreCase("true") || txtPetsAllowedEdit.getText().equalsIgnoreCase("false")))
      {
           txtEditOutput.setText("Pets allowed must be 'True' or 'False'");
      }
      else
      {
         try
         {
            int bookingSearch = Integer.parseInt(txtBookingNumEdit.getText());
            for(int i=0; i < bookingList.size(); i++)
            {
               if(bookingSearch == bookingList.get(i).getBookingNumber())
               {
                  bookingList.get(i).setDate(txtDateEdit.getText());
                  bookingList.get(i).setAddress(txtAddressEdit.getText());
                  bookingList.get(i).setGuests(Integer.parseInt(txtNumGuestsEdit.getText()));
                  bookingList.get(i).setNights(Integer.parseInt(txtNumNightsEdit.getText()));
                  bookingList.get(i).setCostPerNight(Double.parseDouble(txtCostPerNightEdit.getText()));
                  bookingList.get(i).setPropertyType(txtPropertyTypeEdit.getText());
                  bookingList.get(i).setPetsAllowed(Boolean.parseBoolean(txtPetsAllowedEdit.getText()));
                  txtEditOutput.appendText("Booking successfully updated!\n");
                  this.editScreenReset();
               }
            }
         }
         catch(NumberFormatException ex)
         {
            txtEditOutput.setText("Please enter correct values into text fields.");
         }
         catch(IllegalArgumentException ex)
         {
            txtEditOutput.setText(ex + "");
         }
      }
   }

   public static void main(String[] args) 
   {
      launch(args);
   }//end main method
}//end class
