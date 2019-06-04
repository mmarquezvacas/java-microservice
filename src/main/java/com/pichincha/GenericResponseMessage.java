package com.pichincha;

import java.util.Objects;

public class GenericResponseMessage {
    public GenericResponseMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "GenericResponseMessage{" +
                "message='" + message + '\'' +
                '}';
    }

    public String message;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericResponseMessage that = (GenericResponseMessage) o;
        return Objects.equals(getMessage(), that.getMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMessage());
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
