package com.eisedo.eisedo.data.local.entities;

public class Delegate {

    public String delegate_name;

    public boolean notify;

    public String email;

    public String message;

    public String getDelegate_name() {
        return delegate_name;
    }

    public void setDelegate_name(String delegate_name) {
        this.delegate_name = delegate_name;
    }

    public boolean isNotify() {
        return notify;
    }

    public void setNotify(boolean notify) {
        this.notify = notify;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
