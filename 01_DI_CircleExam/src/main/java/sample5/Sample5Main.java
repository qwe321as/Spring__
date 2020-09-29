package sample5;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Sample5Main {
	public static void main(String[] args) {
		
		/* xml=>bean XXX */
		
//		MessageImpl ms = new MessageImpl("¿µÈñ");
//		ms.setGreeting("Hello");
		
		Resource resource = new ClassPathResource("Msg.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		
		MessageImpl ms2 = (MessageImpl)factory.getBean("ms");
		
		ms2.sayHello();

	}

}
