<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
<table border="1" cellpadding="2" cellspacing="2" align="center" style="width:100%">
    <tr>
        <td height="50" colspan="2"><tiles:insertAttribute name="header" />
        </td>
    </tr>
    <tr>
        <td height="350" width="20%" valign="top"><tiles:insertAttribute name="menu" /></td>
        <td width="80%" valign="top"><tiles:insertAttribute name="body" /></td>
    </tr>
    <tr>
        <td height="50" colspan="2"><tiles:insertAttribute name="footer" />
        </td>
    </tr>
</table>
</body>
</html>