package com.aguiardafa.eagletavern.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import com.aguiardafa.eagletavern.controller.BeersController;
import com.aguiardafa.eagletavern.controller.CustomersController;
import com.aguiardafa.eagletavern.controller.UsersController;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration //informando que este é a classe de configuração da aplicação spring
@ComponentScan(basePackageClasses = { BeersController.class,
										CustomersController.class,
										UsersController.class}) //declarando onde encontrar os controllers (beans)
@EnableWebMvc //declarando que é uma aplicação MVC
public class WebConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {

	private ApplicationContext applicationContext; //objeto do Spring, quando aplicação termina de subir ele fica disponível

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	//configurando o ViewResolver para achar as views
	@Bean
	public ViewResolver viewResolver() {
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(templateEngine());
		resolver.setCharacterEncoding("UTF-8");
		return resolver;
	}
	
	//O TemplateEngine é quem consegue processar as views
	@Bean //disponibilizar no contexto do Spring
	public TemplateEngine templateEngine() {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setEnableSpringELCompiler(true);
		engine.setTemplateResolver(templateResolver());
		engine.addDialect(new LayoutDialect());
		return engine;
	}
	
	//configurando TemplateResolver que diz onde estão os arquivos View
	//qual extensão e onde eles estão
	private ITemplateResolver templateResolver() {
		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
		resolver.setApplicationContext(applicationContext);
		resolver.setPrefix("classpath:/templates/");
		resolver.setSuffix(".html");
		resolver.setTemplateMode(TemplateMode.HTML);
		return resolver;
	}
	
	//configurando LayoutDialect para utilização de tampletes/layouts nas views
	@Bean
	public LayoutDialect layoutDialect() {
	    return new LayoutDialect();
	}
	
	//configurando onde estão os recursos estáticos
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**")
				.addResourceLocations("classpath:/static/");
	}
}
