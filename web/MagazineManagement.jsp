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
        <hr>
         <form class="form-horizontal" name="addJsp" id = "addMagJsp" method="post" action = "addMagazines">
            <div class="Magazine management-choices">
                Title:<input type="text" name="addMagtitle" id="addMagtitle"  placeholder="title"/>
                <br>Summary:<br>
               <textarea cols="5" rows="3" name="addMagSummary" placeholder="summary here..."></textarea>
                <br>Price:<input type="text" name="addMagPrice" id="addMagPrice"  placeholder="P0.0"/>
                <br>Stock:<input type="text" name="addMagStock" id="addMagStock"  placeholder="0.0"/>
                <br>Status:<input type="text" name="addMagPstatus" id="addMagPstatus"  placeholder="1"/>
                <br>Vol:<input type="text" name="addMagVolumeNumber" id="addMagVolumeNumber"  placeholder="8"/>
                <br>Issue:<input type="text" name="addMagIssueNumber" id="addMagIssueNumber"  placeholder="88"/>
                <br><input type="submit" name="addMagBtn" id="addMagBtn" value="addMagazine"/>
            </div>
        </form>
        <hr>
        <form class="form-horizontal" name="editProductJsp" id = "editMagJsp" method="post" action = "editMagazines">
            <div class="Magazine management-choices">
                Title:<input type="text" name="editMagtitle" id="editMagtitle"  placeholder="title"/>
                <br>Summary:<br>
               <textarea cols="5" rows="3" name="editMagSummary" placeholder="summary here..."></textarea>
                <br>Price:<input type="text" name="editMagPrice" id="editMagPrice"  placeholder="P0.0"/>
                <br>Stock:<input type="text" name="editMagStock" id="editMagStock"  placeholder="0.0"/>
                <br>Status:<input type="text" name="editMagPstatus" id="editMagPstatus"  placeholder="1"/>
                <br>Vol:<input type="text" name="editMagVolumeNumber" id="editMagVolumeNumber"  placeholder="8"/>
                <br>Issue:<input type="text" name="editMagIssueNumber" id="editMagIssueNumber"  placeholder="88"/>
                <br><input type="submit" name="editMagBtn" id="editMagBtn" value="editMagazine"/>
                <input type="submit" name="editMagBtn" id="editMagBtn" value="editMagazine"/>
            </div>
        </form>
        <hr>
        <form class="form-horizontal" name="deleteProductJsp" id = "deleteMagJsp" method="post" action = "deleteMagazines">
            <div class="Magazine management-choices">
                Title:<input type="text" name="delMagtitle" id="delMagtitle"  placeholder="title"/>
                <br>Summary:<br>
               <textarea cols="5" rows="3" name="delMagSummary" placeholder="summary here..."></textarea>
                <br>Price:<input type="text" name="delMagPrice" id="delMagPrice"  placeholder="P0.0"/>
                <br>Stock:<input type="text" name="delMagStock" id="delMagStock"  placeholder="0.0"/>
                <br>Status:<input type="text" name="delMagPstatus" id="delMagPstatus"  placeholder="1"/>
                <br>Vol:<input type="text" name="delMagVolumeNumber" id="delMagVolumeNumber"  placeholder="8"/>
                <br>Issue:<input type="text" name="delMagIssueNumber" id="delMagIssueNumber"  placeholder="88"/>
                <br><input type="submit" name="delMagBtn" id="delMagBtn" value="delMagazine"/>
                <input type="submit" name="deleteMagBtn" id="deleteMagBtn" value="deleteMagazine"/>
            </div>
        </form>
        <hr>
    </body>
</html>
