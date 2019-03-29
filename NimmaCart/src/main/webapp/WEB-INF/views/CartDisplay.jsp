<%@include file="./header.jsp"%>


<br>
<div
	style="height: 32 px; margin-right: 35px; margin-left: 35px; background-color: white">
	<font face="cambria" size="5px"><b>Your Cart</b></font>
</div>
<hr
	style="height: 12px; border: 0; box-shadow: inset 0 12px 12px -12px rgba(0, 0, 0, 0.5);">

<c:choose>
	<c:when test="${cart == null}">

		<h4>Cart Empty</h4>

	</c:when>
	<c:otherwise>
		<c:forEach items="${cart}" var="f">

			
				<div class="" style="margin-right: 35px; margin-left: 35px">
					<br> <img style="width: 10%; height: 25%;" id="sky"
						alt="not found" src="" ><br>
					<br> <font size="4px" color=#283747><label><c:out
								value="${f.pid}"></c:out> </label><br></font> by : BombSellers<br> <font
						color=#900C3F><b>Rs:<c:out value="${f.price}">
							</c:out>/-
					</b></font> <br> <span class="fa fa-star checked"></span> <span
						class="fa fa-star checked"></span> <span
						class="fa fa-star checked"></span> <span
						class="fa fa-star checked"></span> <span
						class="fa fa-star checked"></span>
				</div>
			
			<hr
				style="border: 0; height: 1px; background-image: linear-gradient(to right, rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0));">

		</c:forEach>

	</c:otherwise>
</c:choose>

</body>
</html>