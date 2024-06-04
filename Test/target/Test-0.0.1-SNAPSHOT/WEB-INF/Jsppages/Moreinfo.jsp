<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form>
<table align="center">
<tr><td><a href="listproducts.html">Back</a></td></tr>
<c:forEach items="${list}" var="var1" >

<tr><td>
                                <img width="150" height="200" src="getmoreimage.html?pid=${var1.pid}">                               
                                
                                <input type="hidden" name="pid" value="${var1.getPid()}"/>                                                          
                               <tr><td>Name:</td><td><p class="name">${var1.getName()}</p></td></tr>
                               <tr><td>Width(cm):</td><td><p class="width">${var1.getWidth()}</p></td></tr>
                               <tr><td>Height(cm):</td><td><p class="height">${var1.getHeight()}</p></td></tr>
                               <tr><td>Weight(gm):</td><td><p class="weight">${var1.getWeight()}</p></td></tr>
                               <tr><td>Price(Rs):</td><td><p class="price">${var1.getPrice()}</p></td></tr>
                               <tr><td>Quantity:</td><td><p class="quantity">${var1.getQuantity()}</p></td></tr>
                               <tr><td>Shipping fee(Rs):</td><td><p class="shippingfee">${var1.getShippingfee()}</p></td></tr>
                               
                                
                        
</td></tr>

</c:forEach>                    
</table>
</form>

</body>
</html>