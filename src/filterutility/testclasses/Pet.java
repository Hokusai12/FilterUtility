package filterutility.testclasses;

public class Pet {
	private Long id;
	private String name;
	private Integer age;
	private String species;
	
	public Pet(Long id, String name, Integer age, String species) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.species = species;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}
	
	public Object getAttribute(String attributeName) {
		if(attributeName.equals("id")) {
			return this.id;
		}
		if(attributeName.equals("name")) {
			return this.name;
		}
		if(attributeName.equals("age")) {
			return this.age;
		}
		if(attributeName.equals("species")) {
			return this.species;
		}
		return null;
	}
}
