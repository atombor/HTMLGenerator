package htmlbuilder.component.container;

/**
 * Form input to submit data input field data.
 * 
 * @author Attila Tombor
 */
public class HtmlForm extends HtmlTable {
	
	private final String action;
	
	/**
	 * Form object constructor, to force to set the parameter.
	 * @param action html form action attribute
	 */
	public HtmlForm(String action) {
		this.action = action;
	}
	
	@Override
	public String print() {
		
		StringBuilder formResult = new StringBuilder();
		formResult.append("<form action='");
		formResult.append(action);
		formResult.append("'>");
			
		formResult.append(super.print());
		
		formResult.append("</form>");
		
		return formResult.toString();
	}
	
}
