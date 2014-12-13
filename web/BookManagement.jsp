<%-- 
    Document   : BookManagement
    Created on : Dec 12, 2014, 8:36:21 PM
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
   <h1>Hello to Book management!</h1>
        <hr>
         <form class="form-horizontal" name="addJsp" id = "addBookJsp" method="post" action = "addBook">
            <div class="Book management-choices">
                Title:<input type="text" name="addBooktitle" id="addBooktitle"  placeholder="title"/>
                <br>Summary:<br>
               <textarea cols="5" rows="3" name="addBookSummary" placeholder="summary here..."></textarea>
                <br>Price:<input type="text" name="addBookPrice" id="addBookPrice"  placeholder="P0.0"/>
                <br>Stock:<input type="text" name="addBookStock" id="addBookStock"  placeholder="0.0"/>
                <br>Status:<input type="text" name="addBookPstatus" id="addBookPstatus"  placeholder="1"/>
                <br>Author:<input type="text" name="addBookAuthor" id="addBookAuthor"  placeholder="pen smith"/>
                <br><input type="submit" name="addBookBtn" id="addBookBtn" value="addBook"/>
            </div>
        </form>
        <hr>
        <form class="form-horizontal" name="editProductJsp" id = "editBookJsp" method="post" action = "editBook">
            <div class="Book management-choices">
                Title:<input type="text" name="editBooktitle" id="editBooktitle"  placeholder="title"/>
                <br>Summary:<br>
               <textarea cols="5" rows="3" name="editBookSummary" placeholder="summary here..."></textarea>
                <br>Price:<input type="text" name="editBookPrice" id="editBookPrice"  placeholder="P0.0"/>
                <br>Stock:<input type="text" name="editBookStock" id="editBookStock"  placeholder="0.0"/>
                <br>Status:<input type="text" name="editBookPstatus" id="editBookPstatus"  placeholder="1"/>
                <br>Author:<input type="text" name="editBookAuthor" id="editBookAuthor"  placeholder="pen smith"/>
                <br><input type="submit" name="editBookBtn" id="editBookBtn" value="editBook"/>
            </div>
        </form>
        <hr>
        <form class="form-horizontal" name="deleteProductJsp" id = "deleteBookJsp" method="post" action = "deleteBook">
            <div class="Book management-choices">
                Title:<input type="text" name="delBooktitle" id="delBooktitle"  placeholder="title"/>
                <br>Summary:<br>
               <textarea cols="5" rows="3" name="delBookSummary" placeholder="summary here..."></textarea>
                <br>Price:<input type="text" name="delBookPrice" id="delBookPrice"  placeholder="P0.0"/>
                <br>Stock:<input type="text" name="delBookStock" id="delBookStock"  placeholder="0.0"/>
                <br>Status:<input type="text" name="delBookPstatus" id="delBookPstatus"  placeholder="1"/>
                <br>Author:<input type="text" name="delBookAuthor" id="delBookAuthor"  placeholder="pen smith"/>
                <br><input type="submit" name="delBookBtn" id="delBookBtn" value="delBook"/>
            </div>
        </form>
    </body>
</html>
