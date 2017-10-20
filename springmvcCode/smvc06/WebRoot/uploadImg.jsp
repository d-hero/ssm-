<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'uploadImg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">    
    
    
    //图片上传预览    IE是用了滤镜。
    function previewImage(file) {
        var MAXWIDTH = 260;
        var MAXHEIGHT = 180;
        var div = document.getElementById('preview');
        if (file.files && file.files[0]) {
            div.style.display = "block";
            div.innerHTML = '<img id=imghead>';
            var img = document.getElementById('imghead');
            img.onload = function () {
                var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
                img.width = rect.width;
                img.height = rect.height;
                //img.style.marginLeft = rect.left+'px';
                img.style.marginTop = rect.top + 'px';
            }
            var reader = new FileReader();
            reader.onload = function (evt) { img.src = evt.target.result; }
            reader.readAsDataURL(file.files[0]);
        }
        else //兼容IE
        {
            div.style.display = "block";
            var sFilter = 'filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
            file.select();
            
              var img = document.getElementById('imghead');
           img.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale);"; 
           img.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = document.selection.createRange().text; 
           var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
                img.width = rect.width;
                img.height = rect.height;
            //var src = document.selection.createRange().text;
            //div.innerHTML = '<img id=imghead>';
            
            //img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
            //var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
            //status = ('rect:' + rect.top + ',' + rect.left + ',' + rect.width + ',' + rect.height);
            //div.innerHTML = "<div id=divhead style='width:" + rect.width + "px;height:" + rect.height + "px;margin-top:" + rect.top + "px;" + sFilter + src + "\"'></div>";
        }
    }
   
    function clacImgZoomParam(maxWidth, maxHeight, width, height) {
        var param = { top: 0, left: 0, width: width, height: height };
        if (width > maxWidth || height > maxHeight) {
            rateWidth = width / maxWidth;
            rateHeight = height / maxHeight;

            if (rateWidth > rateHeight) {
                param.width = maxWidth;
                param.height = Math.round(height / rateWidth);
            } else {
                param.width = Math.round(width / rateHeight);
                param.height = maxHeight;
            }
        }

        param.left = Math.round((maxWidth - param.width) / 2);
        param.top = Math.round((maxHeight - param.height) / 2);
        return param;
    }
</script> 
<style type="text/css">
    #preview { overflow:hidden; display:none;}
    #imghead { progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);}
</style>
  </head>
  
  <body>
  <form id="form1" enctype="multipart/form-data" method="post" action="IS">
    <div>
    <table class="tblDetail" border="0"  cellpadding="0" cellspacing="0">
   
    <tr>
        <th>菜单名：</th>
        <td>
            <input id="txtFoodName" name="txtFoodName" type="text" class="inputText"/>
        </td>
    </tr>
    <tr>
        <th>单价：</th>
        <td>
            <input id="txtPrice" name="txtPrice" type="text" class="inputText" />&nbsp;&nbsp;&nbsp;&nbsp;
        </td>
    </tr>
    <tr>
        <th>图片：</th>
        <td>
            <div><input id="fileImg" name="fileImg" onchange="previewImage(this)" type="file" /></div>
            <div id="preview">
                <img id="imghead" width=260  border=0 />
            </div> 
        </td>
    </tr>
   
    <tr>
        <th></th>
        <td>
            &nbsp;<input type="submit" value="提交">
        </td>
    </tr>
</table>
    </div>
    </form>
  </body>
</html>
