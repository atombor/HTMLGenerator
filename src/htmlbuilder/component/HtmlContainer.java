package htmlbuilder.component;

/**
 * Container definition of HTML components, that can contain other HTML components.
 * 
 * @author Attila Tombor
 */
public interface HtmlContainer extends HtmlComponent {
	
	/**
	 * Adds a component next to the previous, one horizontally.
	 * @param child next element
	 */
	void addNext(HtmlComponent child);
	
	/**
	 * Adds a component below the prevois one.
	 * @param child
	 */
	void addBelow(HtmlComponent child);
	
}