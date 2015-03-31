/* TrainReader3.java - parse through the train.xml file 
 *                     use startElement event
   Peter Johnson - peter.johnson@southcentral.edu
   Ref: SAX Project Quickstart http://www.saxproject.org/quickstart.html
   Revised: 02/24/13 PKJ Added new imports and updated code. */
package src;
import java.io.FileReader;
import org.xml.sax.Attributes;  /* used in startElement( ) */

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.InputSource;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;


public class TrainReader3 extends DefaultHandler
{
   // Keep track of the totals for the entire train
   private int totalWeight = 0;
   private int totalOccupant = 0;
   private int totalLength = 0;
   private int totalCar = 0;
   // Keep track of which node is being handled
   // When a node is active it will be set to true
   private boolean isOccupant = false;
   private boolean isWeight = false;
   private boolean isLength = false;
   // Set up a StringBuffer to hold the chunks of data
   // that SAX will be returning with the character event
   // This will be reused by all the different nodes
   private StringBuffer scratchPad;

	   /******** main( )  **************/
   public static void main(String[ ] args) throws Exception
   {
      System.out.println("Running TrainReader3");
      // create a new XML Reader object
      XMLReader readerObj = XMLReaderFactory.createXMLReader();
      // run the constructor so the DefaultHandler parent can do its thing
      TrainReader3 handler = new TrainReader3( );
      // Set up the Content Handler to catch triggered events
      readerObj.setContentHandler(handler);
      
      // set up a stream (Reader) to connect with the actual XML document
      FileReader myFile = new FileReader("train.xml");
      // start the parsing process using the XML file
      readerObj.parse(new InputSource(myFile)); 
   } // end of main( )

   /******** startDocument( )  **************/
   public void startDocument( ) 
   {
      System.out.println("Start of the train");
   }

   /******** endDocument( )  **************/
   public void endDocument( )
   {
      System.out.println("End of the train");
      System.out.println("**********************");
      System.out.println("For all "    + totalCar + " cars there are: ");
      System.out.println(totalWeight   + " tons in weight.");
      System.out.println(totalLength   + " feet long.");
      System.out.println(totalOccupant + " occupants on the train.");
      System.out.println("**********************");
   }
   
   /******** startElement( )  **************/
   public void startElement(String uri, String localName, String qName, Attributes atts ) throws SAXException
   {
      // set up a new StringBuffer
      scratchPad = new StringBuffer( );
      //System.out.println("DEBUG: qName = " + qName);
      
      /* Check to see what type of XML node this is
       * If there is a match set that flag to true
       * Otherwise turn that flag off (false) because a different type of car
       * will be active.
       */
      if (qName.equals("car"))
      {
         // increment the car counter
         totalCar++;
         if(atts != null)
            System.out.println("Car: " + atts.getValue("type"));
      }

      // set a flag if this is the occupants node
      if(qName.equals("occupants"))
      {
         isOccupant = true;
         //System.out.println("In the occupants node");
      }
      else
         isOccupant = false;

      // set a flag if this is the weight node
      if(qName.equals("weight"))
      {
         isWeight = true;
      }
      else
         isWeight = false;

      // set a flag if this is the length node
      if(qName.equals("length"))
      {
         isLength = true;
      }
      else
         isLength = false;
   } // end of startElement( )


   /******** characters( )  **************/
   /*Store information in the database
    *array of characters
    *int start
    *int length
    *
    */
   public void characters(char[ ] ch, int start, int len ) throws SAXException
   {
      // get information from the field using a StringBuffer object
      // scratchPad to hold all the information because the SAX parser may
      // give it out in chunks
      if(isOccupant || isWeight || isLength)
      {
         scratchPad.append(ch, start, len);
      }
   }// end of characters( )


   /******** endElement( )  **************/
   public void endElement(String uri, String localName, String qName) throws SAXException
   {
      // Update the occupant total
      if(isOccupant)
      {
         //System.out.println("Occupant from scratchPad=" + scratchPad.toString( ));
         totalOccupant += Integer.parseInt(scratchPad.toString(),10);
         isOccupant = false;
      }

      // Update the weight total
      if(isWeight)
      {
         String strWeight = scratchPad.toString( );
         // find out where the first space is
         int firstSpace = strWeight.indexOf(" ");
         strWeight = strWeight.substring(0,firstSpace);
         totalWeight += Integer.parseInt(strWeight,10);
         isWeight = false;
      }

      // Update the length total
      if(isLength)
      {
         String strLength = scratchPad.toString( );
         // strip off descriptor
         // find out where the first space is
         int firstSpace = strLength.indexOf(" ");
         strLength = strLength.substring(0,firstSpace);
         totalLength += Integer.parseInt(strLength,10);
         isLength = false;
      }
   }// end of endElement( )
} // end of class TrainReader3
