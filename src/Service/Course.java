package Service;

import java.io.Serializable;
import java.util.List;

public class Course implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;//course
	private String id;//course
	private String tecName;
	private int grade =-1;
	private List<String> source;
	

	public Course(String name, String id, String tecName, List<String> source) {
		super();
		this.name = name;
		this.id = id;
		this.tecName = tecName;
		this.source = source;
	}
	
	public Course(String name, String id, String tecName, int grade, List<String> source) {
		super();
		this.name = name;
		this.id = id;
		this.tecName = tecName;
		this.grade = grade;
		this.source = source;
	}
	
	public Course(String name, String tecName,String  id ){
		this.name = name;
		this.id= id;
		this.tecName=tecName;
	}
	public Course(String name, String tecName){
		this.name = name;
		this.tecName=tecName;
	}
	
	
	
	

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public List<String> getSource() {
		return source;
	}

	public void setSource(List<String> source) {
		this.source = source;
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

	public String getTecName() {
		return tecName;
	}

	public void setTecName(String tecName) {
		this.tecName = tecName;
	}
	
	
	
}