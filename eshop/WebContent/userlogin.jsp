<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"  %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
<title>网上商城</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body bgcolor="#FFFFFF" text="#000000" topmargin="2">
<table width="760" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr> 
    <td background="images/topback.gif" width="130"><img src="images/sitelogo.gif" height="88"></td>
    <td background="images/topback.gif" width="500" align="center" valign="middle"><a href="http://www.fans8.com" target="_blank"><img src="images/fans8.gif" width="468" height="60" border="0"></a> 
    </td>
    <td background="images/topback.gif" width="130"> 
	<table width="100%" border="0" cellspacing="2" cellpadding="2">
        <tr> 
          <td valign="middle" align="center"><a href="cart.asp"><img src="images/button_cart.gif" width="87" height="18" border="0"></a></td>
        </tr>
        <tr> 
          <td valign="middle" align="center"><a href="checkorder_login.asp"><img src="images/button_ddcx.gif" width="87" height="18" border="0"></a></td>
        </tr>
        <tr> 
          
    <td valign="middle" align="center"><a href="customer_register.asp"><img src="images/button_regist.gif" width="87" height="18" border="0"></a></td>
        </tr>
      </table>
      </td>
  </tr>
</table>
<table width="760" border="0" cellspacing="1" cellpadding="0" align="center" bgcolor="#000000">
  <tr> 
    <td bgcolor="#FF9900" height="22" valign="middle" align="center">
    <table width="80%" border="0" cellspacing="2" cellpadding="2">
          <tr align="center" valign="middle"> 
            <td><a href="newproduct.asp" class="white">新品快递</a></td>
            
    <td><a href="commend.asp" class="white">重点推荐</a></td>
            
    <td><a href="bestsell.asp" class="white">销售排行</a></td>
            
    <td><a href="bestprice.asp" class="white">特价商品</a></td>
          </tr>
        </table>
        </td>
  </tr>
  <tr> 
    <td bgcolor="#FFCC66" height="22"> 
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td>　<a href="default.asp">首页</a> &gt; <a href="cart.jsp">购物车</a> &gt; 
            去收银台登录</td>
          <td>&nbsp;</td>
        </tr>
      </table>
    </td>
  </tr>
</table>
<table width="760" border="0" cellspacing="1" cellpadding="0" align="center" bgcolor="#000000">
  <tr> 
    <td bgcolor="#FFFFFF"> 
      <p>　　　<img src="images/userlogin.gif" width="190" height="30"></p>
      <form name="form1" method="post" action="">
        <table width="500" border="0" cellspacing="3" cellpadding="3" align="center">
          <tr> 
            <td width="143" class="productName" align="right" valign="middle">Email：</td>
            <td width="336"> 
              <input type="text" name="useremail">
            </td>
          </tr>
          <tr> 
            <td width="143" class="productName" align="right" valign="middle">密　码：</td>
            <td width="336"> 
              <input type="password" name="userpass">
            </td>
          </tr>
          <tr align="center" valign="middle"> 
            <td colspan="2"> 
              <input type="submit" value="提交">
              　 
              <input type="submit" value="清除">
            </td>
          </tr>
        </table>
        <p align="center" class="productName"><a href="customer_register.jsp" target="_blank">如果你是新用户，请点击这里注册！</a></p>
      </form>
      <p>&nbsp;</p>
    </td>
  </tr>
</table>
<br>

<table width="760" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr> 
    <td background="images/topback.gif" align="center" height="16"><font color="#FFFFFF">copyright 
      2001 Powered by Peter.HJ</font></td>
  </tr>
</table>
</body>
</html>
