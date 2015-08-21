package com.epam.DTO;

/**
 * Created by Yevhen_Vasyliev on 21.08.2015.
 */
public class LoginFormBean {

    private long password;
    private String userName;

    public long getPassword() {
        return password;
    }

    public void setPassword(long password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginFormBean that = (LoginFormBean) o;

        if (password != that.password) return false;
        return !(userName != null ? !userName.equals(that.userName) : that.userName != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (password ^ (password >>> 32));
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        return result;
    }
}
