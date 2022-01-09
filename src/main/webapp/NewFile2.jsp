<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<style>
html {
  height: 100%;
}
      ::-webkit-input-placeholder {
       color: white !important;
  }

    :-moz-placeholder { /* Firefox 18- */
       color: white !important;

  }

    ::-moz-placeholder {  /* Firefox 19+ */ 
       color: white !important;
  }

    :-ms-input-placeholder {   
      color: white !important;
  }

input[type="text"], input[type="password"], textarea, select { 
    outline: none;
}

body  {
    background-image:  url("https://res.cloudinary.com/manzur/image/upload/v1482602555/lights-dark-abstract-bokeh_compressed_ytwf3k.jpg");
    background-size:   cover;
    background-repeat: no-repeat;
    font-family: tahoma;
  }

  .gradient {
  width: 100%;
  height: 100%;
  background-color: #f35626;
    position: fixed;
    z-index: 1;
    opacity: 0.5;
    animation-name: gradientAnimation;
    animation-duration:  60s;
    animation-iteration-count: infinite;

}
@-webkit-keyframes gradientAnimation {
    0%   {background-color: #ff0028;}
    10%  {background-color: #ffa400;}
    20%  {background-color: #fff200;}
    30% {background-color: #00b487;}
    40% {background-color: #0056bc;}
    50% {background-color: #b71f93;}
    60% {background-color: #0056bc;}
    70% {background-color: #00b487;} 
    80%  {background-color: #fff200;}
    90%  {background-color: #ffa400;}
    100%   {background-color: #ff0028;}  
}

  .container {
    position: relative;
    z-index: 2;
  }

  .log-in {
    padding-top: 15%;
    display: block;
    margin: 0 auto;
    width: 230px;
  }
  .log-in a {
    color: white;
    font-size: 10px;
  }
  .log-in hr {
    border-color: honeydew;
    border-width: 1px;
  }
  #Facebook {
    width: 230px;
    height: 40px;
    background-color: #3b5998;
    border-radius: 80px;
    color: white;
    font-family: tahoma;
    font-size: 12px;
    outline: none;
  }
  #Email {
    width: 230px;
    height: 40px;
    margin-bottom: 6px;
    background-color: rgba(255,255,255,0.3);
    font-style: Arial;
    border-radius: 80px;
    box-shadow: none;
    border: none;
    color: white;
    font-size: 12px;
  }
  #Password {
    width: 230px;
    height: 40px;
    margin-top: 6px;
    margin-bottom: 15px;
    background-color: rgba(255,255,255,0.3);
    font-style: Arial;
    border-radius: 80px;
    box-shadow: none;
    border: none;
    color: white;
    font-size: 12px;
  }   
  #Login {
    width: 230px;
    height: 40px;
    margin-top: 12px;
    margin-bottom: 30px;
    background-color: #ff6933;
    font-style: Arial;
    border-radius: 80px;
    color: white;
    font-size: 12px;
    outline: none;
  }


input#Email {
    background-image: url(https://res.cloudinary.com/manzur/image/upload/v1481795702/LoginPage/iconemail_gb1tbl.png);
    background-position: 5px 5px;
    background-repeat: no-repeat;
    text-indent: 40px;
    padding-left: 5px;
    font-size: 11px;
}
input#Password {
    background-image: url(https://res.cloudinary.com/manzur/image/upload/v1481795703/LoginPage/password_jfbvio.png);
    background-position: 5px 5px;
    background-repeat: no-repeat;
    text-indent: 40px;
    paddi
</style>
</head>
<body>
  <div class="gradient">
  </div>
    <div class="container">
      <div class="log-in"">
        <button class="btn" id="Facebook">Login through Facebook</button>
        <hr></hr>
        <input type="text" id="Email" placeholder="Email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Email'"></input><br/>
        <input type="password" id="Password" placeholder="Password" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Password'"></input><br/>
        <button class="btn" id="Login">Get Started</button><br/>
        <a href="#" style="float: left;">Create Account</a>
        <a href="#" style="float: right;">Need Help?</a>
      </div>  
    </div>
</body>
</html>