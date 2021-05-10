import ch08.Man;
import ch08.Order;

public class Run {
    public static void main(String[] args) {
        Man kim = new Man(180, 90, "남성", "Thomas", 37);
        kim.setGender("변화된 성별");
        kim.setWeight(131);
        System.out.println(kim.showInfo());

        Order order = new Order("202011020003", "01023450001", "서울시 강남구 역삼동 111-333",
                "20201102", "130258", "35000", "0003");
        System.out.println(order.orderInfo());
    }
}
