<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">

<!-- use the output tag to control the serialization of the HTML results
     method="xml" will output XHTML adding stop tags to single entities like img 
     This output statement will add in the proper DOCTYPE at the top of the XHMTL file 
     Reference: http://www.peachpit.com/articles/article.aspx?p=21844 -->
<xsl:output method="xml" 
            doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN" 
            doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" 
            indent="yes" />

<!-- match the root element and everything inside of it -->
<xsl:template match="/">

   <xsl:comment>
      Created from XML data
      Written: 04-05-03 Peter Johnson 
      - Peter.johnson@southcentral.edu
      Revised: 03-02-10
      XML Document: wildgeese.xml
      DDT Document: none
      XLS Document: wildgeese.xsl 
   </xsl:comment>    
     
   <html>
   <head>
    <title><xsl:value-of select="poem/title" /></title>
    
    <!-- Set up styles for the final output page -->    
    <style type="text/css">
    h2{
    color:       #333366; 
    }
    h4{
    color:       #333366; 
    }
    hr{
    color:       #336633;    /* dark green */
    }   
    img {
    padding:     25px;
    }        
    </style> 
    </head>
    <body>
        <h1><xsl:value-of select="poem/title" /></h1>
        <h2>by <xsl:value-of select="poem/author" /></h2>
        <p>Published on: <xsl:value-of select="poem/date" /></p>
        <p>Published in: <xsl:value-of select="poem/from" /></p>
        <hr /><br />
        <xsl:apply-templates select="poem/stanza" />
        
     </body>
   </html>
</xsl:template> 

<xsl:template match="stanza">
  <p>
    <xsl:apply-templates select="line" />
  </p>
</xsl:template>

<xsl:template match="line">
  <!-- output the actual line -->
  <xsl:value-of select="."/>
  <br />
</xsl:template>

</xsl:stylesheet>