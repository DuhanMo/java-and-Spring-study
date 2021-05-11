package ch02;

public class VipCustomer extends Customer {
    private int agentID;
    private double salesRatio;

    public VipCustomer(int customerID, String customerName) {
        super(customerID, customerName);
        customerGrade = "VIP";    //오류 발생
        bonusRatio = 0.05;
        salesRatio = 0.1;
    }
    @Override
    public int calPrice(int price) {
        bonusPoint += price * bonusRatio;
        return price - (int)(price * salesRatio);
    }

    public String imVip(){
        return "나는 vip야";
    }

    public int getAgentID() {
        return agentID;
    }


}
