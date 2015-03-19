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

				<h2>Features to include</h2>
				<ul>
					<!-- Does something for all of the following objects (..../Feature like a css selector) -->
					<xsl:apply-templates select="CRMActivity/CustomerRequest/EventData/SubscribedPlan/Feature" />
				</ul>
			</body>
		</html>
	</xsl:template>

	<!-- TEMPLATES -->

	<xsl:template name="showComment">
		<p>
			<strong>Action to take:</strong><br />
			<xsl:value-of select="//Comments" disable-output-escaping="yes" />
		</p>
	</xsl:template>

	<xsl:template name="countFeature">
		<p>
			<strong>Total number of features:</strong><br />
				<xsl:value-of select="count(CRMActivity/CustomerRequest/EventData/SubscribedPlan/Feature)"/>
		</p>
	</xsl:template>

	<!-- Template for matching -->
	<xsl:template match="Feature">
		<li>
			<xsl:value-of select="./PlanFeatureID" />
		</li>
	</xsl:template>

</xsl:stylesheet> 