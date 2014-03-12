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
            <a href="index.htm">Home</a>
        </li>
	<li class="current_page_item" style="z-index: 10">
            <a href="index.htm">Add</a>
        </li>
        <li class="current_page_item" style="z-index: 10">
            <a href="index.htm">Find</a>
        </li>
        <li class="current_page_item" style="z-index: 10">
            <a href="index.htm">Randomize</a>
        </li>       
    </ul>
    <form action="search" method="get" style="vertical-align: middle; line-height: 25px; 
          margin: 0px; padding: 0px; float: right; position: 15px; margin-top: 14px; margin-right: 10px;">
        <input type="text" name="query" id="query" size="40" value="">
        <input type="submit" value="Search">
        <input type="hidden" name="search" value="1">
    </form>
</div>
<!-- end menu -->
<!-- start page -->
<div id="page">
