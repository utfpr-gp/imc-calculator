<%-- 
    Document   : template
    Created on : Apr 5, 2017, 3:02:46 PM
    Author     : Roni
--%>

<%@tag description="Template principal" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="title"%>


<html>
<head>
<title>${title}</title>
<base href="${pageContext.request.contextPath}/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="icon" type="image/png" href="favicon.png" />

<!-- CSS -->
<link rel="stylesheet" href="resources/css/cssLayout.css"></link>
<link rel="stylesheet" href="resources/css/materialize.css"></link>
<link rel="stylesheet" href="resources/css/common.css"></link>
<link rel="stylesheet" href="resources/css/template.css"></link>
<link rel="stylesheet" href="resources/lib/font-awesome/css/font-awesome.min.css"></link>


<!--Import Google Icon Font-->
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet"></link>
<link href='http://fonts.googleapis.com/css?family=Roboto:200,700'
	rel='stylesheet' type='text/css'></link>
	
</head>
<body>
	<header>
		<div class="navbar-fixed" style="z-index: 999">
			<nav>
				<div class="nav-wrapper blue">
					<div class="container">
						<a class="brand-logo" href="index.jsp"> <img class="utf-logo"
							src="resources/img/logo.png"></img>
						</a> <a href="#" data-activates="mobile-demo" class="button-collapse"><i
							class="material-icons">menu</i></a>
						<ul class="right hide-on-med-and-down">
							<li><a href="index.jsp">Início</a></li>							
							<c:if test="${isLoggedIn}">
							<li><a href="logout">Logout</a></li>
							</c:if>							
							
						</ul>
						<ul class="side-nav white" id="mobile-demo">
							<div class="row">
								<div class="col s8 offset-s2">
									<div class="center">
										<img class="responsive-img utf-logo-nav"
											src="resources/img/logo.png" />
									</div>
								</div>
							</div>

							<li><a href="index.jsp">Início</a></li>							
							<c:if test="${isLoggedIn}">
							<li><a href="logout">Logout</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</header>
	<main id="content" class="container"> <jsp:doBody /> </main>
	<!-- rodape-->
	<footer class="page-footer blue darken-5">
		<div class="container">
			<div class="row">
				<div class="col s12 center">
					<a href="http://www.utfpr.edu.br/guarapuava"> <img
						src="resources/img/utfpr.png" id="utfpr-footer"
						class=" img-responsive" height="70px" />
					</a>
				</div>
			</div>
		</div>
		<div class="footer-copyright">
			<div class="container">
				&#169; Copyright <span id="year"></span> - Todos os direitos
				reservados
			</div>
		</div>
	</footer>
	<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"></script>
	<script src="resources/js/common.js"></script>
</body>
</html>
