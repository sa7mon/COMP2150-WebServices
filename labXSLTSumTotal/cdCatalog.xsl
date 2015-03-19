<xsl:stylesheet
   xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
         version="2.0">
   
   <xsl:template match="catalog">
       <xsl:comment>
          Created from XML data
          XLS written by Peter Johnson - peterk@WebExplorations.com
          XML Document: cdCatalog.xml
          DDT Document: none
          XLS Document: cdCatalog.xsl
       </xsl:comment>
       <html>
       <head>
         <title>Demo XSLT Sum Function</title>
         <style type="text/css">
         
              body {
              font-size:   medium;
              }
         </style> 

       </head>
       <body>
          <h1>Using the XSLT sum( ) and count( ) functions.</h1>
          <!-- Using sum( ) -->
          <p>
             The total value of all the CDs is:   
             <xsl:value-of select="format-number(sum(/catalog/cd/price),'$##,###.00')" />  
          </p>   
          <!-- Using count( ) -->
          <p>
             There are <xsl:value-of select="count(/catalog/cd)" /> CDs in this collection.
          </p>
           <!-- Using count( ) with attribute values -->
        <p>
             There are <xsl:value-of select="count(/catalog/cd[@format='MAC'])" /> MAC formatted CDs in this collection. (matching all format="MAC" attributes 'MAC')
          </p>

          <!-- Using count( ) with attribute values and regex function contains( ) -->
          <p>
             There are <xsl:value-of select="count(/catalog/cd[contains(@format,'MAC')])" /> MAC formatted CDs in this collection. (matching all format=" " containing the letters "MAC" using RegEx).
          </p>
       </body>
       </html>
   </xsl:template>
</xsl:stylesheet>