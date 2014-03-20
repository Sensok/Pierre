<%-- 
    Document   : menu
    Created on : Mar 12, 2014, 8:24:38 AM
    Author     : Adam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- start menu -->
<div id="menu">
    <ul>
        <li class="current_page_item" style="z-index: 10">
            <a href="index.jsp">Home</a>
        </li>
	<li class="current_page_item" style="z-index: 10">
            <a href="addItem.jsp">Add</a>
        </li>
        <li class="current_page_item" style="z-index: 10">
            <a href="editItem.jsp">Edit</a>
        </li>
        <li class="current_page_item" style="z-index: 10">
            <a href="Randomize">Randomize</a>
        </li>       
    </ul>
    <form action="search" method="post" style="vertical-align: middle; line-height: 25px; 
          margin: 0px; padding: 0px; float: right; position: 15px; margin-top: 14px; margin-right: 10px;">
        <input type="text" name="query" id="query" size="40" value="">
        <input type="submit" value="Search">
        <input type="hidden" name="search" value="1">
    </form>
</div>
<!-- end menu -->
<!-- start page -->
<div id="page">
