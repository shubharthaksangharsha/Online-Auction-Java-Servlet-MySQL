package com.example.online_auction;

public class RegisterBean {
    String Name;
    String EMail;
    String userName;
    String password;
    public RegisterBean(String name, String eMail, String userName, String password){
        super();
        Name = name;
        EMail = eMail;
        this.userName = userName;
        this.password = password;
    }
    public RegisterBean(){
        super();
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEMail() {
        return EMail;
    }

    public void setEMail(String EMail) {
        this.EMail = EMail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
