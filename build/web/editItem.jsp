<%-- 
    Document   : editItem
    Created on : Mar 20, 2014, 10:09:05 AM
    Author     : Jordan Jensen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<!-- start content -->
	<div id="content">
		<div class="post">
			<div class="title">
				<h2>Add Recipe</h2>				
			</div>
                    <div class="entry">
                        <form action="" method="get">
                            Recipe Name: <input type="text" name="recipe">
                             <input type="submit" value="Get It!" >
                        </form>
                        
                    </div>
			<div class="entry">
                            <form action="" method="POST">
                                <b>Name of Recipe:</b><input type="text" name="name"><br/>
                                <b>List of Ingredients:</b><br/><textarea rows="20" cols="100"></textarea><br/>
                                <b>List of Directions:</b><br/><textarea rows="20" cols="100"></textarea><br/>
                                <input type="submit" value="Edit!" >
                            </form>
			</div>
		</div>
	</div>
	<!-- end content -->

<%@ include file="sidebar.jsp" %>
<%@ include file="footer.js" %>