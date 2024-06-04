<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
       <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<body>
<form action="Moreinfo.html">
<table>
<td><a href="back2.html">Back</a> </td>
<c:forEach items="${list}" var="var1" >

<div class="row">
<tr>

                      <div class="col-lg-4">
                        <div class="blog-item">
                            <div class="blog-img">
                                <td><img width="100" height="100" src="getimage.html?pid=${var1.pid}"></td>
                                <td>
                                <input type="hidden" name="pid" value="${var1.getPid()}"/>
                                <p class="name">${var1.getName()}</p>
                                <p class="price">${var1.getPrice()}Rs</p>
                                <p class="Description">${var1.getDescription()}</p>
                                
                                <td><a href="more.html?pid=${var1.pid}">More</a></td>
                                </td>                    
                        </div>
                    </div>
                    </div>
</tr>
   </div>
</c:forEach>  
                  
</table>
</form>
</body>
</html>