<!--
	Project: XSLT
	Created by: Dan Salmon
	XSL Document: boldComment.xsl
	XML Document: boldComment.xml
	HTML Document: boldComment.html
	Objective: Create an XSL document to parse boldComment.xml and output a styled html document. 
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
	<xsl:output method="html" doctype-system="about:legacy-compat" indent="yes"/>
	<xsl:template match="XMLData">
		<html>
			<head>
				<xsl:comment>
					Project: XSLT
					Created by: Dan Salmon
					Created on: 3/17/15
					XSL Document: boldComment.xsl
					XML Document: boldComment.xml
					HTML Document: boldComment.html
					Objective: Create an XSL document to parse boldComment.xml and output a styled html document. 
				</xsl:comment>
				<title>Feedback for <xsl:value-of select="title" /></title>
				<style type="text/css">
					body {
						background: gray;
						font-family: Calibri,Candara,Segoe,Segoe UI,Optima,Arial,sans-serif; 
					}
					section.objective,section#intro {
						width: 75%;
						margin: auto;
						background-color: white;
						padding-top: 5px;
						padding-bottom: 5px;
						padding-left: 5px;
						margin-top: 10px;
						border-radius: 10px;
					}
					h3,h1 {
						text-align: center;
					}
					h1#title {
						margin-top: -5px;
					}
				</style>
			</head>
			<body>
				<section id="intro">
					<h1 id="title">
						<xsl:value-of select="title" />
					</h1>
					<h2>
						<xsl:value-of select="summary" />
					</h2>
					<p>
						<!-- Count all of the objectives. No need to check for enabled -->
						<strong>
							Total objectives: 
						</strong><xsl:value-of select="count(/XMLData/item/objective)" />
					</p>
					<p>
						<!-- Call the template sumTotalPoints like a function -->
						<xsl:call-template name="sumTotalPoints" />
					</p>
				</section>
				<!-- Loop through every 'item' element -->
				<xsl:apply-templates select="item"/>
			</body>
		</html>
	</xsl:template>

	<xsl:template match="item">
		<section class="objective">
			<strong>
				Objective: <xsl:value-of select="objective" />
			</strong>
			<br />
			<!-- Call the getComments template like a function. -->
			<xsl:call-template name="getComments" />
		</section>
	</xsl:template>

	<xsl:template name="getComments">
		<!-- Output the earned and total objective points -->
		Objective Points: <xsl:value-of select="objective/@pointValue" />/<xsl:value-of select="comment[@selected='true' and . ='Total Points']/@pointValue" />
		<br />
		<ul>
			<xsl:for-each select="comment[@selected='true' and not(. ='Total Points')]">
				<li>
					<strong>
						<xsl:value-of select="@pointValue" />&#160;
					</strong>
						<xsl:value-of select="." />
				</li>
			</xsl:for-each>
		</ul>
	</xsl:template>

	<xsl:template name="sumTotalPoints">
		<!-- Output the total earned and possible project points -->
		<strong>
			Project Score: 
		</strong>
		<xsl:value-of select="sum(/XMLData/item/objective[@selected='true']/@pointValue)" /> / <xsl:value-of select="sum(/XMLData/item/comment[@selected='true' and . ='Total Points']/@pointValue)" />
	</xsl:template>
</xsl:stylesheet>