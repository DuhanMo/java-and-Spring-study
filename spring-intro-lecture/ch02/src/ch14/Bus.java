package ch14;

public class Bus {
    private int busNo;
    private int passenger;
    private int income;

    public Bus(int busNo) {
        this.busNo = busNo;
    }

    public int getBusNo() {
        return busNo;
    }

    public void setBusNo(int busNo) {
        this.busNo = busNo;
    }

    public int getPassenger() {
        return passenger;
    }

    public void setPassenger(int passenger) {
        this.passenger = passenger;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }
    public void take(int money){
        this.income += money;
        this.passenger += 1;
    }

    public void showInfo() {
        System.out.println(busNo +"번 버스의 승객은 "+ passenger +"명 이고, 수입은 "+ income+"원 입니다.");
    }
}
