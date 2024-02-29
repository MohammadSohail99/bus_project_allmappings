<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<h2>Ticket for particular Bus </h2>
<table border="1">
    <tr>
        <th>Ticket Id</th>
    </tr>

    <c:if test="${!empty ticketList}">
        <c:forEach items="${ticketList}" var="ticketModel">
            <tr>
                <td> <c:out value="${ticketModel.getId()}"/></td>
            </tr>
        </c:forEach>
    </c:if>
    <c:if test="${empty ticketList}">
    <h2> no tickets</h2>
    </c:if>
</table>
<form style="text-align: center;" action="addTicket" method="get">
    <input type="hidden" name="busNumber" value="${busNumber}">
    <input type="submit" value="Add Ticket">
</form>
<form style="text-align: center;" action="addBus">
        <input type="submit" value="Add Bus">
</form>