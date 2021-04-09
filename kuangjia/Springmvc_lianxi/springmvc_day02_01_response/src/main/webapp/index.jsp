


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>



<head>
    <script src="js/jquery.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(
                function () {
                    $.ajax({
                        url:"user/testajax",
                        contentType:"application/json;charset=utf-8",
                        data:'{"username":"小明","password":"123345","age":30}',
                        dataType:"json",
                        type:"post",
                        success:function (data) {
                            alert(data.username)
                            alert(data.toString())
                        }
                    })
                }
            )
        })
    </script>

</head>

<body>
<h2>Hello World!</h2>


<a href="user/testString">testString</a> <br>

<a href="user/testVoid">testVoid</a> <br>

<a href="user/testModelAndView">testModelAndView</a><br>
<a href="user/testForwardOrRedirect">testForwardOrRedirect</a><br>

<button id="btn">发送ajax的请求</button>




</body>
</html>
