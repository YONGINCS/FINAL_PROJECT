<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Import CSV</h1><br><br>
	 <form method="post" action="/SaveCSV" enctype="multipart/form-data"> 
    		<label for="uploadid">Choose CSV:*</label>
			  <input type="file" accept=".csv" name="results" required>
	  		<input type="submit" class="pure-button pure-button-primary" value="Upload">
	 </form>	
</body>
</html>