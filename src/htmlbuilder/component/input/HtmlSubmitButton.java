package htmlbuilder.component.input;

import htmlbuilder.component.HtmlComponent;

/**
 * HTML submit button compnent.
 * 
 * @author Attila Tombor
 */
public class HtmlSubmitButton implements HtmlComponent {

	String text;

	/**
	 * Creates submit button with label.
	 * @param text button text
	 */
	public HtmlSubmitButton(String text) {
		this.text = text;
	}

	@Override
	public String print() {
		return "<input type='submit' value= '" + text + "'>"; 
	}
	
}
