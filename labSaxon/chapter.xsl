<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
     xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
     
<xsl:template match="/">
  <html>
  <head>
    <title> 
      <xsl:value-of select="article/meta/title" />
    </title>
    <!-- External CSS style sheet will go here -->
    <link rel="stylesheet" type="text/css" href="chapter.css"/>
  </head>

  <body>
    <h1><xsl:value-of select="article/meta/title" /></h1>
    
    <p>by <xsl:apply-templates select="article/meta/author" /></p>

    <!-- Build table of contents TOC -->
    <h2>Table of Contents</h2>
    <xsl:apply-templates select="/article/chapter" mode="toc" />
    <hr width="75%" />
    <xsl:apply-templates select="/article/chapter" mode="fullText" />
  </body>
  </html>
</xsl:template>


<!-- The "subroutine" or "method" for the Table of Contents -->
<xsl:template match="chapter" mode="toc">
  <p>
     <b><xsl:value-of select="@number" />:  </b> <xsl:value-of select="@title" />
  </p>
</xsl:template>

<!-- display the full text of the chapter -->
<xsl:template match="chapter" mode="fullText">
  <h3><xsl:value-of select="@number" />.  <xsl:value-of select="@title" /></h3>
  <p>
      <!-- this will display the data for the current element which is the chapter element -->
      <xsl:value-of select="." />  
  </p>
</xsl:template>

</xsl:stylesheet>