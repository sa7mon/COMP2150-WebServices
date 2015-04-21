# Project: XSLT

## Requirements
**This project is designed so you can demonstrate your specific knowledge on how to:**

**Use XSLT and Saxon to create HTML pages from XML documents.**
   * Create an HTML web page that utilizes CSS.
   * Utilize SAXON as an XSLT parser.
   * Transform an XML document into a HTML web page using XSLT (XSL Transformation language)

## Specifications

**BoldComment is a grading program that maintains a list of comments for each objective of a project.**

The data is stored as an XML document. In order to give the student specific feedback on his or her project, the XML has to be transformed into a stand-alone HTML page that can be pasted into a comment window in an LMS (Learning Management System) such as D2L, BlackBoard, or Moodle.

**Your job is to write an XSLT file that will be used to convert the XML data from boldComment.xml into a nice, easy-to-read HTML web page that can be copied and pasted into an LMS discussion area.**

Using the boldComment.xml.zip file, create an XSLT document named boldComment.xsl that
can be used to format the XML data into an HTML web page using Saxon.

   * Do not change the XML file itself.
   * **10 points** Only include data from comment elements where the selected attribute is "true".
   * **25 points** Your XSLT file should include the following XSLT keywords:
      * \<apply-templates\>
      * \<for-each\>
      * \<call-template\>
      * count( ) the number of objectives
      * \<comment\> (Use this to add a comment block at the top of the HTML page.)
      * XSLT comments (in the XSLT file), describing what each block of code is doing.
   * **5 points** Use embedded CSS in the <head> of the finished page (not an external file). There should be at least:
      * four CSS rules for HTML elements
      * at least one ID rule (using the CSS # operator)
      * at least one class rule (using the CSS . operator)
   * **5 points** Take a screen shot showing the Saxon command you use to create the .html file with the HTML output displayed in a browser in the background.

   The instructor must be able to read the Saxon commands in the command window as well as be able to identify your HTML output file.
