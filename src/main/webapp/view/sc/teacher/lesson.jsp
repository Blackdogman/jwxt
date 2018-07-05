<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>课程表</title>
    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
            background: #ffffff;
        }

        table {
            margin: 10px;
            width: 600px;
            height: 400px;
            border-left: 1px solid #666666;
            border-bottom: 1px double #666666;
        }

        caption {
            border-right: 1px solid #666;
            border-top: 1px solid #666;
            border-left: 1px solid #666;
            padding: 10px 0 10px 0;
            background-color: #F5F5F5;
        }

        thead tr th {
            padding: 10px 0 10px 0;
            background-color: #90EE90;
            border-bottom: 1px double #000080;
        }

        tbody tr {
            text-align: center;

        }

        tfoot tr td {
            padding: 10px 0 10px 5px;
            background-color: #2E8B57;
            color: #ffffff;
        }

        th, td {
            border-right: 1px solid #666;
            border-top: 1px solid #666;
        }

        .firstcol {
            background-color: #F5F5F5;
        }

        .topline2px td {
            border-top: 2px double #2F4F4F;
        }

        .weekend {
            background-color: #FFB6C1;
        }
    </style>
</head>
<body>
<table border="0" cellspacing="0" cellpadding="0">
    <caption>2018学年</caption>
    <thead>
    <tr>
        <th style="background-color:#9ACD32;">节次</th>
        <th>星期一</th>
        <th>星期二</th>
        <th>星期三</th>
        <th>星期四</th>
        <th>星期五</th>
        <th class="weekend">星期六</th>
        <th class="weekend">星期日</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${tempArray}" varStatus="status1">
        <tr>
            <td class="firstcol">${status1.index + 1} </td>
            <c:forEach items="${tempArray[status1.index]}" varStatus="stauts2">
                <td>${tempArray[status1.index][stauts2.index]}</td>
            </c:forEach>
        </tr>
    </c:forEach>
    <tr class="topline2px">
        <td class="firstcol">晚自习</td>
        <td>自习</td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    </tbody>
    <tfoot>
    <tr class="foottr">
        <td colspan="8">注意：</td>
    </tr>
    </tfoot>
</table>
</body>
</html>