package vn.edu.poly.bookmanager.model;

public class User {
    public static final String TABLE_NAME="users";
    public static final String COLUMN_USER_NAME="user_name";
    public static final String COLUMN_NAME="name";
    public static final String COLUMN_PHONE_NUMBER="phone_number";
    public static final String COLUMN_PASSWORD="password";
    String user_name;
    String name;
    String phone_number;
    String password;

    public User(String user_name, String name, String phone_number, String password) {
        this.user_name = user_name;
        this.name = name;
        this.phone_number = phone_number;
        this.password = password;
    }

    public User() {

    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_USER_NAME + " TEXT PRIMARY KEY,"
                    + COLUMN_NAME + " TEXT,"
                    + COLUMN_PHONE_NUMBER + " TEXT,"
                    + COLUMN_PASSWORD + " TEXT"
                    + ")";
}
