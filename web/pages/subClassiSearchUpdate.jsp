<%-- 
    Document   : SubClassification
    Created on : Aug 4, 2018, 10:16:55 AM
    Author     : User
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Sub Classification</title>
    </head>
    <body><%@ include file="Dashboard.jsp"%>
        <form action="ScViewSearchController" method="POST">
        <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Sub Classification</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                               Search & Update
                            </div>
                           <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                                        <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                        <div><label>Select Search Option</label>&nbsp;&nbsp;&nbsp;&nbsp;
                    
                    <select name="Search_option">
                         <option value="id">Sub Classification ID</option>
                         <option value="title">Sub Classification</option>
                    </select>
                <input type="text"  name="Search_value">
                <input type="submit" name="Search" value="Search"></div>
                                                         <div class="panel-body">
                                <div class="dataTable_wrapper">
                                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                        <thead>
                                            <tr>
                                                <th>Sub Classification ID</th>
                                                <th>Main Classification ID</th>
                                                <th>Title</th>
                                                <th>Edit</th>
                                                <th>Delete</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="item" items="${subCalsi}">                                                   
                                            <tr class="odd gradeX">
                                                <td>${item.id}</td>
                                                <td>${item.getMainClassificationName()}</td>
                                                <td>${item.name}</td>
                                                
                                                <td><a href="editSubClasiController?sid=${item.id}"><i class="fa fa-fw" aria-hidden="true" title="Copy to use edit"></i></a></td>
                                                <td><a href="DeleteSubController?sid=${item.id}"><i class="fa fa-fw" aria-hidden="true" title="Copy to use trash"></i></a></td>
                                            </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- /.table-responsive -->
                            </div>
                        
                        </div>
                        </div>
                        </div>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
            </div>
       </form>     
    </body>
</html>

