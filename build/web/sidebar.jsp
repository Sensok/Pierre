<%-- 
    Document   : sidebar
    Created on : Mar 12, 2014, 8:25:16 AM
    Author     : Adam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- start sidebar -->
<div id="sidebar">
    <ul>
	<li id="categories">
            <h2>Quick Recipes</h2>
            
            <ul>
                <li>
                    <form name="strTemp" method="POST" action="Page">
                    <input type="hidden" name="name" value="https://dl.dropboxusercontent.com/1/view/5z05rdwfuhig8vi/MiniPierre/Recipes/Jordan%27s%20Goulash.txt">
                    <a href="javascript:document.forms[1].submit()">Jordan's Goulash</a>
                    </form>
                </li>
                <li>
                    <form name="strTemp" method="POST" action="Page">
                    <input type="hidden" name="name" value="https://dl.dropboxusercontent.com/1/view/uephi6mzgt96tqn/MiniPierre/Recipes/Pizza.txt">
                    <a href="javascript:document.forms[2].submit()">Pizza</a>
                </form>
                </li>
                <li>
                    <form name="strTemp" method="POST" action="Page">
                    <input type="hidden" name="name" value="https://dl.dropboxusercontent.com/1/view/422xeo50j06g5u1/MiniPierre/Recipes/Ice%20Cream.txt">
                    <a href="javascript:document.forms[3].submit()">Ice Cream</a>
                    </form>
                </li>                                
                <li>
                    <form name="strTemp" method="POST" action="Page">
                    <input type="hidden" name="name" value="https://dl.dropboxusercontent.com/1/view/9umojorcx80n0g6/MiniPierre/Recipes/Apple%20Pie.txt">
                    <a href="javascript:document.forms[4].submit()">Apple Pie</a>
                    </form>
                </li>                
            </ul>
        </li>
	<li id="calendar">
            <div id="calendar_wrap">
                <p id="blockquote">"After a good dinner one can forgive anybody, even one's own relations."<br />-Oscar Wilde</p>					
            </div>
	</li>
    </ul>
</div>
<!-- end sidebar -->
