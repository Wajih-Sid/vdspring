
<%--
  Created by IntelliJ IDEA.
  User: Wajih Sid
  Date: 10/25/2015
  Time: 11:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>


  <meta charset="utf-8" />
  <title>New User Signup</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />

  <head>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
      <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">

  <div class="page-header">
    <h1>Registration form <small>Please Enter User Information</small></h1>
  </div>

  <!-- Registration form - START -->
  <div class="container">
    <div class="row">
      <form role="form"  name="user" method="post" action="${pageContext.request.contextPath}/UsersController/newuser">
        <div class="col-lg-6">

            <div class="form-group">
                <label>Enter Email</label>
                <div class="input-group">
                    <input type="email" class="form-control" id="InputEmailFirst" name="useremail" placeholder="Enter Email" required>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                </div>
            </div>

          <div class="form-group">
            <label for="InputName">Enter UserName</label>
            <div class="input-group">
              <input type="text" class="form-control" name="username" id="InputName" placeholder="Enter Name" required>
              <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
            </div>
          </div>

          <div class="form-group">
            <label for="InputMessage">Favourite Programming Languages</label>
            <div class="input-group">
              <textarea name="favProgramming" id="InputMessage" class="form-control" rows="5" required></textarea>
              <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
            </div>
          </div>
          <input type="submit" name="submit" id="submit" value="Submit" class="btn btn-info pull-right">
        </div>
      </form>

    </div>
  </div>
  <!-- Registration form - END -->

</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

</body>
</html>