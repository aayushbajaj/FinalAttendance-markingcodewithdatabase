<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<c:if test="${success != null}">
	<script>
		swal("Done!", "${success}", "success");
	</script>
</c:if>
<c:if test="${error != null}">
	<script>
		swal("Oops!", "${error}", "error");
	</script>
</c:if>
