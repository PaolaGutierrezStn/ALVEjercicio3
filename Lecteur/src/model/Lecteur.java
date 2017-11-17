package model;

public class Lecteur {
	private Long numberLecteur;
	private String name;
	private String phone;
	private String address;
	
	public Lecteur(Long numberLecteur, String name, String phone, String address) {
		super();
		this.numberLecteur = numberLecteur;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	
	public Lecteur() {
		this(0L," ",  " ", " ");
}

	public Long getNumberLecteur() {
		return numberLecteur;
	}

	public void setNumberLecteur(Long numberLecteur) {
		this.numberLecteur = numberLecteur;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Lecteur [numberLecteur=" + numberLecteur + ", name=" + name + ", phone=" + phone + ", address="
				+ address + "]";
	}
	
	

	
	
}
