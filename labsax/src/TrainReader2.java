/* TrainReader2.java - parse through the train.xml file 
 *                     use startElement event
   Peter Johnson - peter.johnson@southcentral.edu
   Ref: SAX Project Quickstart http://www.saxproject.org/quickstart.html
   Revised: 02/23/13 PKJ Added new imports and updated code. */
package src;
import java.io.FileReader;
import org.xml.sax.Attributes;  /* used in startElement( ) */

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.InputSource;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;


public class TrainReader2 extends DefaultHandler
{
   /******** main( )  **************/
   public static void main(String[ ] args) throws Exception
   {
      System.out.println("Running TrainReader2");
      // create a new object
      XMLReader readerObj = XMLReaderFactory.createXMLReader();
      TrainReader2 handler = new TrainReader2( );
      readerObj.setContentHandler(handler);
      //readerObj.setErrorHandler(handler);
      
      // read in the file - starts the SAX events
      FileReader myFile = new FileReader("train.xml");
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
   }
   
   /******** startElement( )  **************/
   public void startElement(String uri, String localName, String qName, Attributes atts ) throws SAXException
   {
      //System.out.println("DEBUG: qName = " + qName);
      if (qName.equals("car"))
      {
         if(atts != null)
         {
            System.out.println("   Car: " + atts.getValue("type"));
         }
      }
   }// end of startElement( )

   
   // Constructor calls parent class: DefaultHandler
   public TrainReader2( )
   {
	   super( );
   }   

} // end of class TrainReader2
