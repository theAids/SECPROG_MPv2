<%-- 
    Document   : DVDManagement
    Created on : Dec 12, 2014, 9:51:30 PM
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
  <h1>Hello to DVD management!</h1>
        <hr>
         <form class="form-horizontal" name="addJsp" id = "addDVDJsp" method="post" action = "addDVD">
            <div class="DVD management-choices">
                Title:<input type="text" name="addDVDtitle" id="addDVDtitle"  placeholder="title"/>
                <br>Summary:<br>
               <textarea cols="5" rows="3" name="addDVDSummary" placeholder="summary here..."></textarea>
                <br>Price:<input type="text" name="addDVDPrice" id="addDVDPrice"  placeholder="P0.0"/>
                <br>Stock:<input type="text" name="addDVDStock" id="addDVDStock"  placeholder="0.0"/>
                <br>Status:<input type="text" name="addDVDPstatus" id="addDVDPstatus"  placeholder="1"/>
                <br>Director:<input type="text" name="addDVDDirector" id="addDVDDirector"  placeholder="pen smith"/>
                <br><input type="submit" name="addDVDBtn" id="addDVDBtn" value="addDVD"/>
            </div>
        </form>
        <hr>
        <form class="form-horizontal" name="editProductJsp" id = "editDVDJsp" method="post" action = "editDVD">
            <div class="DVD management-choices">
                 Title:<input type="text" name="origDVDtitle" id="origDVDtitle"  placeholder="title"/>
                Title:<input type="text" name="editDVDtitle" id="editDVDtitle"  placeholder="edited title"/>
                <br>Summary:<br>
               <textarea cols="5" rows="3" name="editDVDSummary" placeholder="summary here..."></textarea>
                <br>Price:<input type="text" name="editDVDPrice" id="editDVDPrice"  placeholder="P0.0"/>
                <br>Stock:<input type="text" name="editDVDStock" id="editDVDStock"  placeholder="0.0"/>
                <br>Status:<input type="text" name="editDVDPstatus" id="editDVDPstatus"  placeholder="1"/>
                <br>Director:<input type="text" name="editDVDDirector" id="editDVDDirector"  placeholder="pen smith"/>
                <br><input type="submit" name="editDVDBtn" id="editDVDBtn" value="editDVD"/>
                <input type="submit" name="editDVDBtn" id="editDVDBtn" value="editDVD"/>
            </div>
        </form>
        <hr>
        <form class="form-horizontal" name="deleteProductJsp" id = "deleteDVDJsp" method="post" action = "deleteDVD">
            <div class="DVD management-choices">
                Title:<input type="text" name="delDVDtitle" id="delDVDtitle"  placeholder="title"/>
                <br>Summary:<br>
               <textarea cols="5" rows="3" name="delDVDSummary" placeholder="summary here..."></textarea>
                <br>Price:<input type="text" name="delDVDPrice" id="delDVDPrice"  placeholder="P0.0"/>
                <br>Stock:<input type="text" name="delDVDStock" id="delDVDStock"  placeholder="0.0"/>
                <br>Status:<input type="text" name="delDVDPstatus" id="delDVDPstatus"  placeholder="1"/>
                <br>Director:<input type="text" name="delDVDDirector" id="delDVDDirector"  placeholder="pen smith"/>
                <br><input type="submit" name="delDVDBtn" id="delDVDBtn" value="delDVD"/>
                <input type="submit" name="deleteDVDBtn" id="deleteDVDBtn" value="deleteDVD"/>
            </div>
        </form>
    </body>
</html>
