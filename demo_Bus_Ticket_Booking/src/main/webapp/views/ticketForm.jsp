<%@ taglib  uri="http://www.springframework.org/tags/form"  prefix="form"%>
<html>
<h2>Add Ticket Page</h2>
<form:form action="saveTicket" modelAttribute="ticketModel">
    <table>
        <tr>
            <td>Ticket ID </td> <td> <form:input path="id"/> </td>
            <td><form:errors path="id"/></td>
        </tr>
        <tr>
            <td col span="2"> <input type="submit" value="Add Ticket"> </td>
        </tr>
    </table>
</form:form>
</html>