package com.aguiardafa.eagletavern.config.init;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.aguiardafa.eagletavern.config.JPAConfig;
import com.aguiardafa.eagletavern.config.WebConfig;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	// configurando o DispatcherServlet para capturar 
	// as requisições feitas a esta aplicação
	
	//configurações que devem ser feitas antes das configurações web
	//o que for feito aqui, será disponibilizado para o ServletConfigClasses
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { JPAConfig.class };
	}

	//informando ao DispatcherServlet a classe do configuração do projeto
	//onde por exemplo ele vai descobrir quais são os controllers do projeto 
	@Override
	protected Class<?>[] getServletConfigClasses() { //configuração vontada a parte web (controller pra frente)
		return new Class<?>[] { WebConfig.class };
	}

	//mapeando para o DispatcherServlet o ponto de partida para captura das requisições
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
	//configurando codificação das páginas fornecidas pelo DispatcherServlet do projeto
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		
		return new Filter[] { characterEncodingFilter };
	}

}