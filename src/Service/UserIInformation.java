package Service;

public class UserIInformation {

	private String name;
	private String id;
	private String  pass;
	private String tel;
	private String  sex;
	
	public UserIInformation(String name,String id, String pass, String tel,String sex) {
		super();
		this.name = name;
		this.id = id;
		this.pass = pass;
		this.tel = tel;
		this.sex=sex;
	}
	public UserIInformation(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

	
	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
