/*
 * Created By: Brian Au
 * Student No.: 300962933
 * Course: COMP228
 * Test 1
 * ActionMovie Class
 * 22 JUN 2018
 */
import javax.swing.JOptionPane;
public class ActionMovie extends Movie{

    // Constructor
    public ActionMovie(String title, String studio, String leadActor, Double budget, Integer year) {
        super(title, studio, leadActor, budget, year);

        setBudget(this.getBudget());
        // Informs User of Changes
        JOptionPane.showMessageDialog(null, "Budget Increased by 10%\nNew Budget: $" + String.format("%.2f%n",this.getBudget()));
    }

    // Sets the budget of the movie
    @Override
    public void setBudget(Double budget) {
        // Increase budget by 10%
        this.budget += (this.budget * 0.10);
    }

    // Returns the Genre Name
    @Override
    public String getGenre() {
        return this.getClass().getName();
    }
}
