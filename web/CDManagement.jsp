<%-- 
    Document   : CDManagement
    Created on : Dec 12, 2014, 9:07:41 PM
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
        <h1>Hello to CD management!</h1>
        <hr>
         <form class="form-horizontal" name="addJsp" id = "addCDJsp" method="post" action = "addCD">
            <div class="CD management-choices">
                Title:<input type="text" name="addCDtitle" id="addCDtitle"  placeholder="title"/>
                <br>Summary:<br>
               <textarea cols="5" rows="3" name="addCDSummary" placeholder="summary here..."></textarea>
                <br>Price:<input type="text" name="addCDPrice" id="addCDPrice"  placeholder="P0.0"/>
                <br>Stock:<input type="text" name="addCDStock" id="addCDStock"  placeholder="0.0"/>
                <br>Status:<input type="text" name="addCDPstatus" id="addCDPstatus"  placeholder="1"/>
                <br>Artist:<input type="text" name="addCDArtist" id="addCDArtist"  placeholder="pen smith"/>
                <br><input type="submit" name="addCDBtn" id="addCDBtn" value="addCD"/>
            </div>
        </form>
        <hr>
        <form class="form-horizontal" name="editProductJsp" id = "editCDJsp" method="post" action = "editCD">
            <div class="CD management-choices">
                Title:<input type="text" name="editCDtitle" id="editCDtitle"  placeholder="title"/>
                <br>Summary:<br>
               <textarea cols="5" rows="3" name="editCDSummary" placeholder="summary here..."></textarea>
                <br>Price:<input type="text" name="editCDPrice" id="editCDPrice"  placeholder="P0.0"/>
                <br>Stock:<input type="text" name="editCDStock" id="editCDStock"  placeholder="0.0"/>
                <br>Status:<input type="text" name="editCDPstatus" id="editCDPstatus"  placeholder="1"/>
                <br>Artist:<input type="text" name="editCDArtist" id="editCDArtist"  placeholder="pen smith"/>
                <br><input type="submit" name="editCDBtn" id="editCDBtn" value="editCD"/>
                <input type="submit" name="editCDBtn" id="editCDBtn" value="editCD"/>
            </div>
        </form>
        <hr>
        <form class="form-horizontal" name="deleteProductJsp" id = "deleteCDJsp" method="post" action = "deleteCD">
            <div class="CD management-choices">
                Title:<input type="text" name="delCDtitle" id="delCDtitle"  placeholder="title"/>
                <br>Summary:<br>
               <textarea cols="5" rows="3" name="delCDSummary" placeholder="summary here..."></textarea>
                <br>Price:<input type="text" name="delCDPrice" id="delCDPrice"  placeholder="P0.0"/>
                <br>Stock:<input type="text" name="delCDStock" id="delCDStock"  placeholder="0.0"/>
                <br>Status:<input type="text" name="delCDPstatus" id="delCDPstatus"  placeholder="1"/>
                <br>Artist:<input type="text" name="delCDArtist" id="delCDArtist"  placeholder="pen smith"/>
                <br><input type="submit" name="delCDBtn" id="delCDBtn" value="delCD"/>
                <input type="submit" name="deleteCDBtn" id="deleteCDBtn" value="deleteCD"/>
            </div>
        </form>
    </body>
</html>
