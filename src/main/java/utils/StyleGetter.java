package utils;

public class StyleGetter {

	private String style;

	public String getStyle() {
		return this.getClass().getResource("/styles/style.css").toExternalForm();
	}

	public void setStyle(String style) {
		this.style = style;
	}

}
