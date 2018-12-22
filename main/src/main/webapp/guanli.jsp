<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %> --%>
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD>
<TITLE>青鸟租房 - 用户管理</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="css/style.css">
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
function  isLogin(){
	 $.post("./UserServlet?method=islogin",function(data){
			if(data==false){
				alert("您还未登录，请先登录！");
				location.href="login.jsp";
			}else{
				location.href="HouseServlet?method=fubuHouse";//HouseServlet?method=fubu
			}
		},"json");
}
</script>
<META name=GENERATOR ></HEAD>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="images/logo.gif"></DIV>
<DIV class=search><LABEL class="ui-green searchs"><a onclick="isLogin()" style="cursor:pointer" title="">发布房屋信息</a></LABEL> 
<LABEL class=ui-green><INPUT onclick='document.location="index.jsp"' value="退       出" type=button name=search></LABEL> 
</DIV></DIV>
<DIV class="main wrap">
<DIV id=houseArea>
<TABLE class=house-list>
  <TBODY>
  <c:forEach items="${page.getResult()}" var="ulst">
  <TR>
    <TD class=house-thumb><SPAN><A href="details.htm" target="_blank"><img src="images/thumb_house.gif" width="100" height="75" alt=""></A></SPAN></TD>
    <TD>
      <DL>
        <DT><A href="details.htm" target="_blank">${ulst['topic']}</A></DT>
        <DD>
        ${ulst.district.dname}${ulst.street.sname},${ulst['area']}平米<BR>联系方式：${ulst.user.phone} 
        <input type="hidden" value="${ulst['hmid']}">
        </DD></DL></TD>
    <TD class=house-type><LABEL class=ui-green><INPUT onclick=update(46) value="修    改" type=button name=search></LABEL></TD>
    <TD class=house-price><LABEL class=ui-green><INPUT value="删    除" type=button name=search></LABEL></TD>
    </TR>
    </c:forEach>
  </TBODY></TABLE></DIV>
<DIV class=pager>
<UL>
  <LI class=current><A href="guanli?pageIndex=1">首页</A></LI>
  <LI><A href="guanli?pageIndex=${page.getPageNum()-1}">上一页</A></LI>
  <LI><A href="guanli?pageIndex=${page.getPageNum()+1}">下一页</A></LI>
  <LI><A href="guanli?pageIndex=${page.getPages()}">末页</A></LI></UL><SPAN 
class=total>${page.getPageNum()}/${page.getPages()}页</SPAN> </DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2010 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
