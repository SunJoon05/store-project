<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/assets/css/main.css">
    <title>Profile</title>
    <script src="${pageContext.request.contextPath}/assets/js/navigation-profile.js" type="module"></script>
    <script src="${pageContext.request.contextPath}/assets/js/change-photo.js" type="module"></script>
</head>
<body>
<%@ include file="/includes/components/header.jsp"%>
<%@ include file="/includes/organisms/profile-main.jsp"%>
<%@ include file="/includes/components/footer.jsp"%>
</body>
</html>
