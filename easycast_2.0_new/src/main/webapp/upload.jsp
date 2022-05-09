<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>文件上传</title>
  </head>
  
  <body>
    <form action="/UploadHandleServlet" enctype="multipart/form-data" method="post">
                      文件上传到 upload目录下:<br/>
                      上传用户：   <input type="text" name="username"><br/>
                      上传文件1(图片,zip文件-不需要解压)：<input type="file" name="file1"><br/>
                      上传文件2(zip文件-需要解压成h5)：<input type="file" name="file2"><br/>
              <input type="submit" value="提交">
    </form>
  </body>
</html>