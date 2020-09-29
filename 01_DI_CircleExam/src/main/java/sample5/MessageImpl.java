package sample5;

public class MessageImpl implements Message{

	private String name; // ¿µÈñ(»ý¼ºÀÚ)
	private String greeting; // Hello (setter)
	
	
	public MessageImpl(String name) {
		super();
		this.name = name;
	}

	
	public String getGreeting() {
		return greeting;
	}


	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}


	@Override
	public void sayHello() {
		System.out.println(name + "~" + greeting +"!");
	}

}
