package ch18;
// 인스턴스가 하나만 만들어져야 할 때 싱글톤 패턴
public class Company {
    private static Company instance = new Company();
    private Company(){
    }

    public static Company getInstance(){
        if (instance == null) {
            instance = new Company();
        }
        return instance;
    }
}
