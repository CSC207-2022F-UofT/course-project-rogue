package usecase_fights;

public class Calculator {
    Calculated calculated;
    public Calculator(Calculated calculated) {
        this.calculated = calculated;
    }

    public int calculateValue(){
        return this.calculated.calculate();
    }
}
