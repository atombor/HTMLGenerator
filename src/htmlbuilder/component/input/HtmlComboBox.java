package htmlbuilder.component.input;

import htmlbuilder.component.HtmlComponent;
import java.util.ArrayList;
import java.util.Map;

/**
 * Combobox generating HTML select tag.
 * 
 * @author Attila Tombor
 */
public class HtmlComboBox implements HtmlComponent {
	

	private final ArrayList<HtmlComponent> elements = new ArrayList<>();
	private final String name;
	Map<String, String> options;
	
	/**
	 * Html combo box with important parameters.
	 * @param name input field name
	 * @param options map defining the identifier and value of options
	 */
	public HtmlComboBox(String name, Map<String, String> options) {
		assert (name != null && options != null);
			
		this.name = name;
		this.options = options;
	}

	@Override
	public String print() {
		
		StringBuilder comboResult = new StringBuilder();
		comboResult.append("<select name='");
		comboResult.append(name);
		comboResult.append("'>");

		for (String actKey: options.keySet()) {
			comboResult.append("<option value='");
			comboResult.append(actKey);
			comboResult.append("'>");
			comboResult.append(options.get(actKey));
			comboResult.append("</option>");
		}
		
		comboResult.append("</select>");
		
		return comboResult.toString();
	}
	
}
