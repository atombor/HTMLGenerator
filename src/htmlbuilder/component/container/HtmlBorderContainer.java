package htmlbuilder.component.container;

/**
 * Table layout container, with border surrounding.
 * 
 * @author Attila Tombor
 */
public class HtmlBorderContainer extends HtmlTable {
	
	@Override
	public String print() {
		
		StringBuilder formResult = new StringBuilder();
		formResult.append("<table border=5 cellspacing=0 ><tr><td>");
			
		formResult.append(super.print());
		
		formResult.append("</td></tr></table>");
		
		return formResult.toString();
	}
	
}
