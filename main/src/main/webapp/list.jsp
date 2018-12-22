<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 - 首页</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<LINK rel=stylesheet type=text/css href="css/style.css">
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<style type="text/css">
   #fubu{
	float:right;
	margin-top:40px;
	font-size:14px
}
</style>
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<script type="text/javascript">
function  districtChange(){
	var did=$("#district>option:selected").val();
	 $.post("queryStreets",{"did":did},function(data){
		 var html = "<option value='0'>不限</option>";
			for(var i=0;i<data.length;i++){
				if(data[i].sid=="${map['sid']}"){
					html+="<option value='"+data[i].sid+"'selected>"+data[i].sname+"</option>";
				}else{
					html+="<option value='"+data[i].sid+"'>"+data[i].sname+"</option>";
				}	
			}
			$("#street").html(html);
		},"json");
}
function  isLogin(){
	 $.post("./UserServlet?method=islogin",function(data){
			if(data==false){
				alert("您还未登录，请先登录！");
				location.href="login.jsp";
			}else{
				location.href="HouseServlet?method=fubu";//HouseServlet?method=fubu
			}
		},"json");
}
$(function(){

	 //街道回显
	 districtChange();
}); 
</script>

<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="images/logo.gif">
</DIV>
<div id=fubu>
<span>欢迎${user.username}!</span>
<a href="guanli" style="cursor:pointer">房屋管理</a>
</div>
</DIV>
<DIV id=navbar class=wrap>
<DL class="search clearfix">
  <FORM id=sform method=post action="list">
  <DT>
  <UL>
    <LI class=bold>房屋信息</LI>
    <LI>标题：<INPUT class="text" type="text" name="topic" value="${map.topic}"/> 
    <LABEL class=ui-blue><INPUT  value="搜索房屋" type="submit" /></LABEL>
    </LI>
    </UL></DT>
   
  <DD>
  <UL>
    <LI class=first>区县</LI>
    <LI>
    <SELECT id=district name="did" onchange="districtChange()"> 
    <option value="0">不限</option>
    <c:forEach items="${dislist}" var="dis">
       <option value="${dis['did']}" <c:if test="${dis['did'] eq map['did']}">selected</c:if>>${dis['dname']}</option>   
    </c:forEach>
    </SELECT> 
    </LI></UL></DD>
  <DD>
  <UL>
    <LI class=first>街道</LI>
    <LI><SELECT id=street name="sid"> 
    <option value="0">不限</option>    
    </SELECT> </LI></UL></DD>
  <DD>
  <UL>
    <LI class=first>房型</LI>
    <LI>
    <SELECT id="type" name="htid"> 
    <option value="0">不限</option>  
    <c:forEach items="${tylist}" var="ty">
       <option value="${ty['htid']}" <c:if test="${ty['htid'] eq map.htid}">selected</c:if>>${ty['htname']}</option>   
    </c:forEach>
    </SELECT> 
  </LI></UL></DD>
  <DD>
  <UL>
    <LI class=first>价格 </LI>
    <LI><SELECT name=price> 
    <OPTION selected value="0-0">不限</OPTION> 
    <OPTION  value="1-1000" <c:if test="${'1-1000' eq map.price}">selected</c:if> >1000元以下</OPTION> 
    <OPTION value="1000-5000" <c:if test="${'1000-5000' eq map.price}">selected</c:if>>1000元—5000元</OPTION> 
    <OPTION value="5000-1000000" <c:if test="${'5000-1000000' eq map.price}">selected</c:if>>5000元以上</OPTION>
    </SELECT> 
      </LI>
      </UL>
      
      </DD>
  <DD>
  <UL>
    <LI class=first>面积 </LI>
    <LI><SELECT name=floorage> 
    <OPTION selected value="0-0">不限</OPTION> 
    <OPTION  value="1-80" <c:if test="${'1-80' eq map.floorage}">selected</c:if>>80以下</OPTION> 
    <OPTION value="80-200" <c:if test="${'80-200' eq map.floorage}">selected</c:if>>80-200</OPTION> 
    <OPTION value="200-1000000" <c:if test="${'200-1000000' eq map.floorage}">selected</c:if>>200以上</OPTION>
    </SELECT> </LI></UL>
      </DD>
      </FORM></DL></DIV>
<DIV class="main wrap">
<TABLE class=house-list>
  <TBODY>
  <c:choose>
  <c:when test="${not empty pg.getResult()}">
  <c:forEach items="${pg.getResult()}" var="alist">
  <TR>
    <TD class=house-thumb><span><A href="details.htm" target="_blank"><img src="images/thumb_house.gif" width="100" height="75" alt=""></a></span></TD>
    <TD>
      <DL>
        <DT><A href="details.jsp" target="_blank">${alist['topic']}</A></DT>
        <DD>${alist.district.dname}${alist.street.sname},${alist['area']}平米<BR>联系方式：${alist.user.phone} </DD></DL></TD>
    <TD class=house-type>${alist.type.htname}</TD>
    <TD class=house-price><SPAN>${alist.price}</SPAN>元/月</TD>
  </TR>
  </c:forEach>
  </c:when>
  
  <c:otherwise>
  <TR>无租房信息</TR>
  </c:otherwise>
  
  </c:choose>
  </TBODY>
  </TABLE>
<c:if test="${not empty pg.getResult()}">
<DIV class=pager>
<UL>
  <LI class=current><A href="list?pageIndex=1&topic=${map.topic}&htid=${map.htid}&did=${map.did}&sid=${map.sid}&price=${map.price}&floorage=${map.floorage}">首页</A></LI>
  <LI><A href="list?pageIndex=${pg.getPageNum()-1}&topic=${map.topic}&htid=${map.htid}&did=${map.did}&sid=${map.sid}&price=${map.price}&floorage=${map.floorage}">上一页</A></LI>
  <LI><A href="list?pageIndex=${pg.getPageNum()+1}&topic=${map.topic}&htid=${map.htid}&did=${map.did}&sid=${map.sid}&price=${map.price}&floorage=${map.floorage}">下一页</A></LI>
  <LI><A href="list?pageIndex=${pg.getPages()}&topic=${map.topic}&htid=${map.htid}&did=${map.did}&sid=${map.sid}&price=${map.price}&floorage=${map.floorage}">末页</A></LI></UL><SPAN 
class=total>${pg.getPageNum()}/${pg.getPages()}页</SPAN> </DIV>
</c:if>
</DIV>

<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2010 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
