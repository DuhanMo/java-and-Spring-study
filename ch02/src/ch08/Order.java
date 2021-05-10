package ch08;

public class Order {

    private String orderId;
    private String phone;
    private String address;
    private String day;
    private String time;
    private String price;
    private String menu;

    public Order(String orderId, String phone, String address, String day, String time, String price, String menu) {
        this.orderId = orderId;
        this.phone = phone;
        this.address = address;
        this.day = day;
        this.time = time;
        this.price = price;
        this.menu = menu;
    }
    public String orderInfo(){
        return "주문 접수 번호 : " +orderId+"\n"+
        "주문 핸드폰 번호 : " +phone+"\n"+
        "주문 집 주소 : "+address+"\n"+
        "주문 날짜 : "+day+"\n"+
        "주문 시간 : "+time+"\n"+
        "주문 가격 : "+price+"\n"+
        "메뉴 번호 : "+menu;
    }
}
