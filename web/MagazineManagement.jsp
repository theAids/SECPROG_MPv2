<%-- 
    Document   : MagazineManagement
    Created on : Dec 9, 2014, 12:49:48 AM
    Author     : joechua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello to magazine management!</h1>
         <form class="form-horizontal" name="addJsp" id = "addBookJsp" method="post" action = "addMagazines">
            <div class="Magazine management-choices">
                <input type="submit" name="addBookBtn" id="addBookBtn" value="addMagazine"/>
            </div>
        </form>
        <form class="form-horizontal" name="editProductJsp" id = "editBookJsp" method="post" action = "editMagazines">
            <div class="Magazine management-choices">
                <input type="submit" name="editBookBtn" id="editBookBtn" value="editMagazine"/>
            </div>
        </form>
        <form class="form-horizontal" name="deleteProductJsp" id = "deleteBookJsp" method="post" action = "deleteMagazines">
            <div class="Magazine management-choices">
                <input type="submit" name="deleteBookBtn" id="deleteBookBtn" value="deleteMagazine"/>
            </div>
        </form>
    </body>
</html>
