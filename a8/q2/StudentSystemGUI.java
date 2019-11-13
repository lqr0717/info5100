package simplecalculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class StudentSystemGUI extends JFrame {
	
	private JTable studentinfoTable;
	private DefaultTableModel model;
	private JLabel IDLabel, firstNameLabel, lastNameLabel, genderLabel;
	private JTextField IDField, firstNameField,  lastNameField,genderField;
	private JButton add;
	private Collection<Student> data;
	
	private String[] column = { "ID", "First Name", "Last Name", "Gender" }; 
	
	public StudentSystemGUI() {
		data = new ArrayList<Student>();
		Container con = getContentPane();
		studentinfoTable = new JTable();
		model = new DefaultTableModel();
		model.setColumnIdentifiers(column);
		studentinfoTable.setModel(model);
		studentinfoTable.setRowHeight(30);
		JPanel pnlAdd = new JPanel(); 
		JScrollPane pnlTable = new JScrollPane(studentinfoTable);
		pnlTable.setBounds(0, 0, 880, 200);
		con.add(pnlAdd,BorderLayout.NORTH);
		con.add(pnlTable,BorderLayout.CENTER);
		
		IDLabel = new JLabel("ID");
		firstNameLabel = new JLabel("First Name");
		lastNameLabel = new JLabel("Last Name");
		genderLabel = new JLabel("Gender");
		
		IDField = new JTextField(5);
		firstNameField = new JTextField(5);  
		lastNameField = new JTextField(5);
		genderField= new JTextField(5);
		
		add = new JButton("ADD");
		add.addActionListener(new MyActionListener());
		
		
		pnlAdd.add(IDLabel, BorderLayout.CENTER);
		pnlAdd.add(IDField, BorderLayout.CENTER);
		pnlAdd.add(firstNameLabel, BorderLayout.CENTER);
		pnlAdd.add(firstNameField, BorderLayout.CENTER);
		pnlAdd.add(lastNameLabel, BorderLayout.CENTER);
		pnlAdd.add(lastNameField, BorderLayout.CENTER);
		pnlAdd.add(genderLabel, BorderLayout.CENTER);
		pnlAdd.add(genderField, BorderLayout.CENTER);
		pnlAdd.add(add, BorderLayout.CENTER);
		
		
	}
	class Student {
		int id;
		String firstName;
		String lastName;
		String gender;

		public Student(int id, String firstName, String lastName, String gender) {
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.gender = gender;
		}
		public Student() {
			// TODO Auto-generated constructor stub
		}
		
	}

	class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();
			if(actionCommand.equals("ADD")) {
				Student  s = new Student();
				s.id = Integer.parseInt(IDField.getText());
				s.firstName = firstNameField.getText();
				s.lastName = lastNameField.getText();
				s.gender = genderField.getText();
				ADDStudents(s);
			}

		}

		private void ADDStudents(Student s) {
			// TODO Auto-generated method stub
			int exist = 0;

			if(data.size() > 0) {
				for(Student st: data) {
					if(s.id == st.id) {
						exist = 1;
						try {
							throw new Exception("This student already in the table.");
							}catch(Exception ex){
								JOptionPane.showMessageDialog(null, "This student already in the table.");
							}
						IDField.setText("");
						firstNameField.setText("");
						lastNameField.setText("");
						genderField.setText("");
						
				}
					
			}
			}
				data.add(s);
				Object[] row = new Object[4];
				row[0] = "" + s.id;
				row[1] = s.firstName;
				row[2] = s.lastName;
				row[3] = s.gender;
				model.addRow(row);
			 if(exist ==1) {
				 data.remove(s);
				 model.removeRow(data.size());
			 }
				
			}
			


		public boolean sameStudent(Student s1, Student s2) {
			return ((s1.id == s2.id) && (s1.firstName.equals(s2.firstName)) 
					&& (s1.lastName.equals(s2.lastName)) && (s1.gender.equals(s2.gender)));
		}
	
	}
	public static void main(String[] args) {
        JFrame f = new StudentSystemGUI();
        f.setTitle("Students System");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000, 300);
        f.setVisible(true);
    }
}
