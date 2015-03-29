<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="http://openlayers.org/en/v3.4.0/css/ol.css"
	type="text/css">
<style type="text/css">
#maket {
	width: 100%;
}

TD {
	vertical-align: top;
	padding: 5px;
}

TD#leftcol {
	width: 200px;
	background: #ccc;
	border: 1px solid #000;
}

TD#rightcol {
	background: #fc3;
	border: 1px solid #000;
}

#spacer {
	width: 10px;
}

.filelist {
	float: left;
	width: 250px;
	position: absolute;
	bottom: 10px;
	top: 160px;
	float: left;
	background: #ccc;
	left: 10px;
	text-align: left;
}

.upload {
	position: absolute;
	background: #ccc;
	top: 10px;
	left: 10px;
	right: 10px;
}

.map {
	float: left;
	right: 10px;
	top: 160px;
	left: 270px;
	bottom: 10px;
	position: absolute;
	background: #fff;
}
</style>

<script src="http://openlayers.org/en/v3.4.0/build/ol.js"
	type="text/javascript"></script>
<title>AIXM Project</title>
</head>
<body>
	<center>
		<div class="upload">
			<h1>
				<a href="">AIXM Project</a>
			</h1>
			<form method="post" action="upload" enctype="multipart/form-data">
				Select file to upload: <input type="file" name="file" size="60" />
				</br> <input type="submit" value="Davai" />
			</form>
		</div>
		<table id="maket">
			<tr>
				<td id="leftcol">

					<div class="filelist">
						<%
				out.println("Uploaded files:</br></br>");			
				if (request.getAttribute("uploadedFiles") != null) {
					ArrayList itemsArray = (ArrayList) request
							.getAttribute("uploadedFiles");
					for (int i = 0; i < itemsArray.size(); i++) {
						out.println("<a href=\"display?file="+itemsArray.get(i)+"\">"+itemsArray.get(i)+"</url></br>");						
					}
				} else {
					out.println("no files uploaded yet");
				}
			%>

					</div>
				</td>
				<td id="spacer"></td>
				<td id="rightcol">
					<div id="map" class="map"></div> <script type="text/javascript">
			var map = new ol.Map({
				target : 'map',
				layers : [ new ol.layer.Tile({
					source : new ol.source.MapQuest({
						layer : 'sat'
					})
				}) ],
				view : new ol.View({
					center : ol.proj.transform([ 37.41, 8.82 ], 'EPSG:4326',
							'EPSG:3857'),
					zoom : 4
				})
			});
		</script>
				</td>



			</tr>
		</table>
	</center>
</body>
</html>