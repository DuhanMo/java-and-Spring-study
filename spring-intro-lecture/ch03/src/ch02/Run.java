package ch02;

public class Run {
    public static void main(String[] args) {

        Customer customerLee = new Customer(10010, "이순신");
        customerLee.bonusPoint = 1000;
        System.out.println(customerLee.showCustomerInfo());

        VipCustomer customerKim = new VipCustomer(10020, "김유신");
        customerKim.bonusPoint = 10000;
        System.out.println(customerKim.showCustomerInfo());

        int priceLee = customerLee.calPrice(10000);
        int priceKim = customerKim.calPrice(10000);


        System.out.println(customerLee.showCustomerInfo() + " 지불금액은 " + priceLee + "원 입니다.");
        System.out.println(customerKim.showCustomerInfo() + " 지불금액은 " + priceKim + "원 입니다.");

        Customer customerNo = new VipCustomer(10030, "나몰라");

        customerNo.bonusPoint = 10000;
        int priceNo = customerNo.calPrice(10000);
        System.out.println(customerNo.showCustomerInfo() + " 지불금액은 " + priceNo  + "원 입니다.");
        System.out.println(customerNo.getClass());

    }


}
