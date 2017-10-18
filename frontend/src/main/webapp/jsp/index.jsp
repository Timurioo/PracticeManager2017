<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<title>PracticeManager</title>
		<jsp:include page="/jsp/blocks/siteresourceslinks.jsp"/>
	</head>
	<body>
		<jsp:include page="/jsp/blocks/sitenavbar.jsp"/>

		<jsp:include page="/jsp/blocks/jumbotronblock.jsp">
			<jsp:param name="pageTitle" value="Student practice"/>
			<jsp:param name="titleDescription" value="The best study and the best theory is a real, practical work in the field that you like. Our abundance of production processes, the complexity of our manufacturing technologies and our team of experienced professionals will enable you to enhance your skills and knowledge. An apprenticeship within our group of companies may also be the beginning of your career, because we highly appreciate people who appreciate our values and demonstrate it with real work."/>
		</jsp:include>

		<div class="container">
			<div class="row">
				<div class="col-md-7">
					<img src="../resources/jpg/pen.jpg" class="img-thumbnail">
				</div>
				<div class="col-md-5">
					<h2 class="text-center"> For students</h2>
					<p class="text-justify">Take the first step on a new path.
								With hard work and dedication, job practice will help you learn skills to put you on track for a good career and a better life.
								A life-changing decision.</p>
					<p><a href="#" class="btn btn-default">Learn more &raquo; </a></p>
				</div>
			</div>
		</div>

		<jsp:include page="/jsp/blocks/sitefooter.jsp"/>
	</body>
</html>