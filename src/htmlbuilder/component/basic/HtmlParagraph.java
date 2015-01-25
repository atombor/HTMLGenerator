package htmlbuilder.component.basic;

import htmlbuilder.component.HtmlComponent;

/**
 * Simple paragraph, using Html <p> tag. 
 * 
 * @author Attila Tombor
 */
public class HtmlParagraph implements HtmlComponent {

	String value;

	/**
	 * Simle constructor to force setting the content.
	 * @param value paragraph content
	 */
	public HtmlParagraph(String value) {
		this.value = value;
	}
	
	@Override
	public String print() {
		return "<p>" + value + "</p>"; 
	}
	
}
