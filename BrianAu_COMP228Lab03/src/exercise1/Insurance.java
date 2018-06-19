package exercise1;

public abstract class Insurance {

    // Variable Declarations
    public String insuranceType;
    public Double monthlyCost;

    // Constructor
    public Insurance (String type, Double cost)
    {
        this.insuranceType = type;
        this.monthlyCost = cost;
    }

    // Getter Methods
    public String getInsuranceType(){ return this.insuranceType; }
    public Double getMonthlyCost(){ return this.monthlyCost; }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public void setMonthlyCost(Double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    // Abstract Methods
    public abstract void setInsuranceCost(Double cost);
    public abstract String displayInfo();
}
