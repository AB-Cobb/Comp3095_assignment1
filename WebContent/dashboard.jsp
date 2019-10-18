<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato|Montserrat&display=swap" rel="stylesheet">
    
    <style>
    	body{
            font-family: 'Lato', sans-serif;
            background: #b8e3ff;
            
    	}
        h1, h2{
            margin-bottom: 10px;
            font-family: 'Montserrat', sans-serif;
        }
    .container{
    	background: #f7f9fb;
    	height: 80%;
    	width: 100%;
    }
    
    .border{
    	display: block;
    	border: black 1px solid;
    	background: #faf9f2;
		min-height: 40%;
    
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
		<div class="text-center"><h2>DASHBOARD</h2></div>
		
		<div class="row">
			<a class="col-sm-6 border text-center" href="./construction.jsp">
				Future Enhancement
			</a>
			<div class="col-sm-6">
			<a class="col-sm-12 border text-center" href="./construction.jsp">
				Future Enhancement
			</a>
			<br>
			<a class="col-sm-12 border text-center" href="./construction.jsp">
				Future Enhancement
			</a>
			</div>
		</div>
	
	</div>
</body>
</html>