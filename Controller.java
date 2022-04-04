import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
private View theView;
private Model theModel;

public Controller(View theView, Model theModel) {
    this.theView = theView;
    this.theModel = theModel;
    this.theView.addCalculateListener(new CalculateListener(this));
    this.theView.addCalculateListenerSub(new CalculateListenerSub(this));
}
class CalculateListener implements ActionListener{
    private Controller c;
    public CalculateListener(Controller c) {
        this.c = c;
    }
    public void actionPerformed(ActionEvent e) {
        int firstNumber, secondNumber = 0;
        try{
            firstNumber = theView.getFirstNumber();
            secondNumber = theView.getSecondNumber();
            theModel.addTwoNumbers(firstNumber, secondNumber);

            theView.setCalcSolution(theModel.getCalculationValue());

            this.c.theView.writeToDB();

        }
        catch(NumberFormatException ex){
            System.out.println(ex);
            theView.displayErrorMessage("You Need to Enter 2 Integers");
        }
    }
}

class CalculateListenerSub implements ActionListener{
    private Controller c;
    public CalculateListenerSub(Controller c) {
        this.c = c;
    }
    public void actionPerformed(ActionEvent e) {
        int firstNumberSub, secondNumberSub = 0;
        try{
            firstNumberSub = theView.getFirstNumberSub();
            secondNumberSub = theView.getSecondNumberSub();
            theModel.subtractTwoNumbers(firstNumberSub, secondNumberSub);

            theView.setCalcSolutionSub(theModel.getCalculationValue());

            this.c.theView.writeToDBSub();

        }
        catch(NumberFormatException ex){
            System.out.println(ex);
            theView.displayErrorMessage("You Need to Enter 2 Integers");
        }
    }
}
public static void main(String args[])
{
    View theView = new View();
    Model theModel = new Model();
    Controller theController = new Controller(theView, theModel);
    theView.setVisible(true);
}
}