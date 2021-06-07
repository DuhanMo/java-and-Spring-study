package ch08;

public class Man {
    private int height;
    private int weight;
    private String gender;
    private String name;
    private int age;

    public Man(int height, int weight, String gender, String name, int age) {
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.name = name;
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String showInfo(){
        return "키가" +height+ "이고 몸무게가" +weight+ "킬로인" +gender+"이 있습니다. 이름은 "+name+ "이고 나이는 "+age+"세입니다.";
    }
}
