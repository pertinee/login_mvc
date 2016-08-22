<%@ page contentType="text/html; charset=GBK"%>
<html>
  <head>
    <title>login</title>
  </head>
 
  <body>
   <script language="javaScript">
  	function validate(f){
		if(!(/^\w{6,18}$/.test(f.userid.value))){
			alert("用户ID必须是6-18位！");
			f.userid.focus();
			return false;
		}  
		if(!(/^\w{6,18}$/.test(f.password.value))){
			alert("密码必须是6-18位！");
			f.password.focus();
			return false;
		}
		return true;
  	}
  </script>
  <%
  request.setCharacterEncoding("GBK");
   %>
    <form action="TuserServlet" method="post" onsubmit="return validate(this)">
    	<table border="0">
    	<tr><td colspan="2"><br>用户登录程序</td></tr>
    	<tr><td>用户ID：</td><td><input type="text" name="userid"></td></tr>
    	<tr><td>密码：</td><td><input type="password" name="password"></td></tr>
    	<tr><td>验证码：</td><td><input type="text" name="code" size="4" maxlength="4"><img src="image.jsp"> </td></tr>
    	<tr><td colspan="2"><input type="submit" value="登录"><input type="reset" value="重置"> </td></tr>
    	</table>
    </form>
    <%
    if(request.getAttribute("err")!=null){
    %>
    <h3><%=request.getAttribute("err")%></h3>
    <% 
    }
    %>
  </body>
</html>
