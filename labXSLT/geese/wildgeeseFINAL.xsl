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
      <!-- hard code in a graphic to make sure everything is working 
        <img src="maryOliverPercy.jpg" 
            alt="Mary Oliver and her dog Percy"
            align="left" />
      -->
      <!-- Display graphic dynamically using XML data -->    
       <img align="left">
          <!-- add src attribute -->
          <xsl:attribute name="src">
             <xsl:value-of select="poem/photo" />
          </xsl:attribute>
          <!-- add alt attribute -->
          <xsl:attribute name="alt">
             <xsl:value-of select="poem/description" />
          </xsl:attribute>            
        </img>

        <h1><xsl:value-of select="poem/title"/></h1>
        <h2>by <xsl:value-of select="poem/author"/></h2>
        <p>Published on: <xsl:value-of select="poem/date"/></p>
        <p>Published in: <xsl:value-of select="poem/from"/></p>
        <hr /><br />
        <xsl:apply-templates select="poem/stanza" />
        
        <hr />
        The total number of stanzas: <xsl:value-of select="count(poem/stanza)" />
        <br />
        The total number of lines: <xsl:value-of select="count(poem/stanza/line)" /> 
        <br />
        The total number of selected lines: <xsl:value-of select="count(poem/stanza/line/@selected)" />
        <br />
        The total number of words: <xsl:value-of select="sum(poem/stanza/line/@wordCount)" />
        <hr />   
     </body>
   </html>
</xsl:template>

<!-- * * * TEMPLATE: stanza * * *  -->
<xsl:template match="stanza">
   <p>
      <xsl:apply-templates select="line" /> 
   </p>
   <p>
      DEBUG Number of lines in this stanza:
      <xsl:value-of select="count(./line)" />
      <br />
      DEBUG Number of words for this stanza:
      <xsl:value-of select="sum(./line/@wordCount)" />
   </p>
</xsl:template>  

<!-- * * * TEMPLATE: line * * * -->
<xsl:template match="line">
   <!-- check for an attribute that is either true or false -->
   <xsl:if test="@selected">
      <b><i>
         <xsl:value-of select="."/> (BOLD DEBUG word count: <xsl:value-of select="@wordCount" />)
      </i></b><br />
   </xsl:if>
   <!-- check for an attribute that has a specific value - bold -->
   <xsl:if test="@style[.='bold']">
      <b>
         <xsl:value-of select="."/> (BOLD DEBUG word count: <xsl:value-of select="@wordCount" />)
      </b><br />
   </xsl:if>
   <!-- check for normal output -->
   </xsl:if>
      <xsl:if test="@style[.='normal']">
          <xsl:value-of select="."/> (BOLD DEBUG word count: <xsl:value-of select="@wordCount" />)<br />
   </xsl:if>

</xsl:template>   

</xsl:stylesheet>