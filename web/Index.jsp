<%-- 
    Document   : Index
    Created on : Apr 1, 2017, 3:47:30 PM
    Author     : luandeptrai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Website demo CRUD</title>

        <!--Link css files-->
        <link href="static/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="static/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>
        <link href="static/css/dataTables.bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <h2>Danh sach nhan vien</h2>
        
        <table id="tbNhanVien">
            <thead>
                <tr>
                    <th>Ma nhan vien</th>
                    <th>Ho ten</th>
                   
                </tr>
            </thead>
        </table>

        <!--Source script files-->
        <script src="static/js/jquery-2.2.4.min.js" type="text/javascript"></script>
        <script src="static/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="static/js/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="static/js/dataTables.bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
