package model;

public class Student {
	
	private String id;
	private String name;
	private String gender;
	private String password;
	private String imagePath;
	
	public Student(String id, String name, String gender, String password, String imagePath) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.password = password;
		this.imagePath = imagePath;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
	
}
