<html xmlns:th="https://www.thymeleaf.org" th:replace="~{fragments/layout :: layout (~{::body},'owners')}">

<head>
    <meta charset="UTF-8">
    <title>Hello ${name}!</title>
</head>
<body>
    <h1> this is inventory </h1>
    <h2 class="hello-title">Hello ${name}!</h2>
    <table>
        <c:forEach var = "i" begin="0" end="${2}" >
            <tr>
                <td>
                   <c:out value="${i}" /> I have a name <%= item.getName %>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>