<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--jstl 도구 사용하기 위해서, 메타 설정 코드 불러오기, 복붙해서 사용함. --%>
<!DOCTYPE html>
<html>
<head>
  <title>JSP-Model2(MVC)-todoList</title>
</head>
<body>
<ul>
  <h1>${menuMemberDTO.mname}님 환영합니다.</h1>
  <div>
    <form method="post" action="/menulogout">
      <button type="submit">로그아웃</button>
    </form>
  </div>
  <div>
    <form method="post" action="/menunoauto">
      <button type="submit">자동로그인해제</button>
    </form>
  </div>
  <button><a href="/menu/input">메뉴작성</a></button>
  <%--  서버 컨트롤러에서 전달 받은 박스, 라벨 이름: list, --%>
  <%--  내용물: 디비에서 가져온 10개의 값--%>
  <c:forEach items="${list}" var="dto">
    <li>
      <span>
        <a href="/todo/read?menuNo=${dto.menuNo}">${dto.menuNo}</a>
      </span>
      <span>
          ${dto.menuTitle}
      </span>
      <span>
          ${dto.menuRegDate}
      </span>
    </li>
  </c:forEach>
</ul>

</body>
</html>
