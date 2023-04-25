package filterutility.testclasses;

public class Car {
	private Long id;
	private String model;
	private String manufacturer;
	private String bodyStyle;

	public Car(Long id, String model, String manufacturer, String bodyStyle) {
		super();
		this.id = id;
		this.model = model;
		this.manufacturer = manufacturer;
		this.bodyStyle = bodyStyle;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getBodyStyle() {
		return bodyStyle;
	}

	public void setBodyStyle(String bodyStyle) {
		this.bodyStyle = bodyStyle;
	}
	
	
}
