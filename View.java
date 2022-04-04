import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.awt.*;


public class View extends JFrame {
    private JTextField firstNumber = new JTextField(5);
    private JLabel additionLabel = new JLabel("+");
    private JTextField secondNumber = new JTextField(5);
    private JButton calculateButton = new JButton("Calculate");
    private JTextField calcSolution = new JTextField(5);

    private JTextField firstNumberSub = new JTextField(5);
    private JLabel labelSub = new JLabel("-");
    private JTextField secondNumberSub = new JTextField(5);
    private JButton calculateButtonSub = new JButton("Calculate");
    private JTextField calcSolutionSub = new JTextField(5);



    View() {
        JPanel calcPanel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350, 150);
        this.setBackground(Color.BLUE);

        calculateButton.setBackground(Color.PINK);
        calculateButtonSub.setBackground(Color.PINK);


        firstNumber.setText("0");
        secondNumber.setText("0");
        calcSolution.setText("0");
        calcPanel.add(firstNumber);
        calcPanel.add(additionLabel);
        calcPanel.add(secondNumber);
        calcPanel.add(calculateButton);
        calcPanel.add(calcSolution);
        this.add(calcPanel);

        firstNumberSub.setText("0");
        secondNumberSub.setText("0");
        calcSolutionSub.setText("0");
        calcPanel.add(firstNumberSub);
        calcPanel.add(labelSub);
        calcPanel.add(secondNumberSub);
        calcPanel.add(calculateButtonSub);
        calcPanel.add(calcSolutionSub);
        this.add(calcPanel);
    }
    public int getFirstNumber() {
        return Integer.parseInt(firstNumber.getText());
    }
    public int getSecondNumber() {
        return Integer.parseInt(secondNumber.getText());
    }
    public int getCalcSolution() {
        return Integer.parseInt(calcSolution.getText());
    }
    public void setCalcSolution(int solution) {
        calcSolution.setText(Integer.toString(solution));
    }


    public int getFirstNumberSub() {
        return Integer.parseInt(firstNumberSub.getText());
    }
    public int getSecondNumberSub() {
        return Integer.parseInt(secondNumberSub.getText());
    }
    public int getCalcSolutionSub() {
        return Integer.parseInt(calcSolutionSub.getText());
    }
    public void setCalcSolutionSub(int solution){
        calcSolutionSub.setText(Integer.toString(solution));
    } 

    void addCalculateListener(ActionListener listenForCalcButton) {
        calculateButton.addActionListener(listenForCalcButton);
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager .getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "12345678");
            PreparedStatement stmt = con.prepareStatement("insert into test values( ?, ?, ? ) ");
            stmt.setInt(1, getFirstNumber()); stmt.setInt(2, getSecondNumber()); stmt.setInt(3, getCalcSolution());
            stmt.executeUpdate();
            System.out.println(stmt);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }

    void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    void writeToDB() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager .getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "12345678");
            PreparedStatement stmt = con.prepareStatement("insert into test values( ?, ?, ? ) ");
            stmt.setInt(1, getFirstNumber()); stmt.setInt(2, getSecondNumber()); stmt.setInt(3, getCalcSolution());
            stmt.executeUpdate();
            System.out.println(stmt);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }

    void writeToDBSub() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager .getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "12345678");
            PreparedStatement stmt = con.prepareStatement("insert into test values( ?, ?, ? ) ");
            stmt.setInt(1, getFirstNumberSub()); stmt.setInt(2, getSecondNumberSub()); stmt.setInt(3, getCalcSolutionSub());
            stmt.executeUpdate();
            System.out.println(stmt);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }

    void addCalculateListenerSub(ActionListener listenForCalcButtonSub){
        calculateButtonSub.addActionListener(listenForCalcButtonSub);
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager .getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "12345678");
            PreparedStatement stmt = con.prepareStatement("insert into test values( ?, ?, ? ) ");
            stmt.setInt(1, getFirstNumberSub()); stmt.setInt(2, getSecondNumberSub()); stmt.setInt(3, getCalcSolutionSub());
            stmt.executeUpdate();
            System.out.println(stmt);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }
}