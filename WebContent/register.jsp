<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato|Montserrat&display=swap" rel="stylesheet">
<style>
	body {
	            font-family: 'Lato', sans-serif;
	            background: linear-gradient(184deg, #90c4f7, #fdbacb, #ea9ffb);
	            background-size: 600% 600%;
	
	            -webkit-animation: AnimationName 22s ease infinite;
	            -moz-animation: AnimationName 22s ease infinite;
	            animation: AnimationName 22s ease infinite;
	        }
	        @-webkit-keyframes AnimationName {
	            0%{background-position:86% 0%}
	            50%{background-position:15% 100%}
	            100%{background-position:86% 0%}
	        }
	        @-moz-keyframes AnimationName {
	            0%{background-position:86% 0%}
	            50%{background-position:15% 100%}
	            100%{background-position:86% 0%}
	        }
	        @keyframes AnimationName {
	            0%{background-position:86% 0%}
	            50%{background-position:15% 100%}
	            100%{background-position:86% 0%}
	        }
	
	        h1, h2{
	            margin-bottom: 10px;
	            font-family: 'Montserrat', sans-serif;
	        }
    .vertical-center {
	    width: 50%;
	    margin: 0 auto;
        }       
    form {
            border: #f7f9fb 3px solid;
            padding: 3% 7%;
            background: #f7f9fb;
            -webkit-box-shadow: 0px 0px 3px 1px rgba(161,150,161,1);
            -moz-box-shadow: 0px 0px 3px 1px rgba(161,150,161,1);
            box-shadow: 0px 0px 3px 1px rgba(161,150,161,1);
        }
</style>
</head>
<body>
	<div class="vertical-center">
		<form action="RegisterServlet" method="post">
		  <div class="text-center"><h2>Register</h2></div>
		  <h3 class="text-danger">${ error }</h3>
		  <div class="form-row">
		    <div class="form-group col-md-6">
		      <label for="fName">First Name*</label>
		      <input type="text" class="form-control" id="fName" name="fName" placeholder="First Name" value="${ firstName }">
		    </div>
		    <div class="form-group col-md-6">
		      <label for="lName">Last Name*</label>
		      <input type="text" class="form-control" id="lName" name="lName" placeholder="Last Name" value="${ lastName }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="address">Address*</label>
		    <input type="text" class="form-control" id="address" name="address" placeholder="Enter Address" value="${ address }">
		  </div>
		  <div class="form-group">
		    <label for="email">Email*</label>
		    <input type="email" class="form-control" id="email" name="email" name="email" placeholder="Email" value="${ email }">
		  </div>	
		  <div class="form-row">	  
		  <div class="form-group col-md-6">
		    <label for="password">Password*</label>
		    <input type="password" class="form-control" id="password" name="password" placeholder="Password">
		  </div>
		  <div class="form-group col-md-6">
		    <label for="confirmPass">Confirm Password*</label>
		    <input type="password" class="form-control" id="confirmPass" name="confirmPass" placeholder="Confirm Password">
		  </div>
		  </div>
		  <div class="form-group">
		    <div class="form-check">
		      <input class="form-check-input" type="checkbox" id="gridCheck" name="termsCheck" value="true">
		      <label class="form-check-label" for="gridCheck">
		        I agree to the terms of service
		      </label>
		    </div>
		  </div>
		  <div class="text-center">
	  		  <button type="submit" class="btn btn-primary">Sign in</button>
	  		  <a class="btn btn-danger" href="./login.jsp">Cancel</a>
		  </div>
		</form>
	</div>
</body>
</html>