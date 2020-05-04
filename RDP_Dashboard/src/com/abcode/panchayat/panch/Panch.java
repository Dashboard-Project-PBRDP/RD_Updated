package com.abcode.panchayat.panch;

public class Panch {

	private int id;
	private int panchayat_id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String designation;
	private int age;
	private String gender;
	private String category;
	private String profession;
	private long contact;
	
	public Panch(int id, int panchayat_id, String firstName, String middleName, String lastName, String designation,
			int age, String gender, String category, String profession, long contact) {
		super();
		this.id = id;
		this.panchayat_id = panchayat_id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.designation = designation;
		this.age = age;
		this.gender = gender;
		this.category = category;
		this.profession = profession;
		this.contact = contact;
	}
	
	public Panch(int id, String firstName, String middleName, String lastName, String designation, int age,
			String gender, String category, String profession, long contact,int fk_panch) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.designation = designation;
		this.age = age;
		this.gender = gender;
		this.category = category;
		this.profession = profession;
		this.contact = contact;
		this.panchayat_id=fk_panch;
	}

	

	public Panch(String firstName, String middleName, String lastName, String designation, int age,
			String gender, String category, String profession, long contact, int panchayat_id) {
		super();
		this.panchayat_id = panchayat_id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.designation = designation;
		this.age = age;
		this.gender = gender;
		this.category = category;
		this.profession = profession;
		this.contact = contact;
	}


	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPanchayat_id() {
		return panchayat_id;
	}
	public void setPanchayat_id(int panchayat_id) {
		this.panchayat_id = panchayat_id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "Panch [id=" + id + ", fk_panch_panchayat=" + panchayat_id + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", age=" + age + ", gender=" + gender + ", category="
				+ category + ", profession=" + profession + ", contact=" + contact + "]";
	}
	
	
}
