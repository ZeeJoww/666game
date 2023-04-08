package homework.entity;

public class Account {
    static int nextId = 1;
    static int getNextId() {
        int thisId = nextId;
        nextId += 1;
        return thisId;
    }

    int id;
    String password;
    String name;
    String personId;
    String email;
    double balance;

    public Account(int id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }

    public Account () {
        this(Account.getNextId(), "", "");
    }

    boolean deposit(double money) {
        balance = balance + money;
        return true;
    }

    boolean withdraw(double money) {
        if (balance >= money) {
            balance = balance - money;
            return true;
        } else {
            return false;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
