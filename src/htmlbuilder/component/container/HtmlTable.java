package htmlbuilder.component.container;

import htmlbuilder.component.HtmlComponent;
import htmlbuilder.component.HtmlContainer;
import java.util.ArrayList;

/**
 * Html container class to create table layout.
 * 
 * @author Attila Tombor
 */
public class HtmlTable implements HtmlContainer {
	
	public static final HtmlComponent EMPTY_CELL = () -> "&nbsp;";
	private final ArrayList<ArrayList<HtmlComponent>> tableContent = new ArrayList();
	private ArrayList<HtmlComponent> actualRow = new ArrayList<>();
	private int maxColumnSize = 0;
	
	/**
	 * Creates an HTML table structured data
	 */
	public void HtmlTable() {
		addNewRow();
	}
	
	@Override
	public void addNext(HtmlComponent child) {
		actualRow.add(child);
	}

	@Override
	public void addBelow(HtmlComponent child) {
		addNewRow();
		actualRow.add(child);
	}

	/**
	 * Generates table-like html structure, based on the added elements
	 * If a row shorter then the others, empty cells are rendered to it's end.
	 * @return generated table conent
	 */
	@Override
	public String print() {
		
		StringBuilder tableResult = new StringBuilder();
			
		tableResult.append("<table border='1' cellpadding='0' cellspacing='0'>");
		for (ArrayList<HtmlComponent> row: tableContent) {
			
			tableResult.append(printRow(row));
			
		}
		
		// actual row is not yet added to the main table data
		tableResult.append(printRow(actualRow));
		
		tableResult.append("</table>");
		
		return tableResult.toString();
	}
	
	/**
	 * Generated HTML row element, based on the parameter data.
	 * @param row table row data structure
	 * @return generated HTML table row 
	 */
	private StringBuilder printRow(ArrayList<HtmlComponent> row) {
		StringBuilder generatedRow = new StringBuilder();
		generatedRow.append("<tr>");
		
		for (int colCounter = 0 ; colCounter < maxColumnSize ; colCounter++) {
			generatedRow.append("<td>");

			if (colCounter < row.size()) {
				generatedRow.append(row.get(colCounter).print());
			}
			else {
				generatedRow.append(EMPTY_CELL.print());
			}

			generatedRow.append("</td>");
			
		}
		generatedRow.append("</tr>");

		return generatedRow;
	}
	
	/**
	 * Handles the table column count, saves the acutal, and adds a new row.
	 */
	private void addNewRow() {
		
		if (maxColumnSize < actualRow.size()) {
			maxColumnSize = actualRow.size();
		}
		
		tableContent.add(actualRow);
		actualRow = new ArrayList<>();
	}
	
}
