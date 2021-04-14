package com.project.entity;




public class Angestellte {

	private Integer id;
	
	private String vorname;
	private String nachname;
	private String email;
	private String prog_sprache;
	
	private String anfang;
	
	private String gender;
	
	public Angestellte() {
		// TODO Auto-generated constructor stub
	}

	public Angestellte(Integer id, String vorname, String nachname, String email, String prog_sprache, String anfang,
			String gender) {
		super();
		this.id = id;
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
		this.prog_sprache = prog_sprache;
		this.anfang = anfang;
		this.gender = gender;
	}

	public Angestellte(String vorname, String nachname, String email, String prog_sprache, String anfang,
			String gender) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
		this.prog_sprache = prog_sprache;
		this.anfang = anfang;
		this.gender = gender;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProg_sprache() {
		return prog_sprache;
	}

	public void setProg_sprache(String prog_sprache) {
		this.prog_sprache = prog_sprache;
	}

	public String getAnfang() {
		return anfang;
	}

	public void setAnfang(String anfang) {
		this.anfang = anfang;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
}
