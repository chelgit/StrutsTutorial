<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags" %> 
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Appointment</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/app.css" rel="stylesheet"> 
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12"> 
	        <div class="page-header">
	            <h1>Appointments</h1>
		    </div>
            <s:actionmessage cssClass="alert alert-danger"/>
            <table class="table table-striped">
                <tr>
                    <th>Appointment ID</th>
                    <th>Name</th>
                    <th>NRIC</th>
                    <th>Birth Date</th>  
                </tr>
                <s:iterator value="model">
                <tr>
                    <td><s:property value="appointmentid"/></td>
                    <td><s:property value="name"/></td>
                    <td><s:property value="nric"/></td>
                    <td><s:property value="dob"/></td>                                  
                </tr>
                </s:iterator>
            </table>
            <a href="bookings/new" class="btn btn-primary"><span class="glyphicon glyphicon-file"></span> Add A New Booking Appointment</a>
        </div><!--/col-md-12--->
    </div><!--/row-->
</div><!--/container-->
</body>
</html>
	