<%-- 
    Document   : MainClassification
    Created on : Aug 4, 2018, 10:02:46 AM
    Author     : User
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Main Classification</title>
        
	
    </head>
    <body>
        <div id="page-wrapper"><%@ include file="Dashboard.jsp"%>
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Main Classification</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                     </div>
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Add Main Classification
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-lg-6">
                                        <form role="form" action="mainUpdateController" method="post">
                                            <div class="form-group">
                                                <label>Main Classification ID</label>
                                                <input name="mainClsID" class="form-control" value="${mainclass.getId()}" readonly="mainClsID">
                                            </div>
                                            <div class="form-group">
                                                <label>Title</label>
                                                <input name="mainClassification" class="form-control" value="${mainclass.getName()}">
                                            </div>                                            
                                            <button type="submit" class="btn btn-default">Submit Button</button>
                                            <button type="reset" class="btn btn-default">Reset Button</button>
                                        </form>
                                    </div>
                                    <!-- /.col-lg-6 (nested) -->
                                 
                                    <!-- /.col-lg-6 (nested) -->
                                    </div>
                                <!-- /.row (nested) -->
                            </div>
                             
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
            </div>
            
    </body>
</html>

