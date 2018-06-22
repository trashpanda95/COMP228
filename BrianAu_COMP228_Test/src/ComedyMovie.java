/*
 * Created By: Brian Au
 * Student No.: 300962933
 * Course: COMP228
 * Test 1
 * ComedyMovie Class
 * 22 JUN 2018
 */
public class ComedyMovie extends Movie {

    // Constructor
    public ComedyMovie(String title, String studio, String leadActor, Double budget, Integer year) {
        super(title, studio, leadActor, budget, year);
    }

    @Override
    public void setBudget(Double budget) {
        this.budget = budget;
    }

    @Override
    public String getGenre() {
        return this.getClass().getName();
    }
}
