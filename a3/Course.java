package info5100A3;

public class Course {
	private int courseId;
	private String courseName;
	private int maxCapacity;
	private int professorId;
	private int credits;
	private int[] studentIds;
	
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		initCourseId(courseId);
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		initCourseName(courseName);
	}
	public int getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(int maxCapacity) {
		initmaxCapacity(maxCapacity);
	}
	public int getProfessorId() {
		return professorId;
	}
	public void setProfessorId(int professorId) {
		initprofessorId(professorId);
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		initCredits(credits);
	}
	public int[] getStudentIds() {
		return studentIds;
	}
	public void setStudentIds(int[] studentIds) {
		this.studentIds = studentIds;
	}
	public void initCourseId(int courseId) {
		if(courseId>0) {
			this.courseId = courseId;
		}else {
			throw new IllegalArgumentException("CourseId should not be negative or zero");
		}
	}
	public void initCourseName(String courseName) {
		if((10 <= courseName.length()) &&(courseName.length()<= 60)) {
			this.courseName = courseName;
		}else {
			throw new IllegalArgumentException("CourseName should be a string with minimum length 10 and maximum 60");
		}
	}
	public void initmaxCapacity(int maxCapacity) {
		if((10 < maxCapacity) &&(maxCapacity< 100)) {
			this.maxCapacity = maxCapacity;
		}else {
			throw new IllegalArgumentException("maxCapacity should not be less than 10 greater than 100");
		}
	}
	public void initprofessorId(int professorId) {
		if((100000 <= professorId) &&(maxCapacity<= 999999)) {
			this.professorId = professorId;
		}else {
			throw new IllegalArgumentException("professorId should be a six digit integer");
		}
	}
	public void initCredits(int credits) {
		if((0 < credits) &&(credits< 10)) {
			this.credits = credits;
		}else {
			throw new IllegalArgumentException("credits should be a single digit but greater than 0");
		}
	}
	public  Course(int courseId) {
		setCourseId(courseId);
	}
	public  Course(int courseId,int professorId) {
		setCourseId(courseId);
		setProfessorId(professorId);
	}
	public  Course(int courseId,int professorId,int credits) {
		setCourseId(courseId);
		setProfessorId(professorId);
		setCredits(credits);
	}
	public void registerStudent(int studentId) {
		int orginalStudentNumber = this.studentIds.length;
		if(orginalStudentNumber < this.maxCapacity){
			int[] stuIds = new int[orginalStudentNumber+1];
			for(int i = 0; i<orginalStudentNumber; i++) {
				stuIds[i] = this.studentIds[i];
			}
			stuIds[orginalStudentNumber] = studentId;
			this.studentIds = stuIds;
		}
		else {
			throw new IllegalArgumentException("The class is full");
		}
		
	}
	
	//Q3
	public int[] removeDuplicates(int[] studentIds) {
		int count = studentIds.length;
        int size = studentIds.length;
        for (int i = 0; i < size; i++) {
        	for (int j = i+1; j < size; j++) {
        		if(studentIds[i] == studentIds[j]) {
        			studentIds[j] = studentIds[size-1];
        			size--;
                    count--;
                    }
            }
	}
	int[] result = new int[count];
	for (int i = 0; i < count; i++){
             result[i] = studentIds[i];
	}
	return result;
	}
	//Q4
	public int groupsOfStudents(int[] studentIds) {
		int len = studentIds.length;
		int count = 0;
		for (int i = 0; i<len;i++) {
			for(int j = i+1; j<len;j++) {
				if((studentIds[i]+studentIds[j])%2==0) {
					count++;
				}
			}
		}
		return count;
	}
}
