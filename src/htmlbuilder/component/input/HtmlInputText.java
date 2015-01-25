package htmlbuilder.component.input;

import htmlbuilder.component.HtmlComponent;

/**
 * HTML Input text compnent.
 * 
 * @author Attila Tombor
 */
public class HtmlInputText implements HtmlComponent {

	String name;
	String value;

	/**
	 * Creates input text without default value.
	 * @param name name of the field
	 */
	public HtmlInputText(String name) {
		this.name = name;
		this.value = "";
	}

	/**
	 * Creates input text with default value.
	 * @param name name of the field
	 * @param value default value
	 */
	public HtmlInputText(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	@Override
	public String print() {
		return "<input type='text' name='" + name + "' value= '" + value + "'>"; 
	}
	
}
