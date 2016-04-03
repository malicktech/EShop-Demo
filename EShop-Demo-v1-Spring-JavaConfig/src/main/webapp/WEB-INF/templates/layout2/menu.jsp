<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<div class="list-group">
	<c:forEach var="cat" items="${categories}">
		<a href="produitsParCat?idCat=${cat.idCategorie}"
			class="list-group-item active"> ${cat.nomCategorie} <span
			class="badge">XX</span></a>
	</c:forEach>
</div>

<div class="panel panel-default">
	<div class="panel-heading">
		<img alt="" src=" <%=request.getContextPath()%>/resources/images/Shopping_cart_icon.svg.png">
		<h3 class="panel-title" onclick="affichePanier()">Panier</h3>
	</div>
	<div class="panel-body">
		<p>Nombre de produits : ${panier.size}</p>
		<p>Total : ${panier.total}</p>
	</div>
</div>