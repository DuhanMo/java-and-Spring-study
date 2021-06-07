package ch02;

public class Customer {
    protected int customerID;
    protected String customerName;
    protected String customerGrade;

    protected int bonusPoint;
    protected double bonusRatio;

    private String agentId;
    private double saleRatio;

    public Customer (int customerID, String customerName){
        this.customerID = customerID;
        this.customerName = customerName;
        customerGrade = "SILVER";
        bonusRatio = 0.01;
    }
    public int calPrice(int price){
        if (customerGrade == "SILVER") bonusPoint += price * bonusRatio;
        return (int) (price-(price*bonusRatio));
    }
    public String showCustomerInfo(){
        return customerName
                +  "님의 등급은 " + customerGrade
                +  "이며, 보너스 포인트는 " + bonusPoint
                +  "입니다.";
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerGrade() {
        return customerGrade;
    }

    public void setCustomerGrade(String customerGrade) {
        this.customerGrade = customerGrade;
    }

    public int getBonusPoint() {
        return bonusPoint;
    }

    public void setBonusPoint(int bonusPoint) {
        this.bonusPoint = bonusPoint;
    }

    public double getBonusRatio() {
        return bonusRatio;
    }

    public void setBonusRatio(double bonusRatio) {
        this.bonusRatio = bonusRatio;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public double getSaleRatio() {
        return saleRatio;
    }

    public void setSaleRatio(double saleRatio) {
        this.saleRatio = saleRatio;
    }
}
