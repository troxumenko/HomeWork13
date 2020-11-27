package entities;

public class Account {

    public Account() {
    }

    public Account(String number) {
        this.number = number;
    }

    public Account(int clientId, String number, double value) {
        this.clientId = clientId;
        this.number = number;
        this.value = value;
    }

    public Account(int id, int clientId, String number, double value) {
        this.id = id;
        this.clientId = clientId;
        this.number = number;
        this.value = value;
    }

    private int id;
    private int clientId;
    private String number;
    private double value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Account{" +
                "clientId=" + clientId +
                ", number='" + number + '\'' +
                ", value=" + value +
                '}';
    }
}
