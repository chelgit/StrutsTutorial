<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags" %> 
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Orders</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/app.css" rel="stylesheet">  
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12"> 
	        <div class="page-header">
		        <h1>Clinic Appointment</h1>
	        </div> 
	        
	        <s:form method="post" action="%{#request.contextPath}/bookings" cssClass="form-horizontal" theme="simple">
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="name">Name</label>
                    <div class="col-sm-4">
                        <s:textfield id="name" name="name" cssClass="form-control"/>
                    </div>
                    <div class="col-sm-4">
                        <s:fielderror fieldName="name" />
                    </div>
                </div>                                
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="nric">NRIC</label>
                    <div class="col-sm-4">
                        <s:textfield id="nric" name="nric" cssClass="form-control"/>
                    </div>
                    <div class="col-sm-4">
                        <s:fielderror fieldName="nric" />
                    </div>
                </div> 
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="dob">Birth Date</label>
                    <div class="col-sm-4">
                     <s:textfield id="dob" type="date" name="dob" cssClass="form-control"   placeholder="dd/mm/yyyy"/>  
                    <!--   <s:textfield id="dob" type="text" name="dob" class="disableFuturedate" placeholder="dd/mm/yyyy"/>  -->  
                    </div>
                    <div class="col-sm-4">
                        <s:fielderror fieldName="dob" />
                    </div>
                </div>   
				<script>
				   $(document).ready(function () {
				      var currentDate = new Date();
				      $('.disableFuturedate').datepicker({
				      format: 'dd/mm/yyyy',
				      autoclose:true,
				      endDate: "currentDate",
				      maxDate: currentDate
				      }).on('changeDate', function (ev) {
				         $(this).datepicker('hide');
				      });
				      $('.disableFuturedate').keyup(function () {
				         if (this.value.match(/[^0-9]/g)) {
				            this.value = this.value.replace(/[^0-9^-]/g, '');
				         }
				      });
				   });
				</script>
 
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-4">
                        <s:submit cssClass="btn btn-primary"/>
                    </div>
                </div>
            </s:form>
	        <a href="${pageContext.request.contextPath}/bookings" class="btn btn-info">
		        <span class="glyphicon glyphicon-arrow-left"></apan> Back to Bookings
	        </a>
        </div><!--/col-md-12--->
    </div><!--/row-->
</div><!--/container-->
</body>
</html>
	