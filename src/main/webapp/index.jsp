<%-- 
    Document   : index
    Created on : Mar 18, 2011, 11:43:57 AM
    Author     : alexey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<style type="text/css">
    .button1{
    width: 200px;
    height: 50px;
}
.input1{
       width: 150px;
       text-align: center;
}
</style>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JTest</title>
    </head>
    <body>
        <center>
        <h1>Welcome to JTest!</h1>
        <br>
        <img src="img/statisimg.jpg"/>
        <br>
        <input type="button" value="CPU low" class="button1" onclick="load('cpu', 100)"/>
        <input type="button" value="CPU middle" class="button1" onclick="load('cpu', 100000)"/>
        <input type="button" value="CPU hard" class="button1" onclick="load('cpu', 10000000)"/>
        <br><br>

        <input type="button" value="MEM low" class="button1" onclick="load('mem', 10000)"/>
        <input type="button" value="MEM middle" class="button1" onclick="load('mem', 1000000)"/>
        <input type="button" value="MEM OutOfMemory" class="button1" onclick="load('mem', 1000000000)"/>
        <br><br>

        <input type="button" value="NET low" class="button1" onclick="load('net', 1)"/>
        <input type="button" value="NET middle" class="button1" onclick="load('net', 3)"/>
        <input type="button" value="NET hard" class="button1" onclick="load('net', 5)"/>
        <br><br>
        </center>
        <script>
            function load(par, count){
                window.location='loader?' + par + '=1&count=' + count;
            }
        </script>

    </body>
</html>
