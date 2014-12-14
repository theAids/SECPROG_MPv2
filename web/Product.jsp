<%-- 
    Document   : Homepage
    Created on : Nov 9, 2014, 8:43:36 PM
    Author     : aids
--%>

<%@page import="Bean.CDBean"%>
<%@page import="Bean.DvdBean"%>
<%@page import="Bean.MagBean"%>
<%@page import="Bean.BookBean"%>
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

        String token = (String) session.getAttribute("client_token");
        UserBean user;

        if (token != null) {
            user = (UserBean) session.getAttribute("client_user");
        } else {
            user = new UserBean();
        }

        //UserBean user = (UserBean) session.getAttribute("client_user");
        //UserBean user = userIM.getUser("eyjaneh_");
        AccessController acl = (AccessController) session.getAttribute("acl");

        if (token == null) {
            response.sendRedirect("Unauthorized.jsp");
            return;
        }

        ProductBean product = (ProductBean) session.getAttribute("product");
        BookBean book = new BookBean();
        MagBean magazine = new MagBean();
        DvdBean dvd = new DvdBean();
        CDBean cd = new CDBean();

        String category = product.getCategory();

        if (category.equals("book")) {
            book = (BookBean) session.getAttribute("book");

        } else if (category.equals("magazine")) {
            magazine = (MagBean) session.getAttribute("magazine");

        } else if (category.equals("dvd")) {
            dvd = (DvdBean) session.getAttribute("dvd");

        } else if (category.equals("cd")) {
            cd = (CDBean) session.getAttribute("cd");

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

                    if (product.getProductID() == ord.getProductID()) {
                        isBought = true;
                    }

                }
            }
            //System.out.println(c.getbAddress());
        }

                //System.out.println("NOT A CUSTOMER");*/

    %>
    <body>

        <nav class="navbar navbar-inverse navbar-static-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Foobar Bookshop</a>
                </div>

                <div  class="navbar-collapse collapse" >
                    <ul class="nav navbar-nav navbar-right menubar">
                        <li><a href="SearchPage.jsp">Search</a></li>
                        <li><a href="Cart.jsp">Cart</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><%=user.getUsername()%></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">Transactions</a></li>
                                <li><a href="#">Logout</a></li>
                            </ul>
                        </li>
                    </ul>       
                </div>
            </div>
        </nav>

        <div class="container">
            <div class="jumbotron pDetails">
                <h3><%=product.getTitle()%></h3>
                <h4 name="person">Author: </h4>
                <p name="person_name"> author name</p><br>
                <h4 name="volume" style="display: none">Volume no: </h4>
                <p name="volume_no" style="display: none"></p><br>
                <h4 name="issue" style="display: none">Issue no: </h4>
                <p name="issue_no" style="display: none"></p><br>
                <h4>Price: </h4>
                <p><%=product.getPrice()%>php</p><br><br>
                <h4>Description</h4><br>
                <p><%=product.getSummary()%></p>

                <br>
                <br>
                <hr>
                <div id="warning"></div>
                <form id="addCart" method="POST" action="addtoCart" style="display:inline">
                    <label>Quantity:</label>
                    <input type="number" value="1" min="1" name="quantity"/>
                    <input type="submit" value="Add to Cart" class="btn btn-primary"/>

                </form>
                <a href="SearchPage.jsp" class="btn btn-success " style="display: inline">Back</a>

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

            $("#addCart").submit(function (event) {
                var q = $('[name=quantity]').val();
                if(q > <%=product.getStock()%>){
                    $("#warning").text("Quantity is out of range").css({"font-style":"italic","color":"red"});
                    event.preventDefault();
                }
            });

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



            <%  if (category.equals("book")) {%>
                $('[name=person]').text("Author");
                $('[name=person_name]').text("<%=book.getAuthor()%>");
            <%  } else if (category.equals("magazine")) {%>
                $('[name=person]').css("display", "none");
                $('[name=person_name]').css("display", "none");
                $('[name=volume]').css("display", "inline");
                $('[name=volume_no]').css("display", "inline").text("<%=magazine.getVolNo()%>");
                $('[name=issue]').css("display", "inline");
                $('[name=issue_no]').css("display", "inline").text("<%=magazine.getIssueNo()%>");

            <%   } else if (category.equals("dvd")) {%>
                $('[name=person]').text("Director");
                $('[name=person_name]').text("<%=dvd.getDirector()%>");

            <%   } else if (category.equals("magazine")) {%>
                $('[name=person]').text("Artist");
                $('[name=person_name]').text("<%=cd.getArtist()%>");

            <%   }%>


            });
        </script>
        <!-- Placed at the end of the document so the pages load faster -->


    </body>
</html>

