package info5100Assignment2;


public class Assignment2 {
    /*
        This method should return the sum of salaries of 
        employees having salary greater than 5000
        Note: Employee array is passed, not employee
     */
    public double salaryGreaterThanFiveThousand(Employee[] employees) {
    	double sum = 0.0;
    	for (int i = 0; i<employees.length; i++) {
    		if(employees[i].getSalary() >5000.0) {
    			sum = sum + employees[i].getSalary();
    			
    		}
    	}
    	return sum;
    }

    
    /*
        This method should print either "Fizz", "Buzz" or "FizzBuzz"
        "Fizz" - if id of employee is divisible by 3
        "Buzz" - if id of employee is divisible by 5
        "FizzBuzz" - if id of employee is divisible by both 3 and 5
     */
    public void fizzBuzz(Employee employee) {
        if((employee.getId() % 3 == 0)&&(employee.getId() % 5 == 0)) {
        	System.out.println("FizzBuzz");
        }
        if((employee.getId() % 3 == 0)&&(employee.getId() % 5 != 0)) {
        	System.out.println("Fizz");
        }
        if((employee.getId() % 3 != 0)&&(employee.getId() % 5 == 0)) {
        	System.out.println("Buzz");
        }        
    }

    
    /*
        This method should calculate tax for an employee in dollars
        If salary of employee is less than or equal to 2500, tax should be 10%
        If salary of employee is greater than 2500 but less than or equal to 5000, tax should be 25%
        If salary of employee is greater than 5000, tax should be 35%
    */
    public double calculateTax(Employee employee) {
    	double employeeSalary = employee.getSalary();
    	if(employeeSalary>5000) {
    		return employeeSalary* 0.35;
    	}if(employeeSalary<=2500) {
    		return employeeSalary*0.1;
    	}else {
    		return employeeSalary*0.25;
    	}
    }
    
    /*
        We are given two employee objects.
        Implement this method to swap salaries of employees
    */
    public void swap(Employee firstEmployee, Employee secondEmployee) {
        double current = secondEmployee.getSalary();
        secondEmployee.setSalary(firstEmployee.getSalary());
        firstEmployee.setSalary(current);
    }

    
    /*
        Return number of employees whose age is greater than 50
        Note: Employee array is passed, not employee
     */
    public int employeesAgeGreaterThan50(Employee[] employees) {
        // @TODO
    	int count = 0;
    	for(int i = 0; i <employees.length;i++ ) {
    		if (employees[i].getAge()>50) {
    			count++;
    		}
    	}
        return count;
    }

    
    /*
        Implement this method to reverse firstName of employee.
        Ex. Before: employee.getFirstName() -> "John"
        After : employee.getFirstName() -> "nhoJ"
     */
    public void reverseFirstName(Employee employee) {
    	String orginalfirstname = employee.getFirstName();
    	String result = "";
    	int len = employee.getFirstName().length();
    	for(int i = len-1; i>=0;i--) {
    		String str = Character.toString((orginalfirstname.charAt(i)));
    		result = result + str;
    	}
    	employee.setFirstName(result);
    }

    
    /*
        Print "true" if employee's first name contain one or more digits
        Print "false" if employee's first name doesn't contain any digit
        Ex: employee.getFirstName() -> "ha8l" == true
        employee.getFirstName() -> "hail" == false
     */
    public void isContainDigit(Employee employee) {
        String firstname = employee.getFirstName();
        int len = employee.getFirstName().length();
        for(int i = 0; i<len ; i++) {
        	char letter = firstname.charAt(i);
        	if(Character.isDigit(letter)) {
        		System.out.println("true");
        		return;
        	}
        }
        System.out.println("false");
    }
    

    
     /*
        Write a method to raise an employee's salary to three times of his/her original salary.
        Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
        DO NOT change the input in this method.
        Try to add a new method in Employee class: public void raiseSalary(double byPercent) 
        Call this new method.
     */
    public void tripleSalary(Employee employee) {
        employee.raiseSalary(2.00);
    }
    
    
    //Additional question for extra credit
    /*
        Implement this method to convert String[] to employees array.
        Ex: String[] employees = new String[]{"1,John,24,7500", "2,Hail,28,7899.90"};
        This String array of length 2 contains 2 employees in form of string, where
        id = 1
        firstName=John
        age=24
        salary=7500
        convert each string to employee object.
        Hint: Use String methods. Refer : https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
     */
    public Employee[] createEmployees(String[] employeesStr) {
        Employee[] employees = new Employee[employeesStr.length];
        for(int i = 0; i<employeesStr.length;i++) {
        	String[] employeeinfo = employeesStr[i].split(","); 
        	int id = Integer.parseInt(employeeinfo[0]);
        	int age = Integer.parseInt(employeeinfo[2]);
        	double salary = Double.parseDouble(employeeinfo[3]);
        	employees[i].setId(id);
        	employees[i].setFirstName(employeeinfo[1]);
        	employees[i].setAge(age);
        	employees[i].setSalary(salary);
        }
        return employees;
    }
}