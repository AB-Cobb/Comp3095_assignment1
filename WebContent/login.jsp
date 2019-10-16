<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
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
        input[type="email"] {
            margin-bottom: -1px;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }
        input[type="password"] {
            margin-bottom: 10px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }
        .vertical-center {
            min-height: 100%;  /* Fallback for browsers do NOT support vh unit */
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            width: 100%;
        }
        form{
            border: ghostwhite 3px solid;
            padding: 3% 7%;
            background: ghostwhite;
            -webkit-box-shadow: 0px 0px 3px 1px rgba(161,150,161,1);
            -moz-box-shadow: 0px 0px 3px 1px rgba(161,150,161,1);
            box-shadow: 0px 0px 3px 1px rgba(161,150,161,1);
        }
    </style>
    <script src="https://www.google.com/recaptcha/api.js"></script>
    
</head>
<body>
<div class="text-center">
    <div class="vertical-center">
        <form action="Login" method="post">
            <h2>Login</h2>
            <h2 class="text-danger">${ Message }</h2>
            <input type="email" id="username" class="form-control" placeholder="Username" name="username" autofocus value="${ Username }">
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password">
            <!--  <label for="check">
                <input type="checkbox" id="check"/>
                I am not a robot
            </label> -->
            <div class="g-recaptcha"
			data-sitekey="6LdpNb0UAAAAAB8tqgKCVswqCtBuJhU_G0gst7OE"></div>
            <div>
                <button class="btn btn-dark" type="submit" name="login">Log In</button>
            	<br>
            	<a class="btn btn-dark" href="register.jsp">Register</a>
            </div>
        </form>
        <!-- <form action="register.jsp" method="get">
        	<button class="btn btn-dark" type="submit" name="register">Register</button>
        </form> -->
    </div>
</div>
</body>
</html>