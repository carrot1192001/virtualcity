<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
<style type="text/css">
body{
 color : #000 ;
 font-size : 12px ;

 margin : 0px auto ;
 }

</style>

<script type="text/javascript">
    function check(form){
    //document.forms.form1.username.valueȡ��form1��Username��ֵ ���ж��Ƿ�Ϊ��
        if(document.forms.form1.username.value==""){
        //��� Ϊ""�򵯳���ʾ
            alert("pls input username");
            //�����뽹�㶨λ��û������ĵط�
            document.forms.form1.username.focus();
            //���ش���
            return false;
        }
                if(document.forms.form1.password.value==""){
            alert("pls input password");
            document.forms.form1.password.focus();
            return false;
        }
    }

</script>
</head>
<body>
<form action="LoginServlet" method="post" name="form1">
    
    
<table border="1" cellspacing="1" cellpadding="1"  bordercolor="silver" align="center">
   <tr>
      <td colspan="2" align="center" bgcolor="#e8e8e8">�û���½</td>
   </tr>
   <tr>
      <td>�û�����</td>
      <td><input type="text" name="username"/></td>
   </tr>
   <tr>
      <td>���룺</td>
      <td><input type="password" name="password"/></td>
   </tr>
   <tr>
      <td><a href="rsg.jsp" >���û�ע��</a></td>
      <!-- onclick="return check(this) ���������Script������֤ -->
      <td><input type="submit" name="submit" onclick="return check(this);"/><input type="reset" name="reset"/></td>
   </tr>
</table>

</form>
</body>
</html>