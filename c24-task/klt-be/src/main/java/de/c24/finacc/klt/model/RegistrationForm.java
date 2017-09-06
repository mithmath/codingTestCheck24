package de.c24.finacc.klt.model;

public class RegistrationForm {
	
	private String nachName;
	private String vorName;
	private int age;
	
	public RegistrationForm(String nachName, String vorName, int age) {
		super();
		this.nachName = nachName;
		this.vorName = vorName;
		this.age = age;
	}
	public String getNachName() {
		return nachName;
	}
	public void setNachName(String nachName) {
		this.nachName = nachName;
	}
	public String getVorName() {
		return vorName;
	}
	public void setVorName(String vorName) {
		this.vorName = vorName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "RegistrationForm [nachName=" + nachName + ", vorName=" + vorName + ", age=" + age + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((nachName == null) ? 0 : nachName.hashCode());
		result = prime * result + ((vorName == null) ? 0 : vorName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistrationForm other = (RegistrationForm) obj;
		if (age != other.age)
			return false;
		if (nachName == null) {
			if (other.nachName != null)
				return false;
		} else if (!nachName.equals(other.nachName))
			return false;
		if (vorName == null) {
			if (other.vorName != null)
				return false;
		} else if (!vorName.equals(other.vorName))
			return false;
		return true;
	}
	
	
}
