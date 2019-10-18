<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UNDER_CONSTRUCTION</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato|Montserrat&display=swap" rel="stylesheet">
    
    <style>
	   	body {
	            font-family: 'Lato', sans-serif;
            	background: #b8e3ff;
			}
        h1, h2 {
            margin-bottom: 10px;
            font-family: 'Montserrat', sans-serif;
        }
	        
	    .container {
	            border: #eddd28 3px solid;
	            padding: 3% 7%;
	            background: repeating-linear-gradient(
				  45deg,
				  #eddd28,
				  #eddd28 10px,
				  #57564b 10px,
				  #57564b 20px
				);
	            -webkit-box-shadow: 0px 0px 3px 1px rgba(161,150,161,1);
	            -moz-box-shadow: 0px 0px 3px 1px rgba(161,150,161,1);
	            box-shadow: 0px 0px 3px 1px rgba(161,150,161,1);
	    }
	    .box{
	    	background: #f7f9fb;
	    	border: #57564b 3px solid;
	    }
    </style>
    
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <a class="navbar-brand" href="./dashboard.jsp">COMP3095 Project</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarText">
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item">
	        <a class="nav-link" href="./dashboard.jsp">Home</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="#">Tab2</a>
	      </li>
	    </ul>
	    <span class="navbar-text">
	      Hello ${User.getFirstname()}
	    </span>
	      <form class="form-inline" action="Logout" method="get">
		  	<button class="btn btn-outline-success" type="submit">Logout</button>
  		  </form>
	  </div>
	</nav>	
	
	<div class="container mt-3">
		<div class="text-center"><div class="box"><h2 class="mt-2">UNDER CONSTRUCTION</h2></div></div>
	
	
	</div>
</body>
</html>