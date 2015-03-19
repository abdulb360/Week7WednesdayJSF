package resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named(value = "courseName")
@ApplicationScoped
public class CourseNameJSFBean {
	private PreparedStatement studentStatment = null;
	private String choice;
	private String[] titles;

	public CourseNameJSFBean() {
		initializeJdbc();
	}

	private void initializeJdbc() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook", "abdulb", "Pa$$word");
			
			PreparedStatement statement = connection.prepareStatement("select title from course");
			
			ResultSet resultSet = statement.executeQuery();
			
					// Store resultSet into array titles
					ArrayList<String> list = new ArrayList<String>();
					while (resultSet.next()) {
						list.add(resultSet.getString(1));
						}
						titles = new String[list.size()]; // Array for titles
						list.toArray(titles); // Copy strings from list to array
						
						// Define a SQL statement for getting students
						studentStatement = connection.prepareStatement(
						"select Student.ssn, "
						+ "student.firstName, Student.mi, Student.lastName, "
						+ "Student.phone, Student.birthDate, Student.street, "
						+ "Student.zipCode, Student.deptId "
						+ "from Student, Enrollment, Course "
						+ "where Course.title = ? "
						+ "and Student.ssn = Enrollment.ssn "
						+ "and Enrollment.courseId = Course.courseId;");
			}
				catch (Exception ex) {
					ex.printStackTrace();
				}
		}
					
	public String[] getTitles() {
		return titles;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}
		
	public ResultSet getStudents() throws SQLException {
		if (choice == null) {
			if (titles.length == 0)
				return null;
			else
				studentStatement.setString(1, titles[0]);
		}
		else {
			studentStatement.setString(1, choice); // Set course title
		}
	
		// Get students for the specified course
		return studentStatement.executeQuery();
	}
}
