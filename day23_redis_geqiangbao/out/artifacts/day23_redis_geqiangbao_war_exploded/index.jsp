<%--
  Created by IntelliJ IDEA.
  User: xiaobao
  Date: 2020-04-07
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>

<script src="js/jquery-3.3.1.min.js"></script>
<script>
    $(function () {
        $.get("provinceServlet", {}, function (data) {
            alert("1212");
            console.log(data);
            console.log(this);
            var select = $("#provinceSelect");
            $(data).each(function (index,element) {
                select.append("<option>" + element.name + "</option>");
            })
        })
    })

</script>

<body>

<select id="provinceSelect">
    <option>请选择省份234</option>
</select>

</body>
</html>
