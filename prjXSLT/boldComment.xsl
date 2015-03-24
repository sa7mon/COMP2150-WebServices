<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
	<xsl:output method="html" doctype-system="about:legacy-compat" indent="yes"/>
	<xsl:template match="XMLData">
		<xsl:comment>
			Project: XSLT
			Created by: Dan Salmon
			XSL Document: boldComment.xsl
			XML Document: boldComment.xml
			HTML Document: boldComment.html
			Objective: Create an XSL document to parse boldComment.xml and output a styled html document. 
		</xsl:comment>

		<html>
			<head>
				<title>Feedback for <xsl:value-of select="title" /></title>
				<style type="text/css">
					body {
						background: gray;
						font-family: Calibri,Candara,Segoe,Segoe UI,Optima,Arial,sans-serif; 
					}
					section {
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
				</style>
			</head>
			<body>
				<!-- 
					boldComment.html
					Created: 3/17/15
				-->
				<section>
					<h1>
						<xsl:value-of select="title" />
					</h1>
					<h2>
						Summary: <xsl:value-of select="summary" />
					</h2>
				</section>

				<xsl:comment>
					Loop through every "item" object.
				</xsl:comment>

				<xsl:apply-templates select="item"/>
			</body>
		</html>
	</xsl:template>

	<xsl:template match="item">
		<section>
			<strong>
				Objective: <xsl:value-of select="objective" />
			</strong>
			<br />
			<xsl:call-template name="getComments" />
		</section>
		<br />
	</xsl:template>

	<xsl:template name="getComments">
		<xsl:for-each select="comment">
			<xsl:if test="@selected='true'">
				<xsl:value-of select="." />
				<br />
			</xsl:if>
		</xsl:for-each>
	</xsl:template>

</xsl:stylesheet>