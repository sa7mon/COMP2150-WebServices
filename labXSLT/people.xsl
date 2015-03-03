<?xml version="1.0"?>
<!-- *** Step #1*** Set up a namespace so parser knows which version of XSLT to use
             Don't forget the stop tag at the bottom of this XML document!!! -->
<xsl:stylesheet xmlns:xsl="http://www.w2.org/1999/XSL/Transform" version="2.0">

<!-- IMPORTANT CONCEPT: elements that are not part of the namespace will be output
     without being modified.
     For example, all of the HTML elements below will simply be sent, 
     unchanged to the output document. -->

<!-- This statement will add in the proper DOCTYPE at the top of the XHMTL file -->
<xsl:output method="xml" media-type="text/html" doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN" doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" indent="yes" encoding="utf-8"/>

<!-- *** Step #2 *** select all of the elements starting from the root 
             Don't forget the stop tag at the bottom of this XML document!!! -->
<xsl:template match="/">

<html>
<body>
<table border="1">
   <tr>
      <th>Name</th>
      <th>Address</th>
      <th>Tel</th>
      <th>Fax</th>
      <th>Email</th>
   </tr>
   
   <!-- *** Step #3*** for-each of the PERSON elements 
                Don't forget the end tag after the row is finished. -->
   <tr>
       <!-- *** Step #4*** In the <td> below, select the NAME element, send the value as output 
                    Include the stop tag with this <xsl: tag>   -->
      <td>
	        Name field will go here
	     </td>
      <!-- *** Step #5*** Select the ADDRESS element, send the value as output -->
      <td>
	        Address field will go here
	     </td>
      <td>
	        TEL field will go here
	     </td>
      <td>
	        FAX field will go here
	     </td>
      <td>
	        EMAIL field will go here
	     </td>
   </tr>
   
   <!-- *** Step #3*** the stop tag for the for-each goes here. -->
</table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>
