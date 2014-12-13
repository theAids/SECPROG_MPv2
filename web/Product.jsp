<%-- 
    Document   : Homepage
    Created on : Nov 9, 2014, 8:43:36 PM
    Author     : aids
--%>

<%@page import="Security.AccessController"%>
<%@page import="Bean.OrderingBean"%>
<%@page import="Bean.OrderBean"%>
<%@page import="DAO.Implementation.OrderingImplementation"%>
<%@page import="DAO.Interface.OrderingInterface"%>
<%@page import="DAO.Implementation.OrderImplementation"%>
<%@page import="DAO.Interface.OrderInterface"%>
<%@page import="Bean.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bean.CustomerBean"%>
<%@page import="Bean.UserBean"%>
<%@page import="DAO.Implementation.UserDAOImplementation"%>
<%@page import="DAO.Interface.UserDAOInterface"%>
<%@page import="DAO.Interface.UserDAOInterface"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Foobar</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="scss/stylesheets/screen.css" rel="stylesheet">



    </head>

    <%
        UserDAOInterface userIM = new UserDAOImplementation();
        OrderInterface orderIM = new OrderImplementation();
        OrderingInterface orderingIM = new OrderingImplementation();
        ArrayList<Integer> itemsBought;
        ArrayList<OrderBean> customerOrders;
        ArrayList<OrderingBean> orderProducts;

        ProductBean product = (ProductBean) session.getAttribute("product");

        UserBean user = (UserBean) session.getAttribute("client_user");
        //UserBean user = userIM.getUser("eyjaneh_");
        AccessController acl = (AccessController) session.getAttribute("acl");

        
         if (user == null) {
         response.sendRedirect("Unauthorized.jsp");
         return;
         }
        boolean isCustomer = false;
        boolean isBought = false;

        CustomerBean c = null;

        String type = userIM.getUserType(user);

        if (type.equals("Customer")) {
            isCustomer = true;
            c = userIM.getCustomer(user.getUsername());
            itemsBought = new ArrayList<Integer>();
            customerOrders = orderIM.getCustomerOrder(user.getUserID());

            for (OrderBean orb : customerOrders) {
                orderProducts = new ArrayList<OrderingBean>();
                orderProducts = orderingIM.getOrderByIDProducts(orb.getOrderID());
                for (OrderingBean ord : orderProducts) {
                    if (!itemsBought.contains(ord.getProductID())) {
                        itemsBought.add(ord.getProductID());
                    }

                    /*AIDS: NOTE PAKI-FILLUP NA LANG 'YUNG VARIABLE FOR THE PRODUCT */
                    if (product.getProductID() == ord.getProductID()) {
                        isBought = true;
                    }

                }
            }
            //System.out.println(c.getbAddress());
        }

        //System.out.println("NOT A CUSTOMER");

    %>
    <body>

        <nav class="navbar navbar-inverse navbar-static-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Foobar Bookshop</a>
                </div>

                <div  class="navbar-collapse collapse" >
                    <ul class="nav navbar-nav navbar-right menubar">
                        <li><a href="#">Store</a></li>
                        <li><a href="#">Settings</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Aids</a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                            </ul>
                        </li>
                    </ul>       
                </div>
            </div>
        </nav>

        <div class="container">
            <div class="jumbotron pDetails">
                <h3><%=product.getTitle()%></h3>
                <h4>Author: </h4>
                <p> author name</p><br>
                <h4>Price: </h4>
                <p><%=product.getPrice()%>php</p><br><br>
                <h4>Description</h4><br>
                <p><%=product.getSummary()%></p>

                <br>
                <br>
                <hr>
                <label>Quantity:</label>
                <input type="number" value="0" style="width: max-content"/>
                <button onclick="buy()">Buy</button>
                <div></div>
                <label>Review</label>
                <div id ="reviewArea">
                    <span id="rmessage"></span>
                    <div id="reviewer">

                        <form id="reviewForm" name="reviewForm" method="post" action="review">
                            <input type="hidden" id="userID" name="userID">
                            <input type="hidden" id="productID" name="productID">
                            <textarea id ="review" name ="review" class="form-control" rows="3"></textarea>
                            <div>&nbsp;</div>
                            <div class="col-md-3 col-md-offset-9">
                                <button id ="reviewbtn"type ="submit" class="btn btn-success btn-block">Review</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>



        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery-1.10.min.js"></script>

        <script>

                    function buy() {
                        window.location = "Creditcard.jsp";
                    }
                    $(document).ready(function () {
                        $("#userID").val("<%= user.getUserID()%>");
                        /*NOTE: */
                        $("#productID").val("<%= user.getUserID()%>"); //pakiFILL UP
            <% if (isBought) { %>
                        //do nothing... as is
            <%} else {%>
                        $("#rmessage").text("YOU HAVE NOT BOUGHT THIS PRODUCT. YOU CANNOT REVIEW THIS PRODUCT WITHOUT BUYING IT");
                        $("#reviewer").hide();

            <%}%>

                        alert("HEY");

                    });

                   
        </script>
        <!-- Placed at the end of the document so the pages load faster -->


    </body>
</html>

