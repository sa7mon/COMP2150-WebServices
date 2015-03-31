/* TrainReader.java - parse through the train.xml file 
   Peter Johnson - peter.johnson@southcentral.edu
   Ref: SAX Project Quickstart http://www.saxproject.org/quickstart.html
   Revised: 02/23/13 PKJ Added new imports and updated code. */
import java.io.FileReader;

import org.xml.sax.XMLReader;
import org.xml.sax.InputSource;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;


public class TrainReader extends DefaultHandler
{
   /******** main( )  **************/
   public static void main(String[ ] args) throws Exception
   {
      System.out.println("Running train reader");
      // create a new object
      XMLReader readerObj = XMLReaderFactory.createXMLReader();
      TrainReader handler = new TrainReader( );
      readerObj.setContentHandler(handler);
      //readerObj.setErrorHandler(handler);
      
      // read in the file - starts the SAX events
      FileReader myFile = new FileReader("train.xml");
      readerObj.parse(new InputSource(myFile)); 
   }



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
   
   // Constructor calls parent class: DefaultHandler
   public TrainReader( )
   {
	   super( );
   }   

} // end of class TrainReader
