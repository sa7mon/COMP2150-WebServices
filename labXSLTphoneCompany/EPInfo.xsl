<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">

	<!-- Add HTML5 output-->
	<xsl:output method="html" doctype-system="about:legacy-compat"/>
	<xsl:template match="EPInfo">
		<html>
			<head>
				<meta charset="utf-8" />
				<title>EP Information</title>
			</head>
			<body>
				<h1>Enventis Information</h1>
				<h2>
					<xsl:value-of select="CRMActivity/Customer/FirstName" />&#160;
					<xsl:value-of select="CRMActivity/Customer/LastName" />
				</h2>

				<!-- Call template (like a function) -->
				<xsl:call-template name="showComment" />

				<!-- Call another template -->
				<xsl:call-template name="countFeature" />
			</body>
		</html>
	</xsl:template>

	<!-- TEMPLATES -->

	<xsl:template name="showComment">
		<p>
			<strong>Action to take:</strong><br />
			<xsl:value-of select="//Comments" disable-output-escaping="yes" />
		</p>
		<p>
			<strong>Special Notes:</strong><br />
			<xsl:value-of select="//Comments" />
		</p>
	</xsl:template>

	<xsl:template name="countFeature">
		<p>
			<strong>Total number of features:</strong><br />
			<xsl:value-of select="count(CRMActivity/CustomerRequest/EventData/SubscribedPlan/Feature)"/>
		</p>
	</xsl:template>

</xsl:stylesheet>