package com.pichincha;

import java.util.Objects;

public class GenericPostMessageInformation {
    private String message;
    private String to;
    private String from;
    private short timeToLifeSec;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericPostMessageInformation that = (GenericPostMessageInformation) o;
        return getTimeToLifeSec() == that.getTimeToLifeSec() &&
                Objects.equals(getMessage(), that.getMessage()) &&
                Objects.equals(getTo(), that.getTo()) &&
                Objects.equals(getFrom(), that.getFrom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMessage(), getTo(), getFrom(), getTimeToLifeSec());
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTimeToLifeSec(short timeToLifeSec) {
        this.timeToLifeSec = timeToLifeSec;
    }

    public String getMessage() {
        return message;
    }

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public short getTimeToLifeSec() {
        return timeToLifeSec;
    }
}
