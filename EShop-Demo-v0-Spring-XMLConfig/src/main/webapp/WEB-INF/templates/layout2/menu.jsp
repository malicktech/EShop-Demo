<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<table>
	<c:forEach var="cat" items="${categories}">
		<tr>
			<td>
				<a class="btn btn-default navbar-btn" href="produitsParCat?idCat=${cat.idCategorie}">${cat.nomCategorie}</a>
			</td>
		</tr>
	</c:forEach>
</table>