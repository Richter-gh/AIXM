<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <link rel="stylesheet" href="http://openlayers.org/en/v3.4.0/css/ol.css" type="text/css">
<style type="text/css">
	.filelist { 
		float: left;
		width: 250px;
		position: relative;
		
		float: left;
		background:#ccc;
		margin-left: 10px;
    	margin-right: 10px;
    	margin-bottom: 10px;
		}	  
	.upload {
		position: relative;
		background:#ccc;		
		margin-left: 10px;
    	margin-right: 10px;
    	margin-bottom: 10px;
		margin-top: 10px;
		}
	.map {
		float: left;
		width: 60%;
		position: relative;
		background: #fff;
		}
	</style> 

    <script src="http://openlayers.org/en/v3.4.0/build/ol.js" type="text/javascript"></script> 
<title>AIXM Project</title>
</head>
<body>
<center>
	<div class="upload">
    	<h1>File Upload</h1>
    	<form method="post" action="upload"
	        enctype="multipart/form-data">
        	Select file to upload: <input type="file" name="file" size="60" /><br />
        	<br /> <input type="submit" value="Davai" />
    	</form>
    </div>
    <div class="filelist">
    <h2>${requestScope.message}</h2></br>
    2</br>
    3</br>
    </div>
    <div id="map" class="map"></div>
    <script type="text/javascript">
      var map = new ol.Map({
        target: 'map',
        layers: [
          new ol.layer.Tile({
            source: new ol.source.MapQuest({layer: 'sat'})
          })
        ],
        view: new ol.View({
          center: ol.proj.transform([37.41, 8.82], 'EPSG:4326', 'EPSG:3857'),
          zoom: 4
        })
      });
    </script>
</center>
</body>
</html>