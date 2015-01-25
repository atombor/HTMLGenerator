package htmlbuilder;

import htmlbuilder.component.basic.HtmlParagraph;
import htmlbuilder.component.container.HtmlBorderContainer;
import htmlbuilder.component.container.HtmlForm;
import htmlbuilder.component.container.HtmlTable;
import static htmlbuilder.component.container.HtmlTable.EMPTY_CELL;
import htmlbuilder.component.input.HtmlComboBox;
import htmlbuilder.component.input.HtmlInputText;
import htmlbuilder.component.input.HtmlSubmitButton;
import java.util.HashMap;
import java.util.Map;

/**
 * Builder class for HTML component API usage.
 * 
 * @author Attila Tombor
 */
public class HtmlBuilder {

	/**
	 * Main method that builds application examples.
	 * @param args system args
	 */
	public static void main(String[] args) {
		
		HtmlTable tableExample = createTableExample();
		System.out.println(tableExample.print());
		
		HtmlForm formExample = createFormExample();
		System.out.println(formExample.print());

		HtmlComboBox comboExample = createComboExample();
		System.out.println(comboExample.print());
		
		HtmlBorderContainer borderExample = createBroderTableExample();
		System.out.println(borderExample.print());
		
	}
	
	/**
	 * Creates an example table-formed data structure.
	 * @return created table structure
	 */
	private static HtmlTable createTableExample() {
		
		HtmlTable tableRoot = new HtmlTable();
		
		tableRoot.addNext(new HtmlParagraph("c1"));
		tableRoot.addNext(()-> ("c2"));
		tableRoot.addNext(()-> ("c3"));
		
		tableRoot.addBelow(()-> ("secondrow 1"));
		tableRoot.addNext(()-> ("c2"));
		tableRoot.addNext(()-> ("c3"));
		tableRoot.addNext(()-> ("c4"));
		
		tableRoot.addBelow(()-> ("third 1"));
		
		return tableRoot;
	}
	
	/**
	 * Creates example HTML form with input fields.
	 * @return created form structure
	 */
	private static HtmlForm createFormExample() {
		
		HtmlForm formRoot = new HtmlForm("localhost:8080/valami.html");
		
		formRoot.addNext(new HtmlParagraph("szoveg 1"));
		formRoot.addNext(new HtmlParagraph("szoveg 2"));
		
		formRoot.addBelow(new HtmlParagraph("szoveg 3"));
		formRoot.addNext(new HtmlInputText("alma"));

		formRoot.addBelow(new HtmlInputText("korte", "defaultkorte"));
		formRoot.addNext(new HtmlSubmitButton("Send"));
		
		return formRoot;
		
	}
	
	/**
	 * Builds an example combo box.
	 * @return created combo box
	 */
	private static HtmlComboBox createComboExample() {
		Map<String, String> optionList = new HashMap<>();
		
		optionList.put("1", "Alma");
		optionList.put("2", "Korte");
		optionList.put("3", "Szilva");
		optionList.put("4", "Barack");
		optionList.put("5", "Ringlo");
		
		HtmlComboBox comboBox = new HtmlComboBox("gyumolcs", optionList);
		
		return comboBox;
	}
	
	/**
	 * Creates an example bordered container, with many generated example cells.
	 * @return created border container
	 */
	private static HtmlBorderContainer createBroderTableExample() {
				
		HtmlBorderContainer borderRoot = new HtmlBorderContainer();
		
		borderRoot.addNext(createTableExample());
		borderRoot.addNext(EMPTY_CELL);
		borderRoot.addNext(()-> ("c2"));
				
		borderRoot.addBelow(()-> ("first 1"));
		borderRoot.addNext(()-> ("c1"));
		borderRoot.addNext(createComboExample());
		borderRoot.addNext(()-> ("c3"));

		borderRoot.addBelow(()-> ("second 1"));
		borderRoot.addNext(new HtmlParagraph("a"));
		borderRoot.addNext(()-> ("b"));
		borderRoot.addNext(()-> ("c"));
		borderRoot.addBelow(()-> ("third 1"));
		borderRoot.addNext(createFormExample());
		
		return borderRoot;
	}
}
