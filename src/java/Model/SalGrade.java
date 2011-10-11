/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author sikorskyi
 */
public class SalGrade {
    
    private int grade;
    private double  minSal;
    private double maxSal;
    
    public SalGrade() {}
    
    public SalGrade (int grade, double minSal, double maxSal) {
        this.grade = grade;
        this.minSal = minSal;
        this.maxSal = maxSal;
    }
    
    //Getters 
    
    public int getGrade() {
        return grade;
    }
    
    public double getMinSal() {
        return minSal;
    }
    
    public double getMaxSal() {
        return maxSal;
    }
    
    //setters
    
    public void setGrade(int grade) {
        this.grade = grade;
    }
    
    public void setMinSal(double minSal) {
        this.minSal = minSal;
    }
    
    public void setMaxSal(double maxSal) {
        this.maxSal = maxSal;
    }
    
    
    
    
}
