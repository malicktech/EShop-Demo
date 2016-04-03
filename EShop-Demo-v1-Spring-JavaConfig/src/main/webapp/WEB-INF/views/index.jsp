<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!-- PANIER -->



<div id="panier" style="display: none">
	<c:if test=" ${panier.size!=0}">
		<table>
			<tr>
				<th>ID</th>
				<th>Désignation</th>
				<th>Prix</
				<th>Quantité</th>
				<th>Montant</th>
			</tr>
			<c:forEach items=" ${panier.articles}" var="art">
				<tr>
					<td>${art.produit.idProduit}</td>
					<td>${art.produit.designation}</td>
					<td>${art.produit.prix}</td>
					<td>${art.quantite}</td>
					<td>${art.quantite*art.produit.prix}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="4">Total</td>
				<td>${panier.total}</td>
			</tr>
		</table>
	</c:if>
</div>

<!-- PRODUITS -->
<div id="catalogueProduits">

	<div class="row">
		<c:forEach items="${produits}" var="p">
		
			<div class="col-sm-6 col-md-4">
				<div class="thumbnail">
					<img style="height: 150px" alt="" src="photoProduit?idP=${p.idProduit}">
					<div class="caption">
						<h3>${p.designation}</h3>
						<p>Prix : ${p.prix}</p>
						<p>Stock: ${p.quantite}</p>
						<p>
						<form action="ajouterAuPanier">
						<input type="hidden" value="${p.idProduit}" name="idProduit">
						<input type="text" class="form-control" value="1" name="quantite">
						<input type="submit" class="btn btn-primary"
							value="Ajouter au panier">
							</p>
					</form>
					</div>
				</div>
			</div>
			
		</c:forEach>
	</div>
</div>

