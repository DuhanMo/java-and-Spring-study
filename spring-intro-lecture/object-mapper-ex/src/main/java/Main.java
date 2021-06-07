import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dto.Car;
import dto.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("main");

        // 어떠한 제이슨을 이용할건지 ?
        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User();
        user.setName("홍길동");
        user.setAge(10);

        Car car1 = new Car();
        car1.setName("K5");
        car1.setCarNumber("11가 1111");
        car1.setType("sedan");

        Car car2 = new Car();
        car2.setName("QM3");
        car2.setCarNumber("22나 2222");
        car2.setType("SUV");

        List<Car> carList = Arrays.asList(car1, car2);

        user.setCars(carList);

//        System.out.println(user);

        String json = objectMapper.writeValueAsString(user);
        System.out.println(json);

        // 순수한 노드에 접근할 수 있는지?
        JsonNode jsonNode = objectMapper.readTree(json);
        String _name = jsonNode.get("name").asText();
        // 변수타입을 알 수 있을 때
        int _age = jsonNode.get("age").asInt();
        System.out.println("name : " + _name);
        System.out.println("int : " + _age);

        // 제이슨의 표준을 알고 있어야함.
        JsonNode cars = jsonNode.get("cars");
        System.out.println("cars : " + cars);
        ArrayNode arrayNode = (ArrayNode) cars;
        System.out.println("arrayNode : " + arrayNode);
        List<Car> _cars = objectMapper.convertValue(arrayNode, new TypeReference<List<Car>>() {});
        System.out.println(_cars);

        // JsonNode 에서는 막아놨지만 ObjectNode 에서는 값 변경이 가능하다.
        ObjectNode objectNode = (ObjectNode) jsonNode;
        objectNode.put("name", "steve");
        objectNode.put("age", 19);
        System.out.println(objectNode.toPrettyString());

    }
}
