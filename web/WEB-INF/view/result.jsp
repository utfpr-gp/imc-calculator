<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:template title="Resultado do IMC">
	<jsp:body>
		<h1>Resultado</h1>
		<div class="row">				
		<div class="card col s12">
            <span class="card-title">Atual</span>
            <div class="card-image">
                <span class="card-title">${bean.showCategory()}</span>
                
            </div>
            <div class="card-content">                       
                <p>Peso: ${bean.weight}</p>
                <p>Altura: ${bean.height}</p>                
                <p>Resultado: <fmt:formatNumber value="${bean.imc}"
							maxFractionDigits="2" />
					</p>   
                <fmt:formatDate value="${bean.date}" var="formattedDate"
						type="date" pattern="dd/MM/yyyy" />             
                
                <p>Data: ${formattedDate }</p>                                              
            </div>                               
        </div>
        </div>
        
        <h1>Resultados Anteriores</h1>
        <!-- aviso de vazio -->        
        <c:if test="${empty beans}">
        <div class="row">
            <div class="col s12 center-align">
                <i class="fa fa-5x fa-frown-o"></i>
                <h5 class="utf-info">Não há resultados!</h5>
            </div>
        </div>
        </c:if>
        
        <!-- aviso de vazio -->
        
        <!-- lista de resultados anteriores -->
        <c:if test="${not empty beans}">
        <div class="row">
        <c:forEach var="bean" items="${beans}" varStatus="status">       
        
	        <div class="col s12 m4 l3">
		        <div class="card">
		        	<fmt:formatDate value="${bean.date}" var="formattedDate"
						type="date" pattern="dd/MM/yyyy" />        	
		            <span class="card-title">Resultado ${status.index + 1}</span>
		            <div class="card-image">
		                <span class="card-title">${bean.showCategory()}</span>                
		            </div>
		            <div class="card-content">                       
		                <p>Peso: ${bean.weight}</p>
		                <p>Altura: ${bean.height}</p>                
		                <p>Resultado: <fmt:formatNumber value="${bean.imc}"
											maxFractionDigits="2" />
									</p>
		                <p>Data: ${formattedDate }</p>                                              
		            </div>                               
		        </div>        
	        </div>
                
        </c:forEach>        
        </div>
        </c:if>
        <!-- lista de resultados anteriores -->  
	</jsp:body>
</t:template>