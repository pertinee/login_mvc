<%@ page contentType="text/html; charset=GBK"%>
<html>
  <head>
    <title>login</title>
  </head>
 
  <body>
   <script language="javaScript">
  	function validate(f){
		if(!(/^\w{6,18}$/.test(f.userid.value))){
			alert("�û�ID������6-18λ��");
			f.userid.focus();
			return false;
		}  
		if(!(/^\w{6,18}$/.test(f.password.value))){
			alert("���������6-18λ��");
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
    	<tr><td colspan="2"><br>�û���¼����</td></tr>
    	<tr><td>�û�ID��</td><td><input type="text" name="userid"></td></tr>
    	<tr><td>���룺</td><td><input type="password" name="password"></td></tr>
    	<tr><td>��֤�룺</td><td><input type="text" name="code" size="4" maxlength="4"><img src="image.jsp"> </td></tr>
    	<tr><td colspan="2"><input type="submit" value="��¼"><input type="reset" value="����"> </td></tr>
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
