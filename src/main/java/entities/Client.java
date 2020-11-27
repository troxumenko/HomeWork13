package entities;

public class Client {

    public Client() {
    }

    public Client(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Client(String name, String email, long phone, String about, int age) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.about = about;
        this.age = age;
    }

    public Client(int id, String name, String email, long phone, String about, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.about = about;
        this.age = age;
    }

    private int id;
    private String name;
    private String email;
    private long phone;
    private String about;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", about='" + about + '\'' +
                ", age=" + age +
                '}';
    }
}
