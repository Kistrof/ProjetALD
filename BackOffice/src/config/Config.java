package config;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
	
public class Config
{
	public static XmlBeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("Spring.xml"));
	
	
	
}
