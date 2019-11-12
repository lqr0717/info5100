package simplecalculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class Calculator extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;           
    private String input;
    private String operator;
    private String screenInput;

    public Calculator() {
        input = "";
        operator = "";
        screenInput = "";
        Container container = getContentPane(); 
        JPanel pnlNorth = new JPanel();  
		JPanel pnlKeyboard = new JPanel(); 
        container.add(pnlNorth, BorderLayout.NORTH); 
        container.add(pnlKeyboard, BorderLayout.CENTER); 
        textField = new JTextField(30);
        textField.setEditable(false);
        textField.setSize(200,30);
        JButton btnClear = new JButton("Clear");
        pnlNorth.add(textField, BorderLayout.CENTER); 
		pnlNorth.add(btnClear, BorderLayout.EAST); 

        String[] name= {"7","8","9","+","4","5","6","-","1","2","3","*","0",".","=","/"};

        pnlKeyboard.setLayout(new GridLayout(4,4,1,1));

        for(int i=0;i<name.length;i++) {

            JButton button = new JButton(name[i]);
            button.addActionListener(new MyActionListener());
            pnlKeyboard.add(button);
        }
        btnClear.addActionListener(new MyActionListener());
    }

    class MyActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String actionCommand = e.getActionCommand();
            if(actionCommand.equals("+") || actionCommand.equals("-") || actionCommand.equals("*")
                || actionCommand.equals("/")) {
                input += " " + actionCommand + " ";
                screenInput = "";
            }
            else if(actionCommand.equals(".")) { 
                input += ".";
                screenInput += ".";
            }else if(actionCommand.equals("Clear")) {
                input = "";
                screenInput = "";
                textField.setText(screenInput);
            }
            else if(actionCommand.equals("=")) {
            	String result = calculate(input);
            	screenInput = result;
                textField.setText(result);
                input = result;
                screenInput = result;
            }
            else {
                input += actionCommand;
                screenInput += actionCommand;
            	textField.setText(screenInput);
            }
        }
    }
   

    private String calculate(String input){
        String[] mathinput = input.split(" ");
        //System.out.println(input);
        Stack<Double> stack = new Stack<>();
        Double m = Double.parseDouble(mathinput[0]);
        stack.push(m); 
        for(int i = 1; i < mathinput.length; i++) {
            if(i%2==1) {
                if(mathinput[i].equals("+"))
                    stack.push(Double.parseDouble(mathinput[i+1]));
                if(mathinput[i].equals("-"))
                    stack.push(-Double.parseDouble(mathinput[i+1]));
                if(mathinput[i].equals("*")) {
                    Double d = stack.peek();
                    stack.pop();
                    stack.push(d*Double.parseDouble(mathinput[i+1]));
                }
                if(mathinput[i].equals("/")) {
                    double help = Double.parseDouble(mathinput[i+1]);
                    try {
        				if(help == 0.0) {
        					throw new ArithmeticException("Cannot divided by zero");
        				}
        			}catch (ArithmeticException e) {
        				JOptionPane.showMessageDialog(this, "Cannot divided by zero");
        				throw e;
        			
        			}
                    double d = stack.peek();
                    stack.pop();
                    stack.push(d/help);
                }
            }
        }

        double d = 0d;

        while(!stack.isEmpty()) {
            d += stack.peek();
            stack.pop();
        }
        stack.push(d);
        String result = String.valueOf(d);
        return result;
    }

    public static void main(String[] args) {
        JFrame f = new Calculator();
        f.setTitle("Calculator");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(400, 200, 500, 300);
        f.setVisible(true);
    }
}
