package ch14;

public class Subway {
    private int subwayNo;
    private int passenger;
    private int income;

    public Subway(int subwayNo) {
        this.subwayNo = subwayNo;
    }
    public void take(int money) {
        this.income += money;
        this.passenger += 1;
    }

    public void showInfo() {
        System.out.println(subwayNo +"번 지하철의 승객은 "+ passenger +"명 이고, 수입은 "+ income+"원 입니다.");
    }
}
