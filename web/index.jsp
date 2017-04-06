<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template title="Calculadora de IMC">
	<jsp:body>
		<h1>Login</h1>
		<form action="login" method="POST">
			<div class="row">
				<div class="input-field col s12">
					<input id="username" type="text" name="username" />
					<label for="username" class="active">Usuário</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s12">
					<input id="password" type="password" name="password" />
					<label for="password" class="active">Senha</label>
				</div>
			</div>
			<p>
				<button type="submit" class="waves-effect waves-light btn green darken-3">Enviar</button>
			</p>
		</form>
	</jsp:body>
</t:template>