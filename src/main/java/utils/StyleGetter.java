package utils;

/***
 * Class that is used to get the style.css file and can be called from anywhere in the code
 */
public class StyleGetter {

	private String style;

	public String getStyle() {
		return this.getClass().getResource("/styles/style.css").toExternalForm();
	}

	public void setStyle(String style) {
		this.style = style;
	}

}
