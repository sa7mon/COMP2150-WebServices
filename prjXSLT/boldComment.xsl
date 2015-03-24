<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
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

				</style>
			</head>
			<body>
				<!-- 
					boldComment.html
					Created: 3/17/15
				-->
				<h1>
					<xsl:value-of select="title" />
				</h1>
				<h2>
					<xsl:value-of select="summary" />
				</h2>

				<xsl:comment>
					Loop through every "item" object.
				</xsl:comment>
				<xsl:call-template name="outputItem" />
			</body>
		</html>
	</xsl:template>

	<xsl:template name="outputItem">
		<xsl:for-each select="item">
			<div class="item">
				<strong>
					Objective: <xsl:value-of select="objective" />
				</strong>
			</div>
			<br />
		</xsl:for-each>
	</xsl:template>

</xsl:stylesheet>