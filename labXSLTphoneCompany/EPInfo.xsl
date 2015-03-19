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
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>