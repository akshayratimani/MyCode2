
<%@include file="./header.jsp"%>



<c:forEach items="${list}" var="f">
	<div class="" style="margin-right: 35px; margin-left: 50px">
		<br>
		<center>
			<img style="width: 40%; height: 25%;" id="sky" alt="not found"
				src=<c:out value="${f.imgurl}"> </c:out> />
		</center>
		<br>
		<hr
			style="border: 0; height: 1px; background-image: linear-gradient(to right, rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0));">

		<br> <font size="6px" color=#283747><label><c:out
					value="${f.name}"></c:out> </label><br></font>Sold by : BombSellers<br>
		<font color=#900C3F size="5px"><b>Rs:<c:out
					value="${f.price}">
				</c:out>/-
		</b></font> <br>



		<c:choose>
			<c:when test="${f.ratings < 5}">
				<c:forEach var="a" begin="1" end="${f.ratings}">
					<span class="fa fa-star checked"></span>
				</c:forEach>

				<c:forEach var="a" begin="${f.ratings}" end="4">
					<span class="fa fa-star"></span>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<c:forEach var="a" begin="1" end="${f.ratings}">
					<span class="fa fa-star checked"></span>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<br> <br> <a href="" class="btn btn-default"
			style="height: 35px; width: 7%; background-color: #B7950B;">Buy</a> 
			<a
			href="/AddToCart?id=${f.id}&phoneno=${phno}" class="btn btn-default"
			style="height: 35px; width: 7%; background-color: #B7950B;">Add
			to Cart</a>


	</div>

	<br>
	<br>


</c:forEach>
<br>
</body>
</html>