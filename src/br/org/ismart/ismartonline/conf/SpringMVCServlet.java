package br.org.ismart.ismartonline.conf;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMVCServlet extends AbstractAnnotationConfigDispatcherServletInitializer
{

   @Override
   protected Class<?>[] getRootConfigClasses()
   {
      return new Class[] { JPAConfiguration.class, SecurityConfiguration.class, AppWebConfiguration.class };
   }

   @Override
   protected Class<?>[] getServletConfigClasses()
   {
      return null;
   }

   @Override
   protected String[] getServletMappings()
   {
      return new String[] { "/" };
   }
   
   @Override
	protected void customizeRegistration(Dynamic registration) {
		registration.setMultipartConfig(new MultipartConfigElement(""));
	}
   
   

}
