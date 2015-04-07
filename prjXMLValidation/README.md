#Project: XML Validation
##Summary
This project will demonstrate that you know to do the following:
* Create a well-formed XML document with elements and attributes.
* Utilize attributes within XML elements
* Describe the concept of an XML parser.
* Create a Document Type Definition (DTD) to validate the XML document.
* Incorporate elements, attributes, and cardinal notations as part of the DTD
* Create an XML Schema to validate the XML document.
* Demonstrate <sequence>, <choice>, <all> in the XML Schema
* Create a RELAX-NG schema to validate the XML document.
* Make a chart to show the differences between DTD, XML Schema, and RELAX-NG to include: Datatypes, Cardinality, Pros, Cons

## Specifications
1. Create an XML file representing a collection of items. This file will include:
  	* Correct XML declaration with Unicode encoding for UTF-8.
    * At least three layers of elements (sub=elements inside of other elements). Design the document so one or two elements will only be included once while others will be used multiple times. For example, a book with multiple chapters or a house with multiple family members.
    * At least three attributes
    
    The file must be well-formed following the four XML rules for elements.
    
    
2. Create a DTD file and use it to validate collection.xml. This file should validate for the following:
    * All the elements
    * Each of the attributes
    * Cardinality
      * One element or attribute should only be allowed to be included in the XML document once or not at all.
      * One element or attribute must be used in the document one or more times.
      * One element or attribute must be used in the document zero or more times.
      
    As you develop the DTD you may have to modify the design of your original XML document so it meets the requirements of the DTD.
    
3. Create an XML Schema file and use it to validate collection.xml. This file must be a valid XML file as well as utilize at least one valid schema namespace. This file should demonstrate use of the following elements and attributes:
    * &lt;complexType&gt;
    * &lt;group&gt;
    * &lt;sequence&gt;
    * &lt;attribute&gt;
    * minOccurs=" "
    * maxOccurs=" "
    * type=" "
   
   Note: You can use a tool such as Visual Studio to create the Schema from the XML document. You may have to modify the design of your original XML document to meet these requirements. (Don't forget to check the revised XML document against the DTD to make sure it validates using that schema as well.)
   
4. Create a RELAX-NG file and use it to validate collection.xml. This file should validate for the following:

    * All the elements
    * Each of the attributes
5. Create a web page

   Write a short executive summary describing in plain english what XML is and why it is useful in the business environment. Format this summary using CSS so it stands out on the page and is easy to
read. For example, change the background, add a border, and indent both sides. In a sentence or two, explain what an XML parser does. (This is not part of the executive summary and can include technical language.) Give a real-life example of an XML parser.

   Include a table comparing the three validation methods that you've learned. The information should be written in your own words.
Compare the following for all three schemas:

    * Datatypes
    * Cardinality
    * Pros
    * Cons

