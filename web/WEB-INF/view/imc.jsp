<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template title="Calculadora de IMC">
	<jsp:body>
		<h1>Digite seus dados para o cálculo do IMC</h1>
		<form action="imc-calculator" method="POST">
			<div class="row">
				<div class="input-field col s12">
					<input id="weight" type="text" name="weight" />
					<label for="weight" class="active">Peso</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s12">
					<input id="height" type="text" name="height" />
					<label for="height" class="active">Altura</label>
				</div>
			</div>
			<p>
				<button type="submit" class="waves-effect waves-light btn green darken-3">Calcular</button>
			</p>
		</form>		
	</jsp:body>
</t:template>