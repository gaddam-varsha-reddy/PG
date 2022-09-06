package com.wavemaker.model;

import java.util.Objects;

public class Payment {
    int id;
    int monthId;
    int bedId;

    public Payment() {
    }

    public Payment(int id, int monthId, int bedId){
        this.id=id;
        this.monthId=monthId;
        this.bedId=bedId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMonthId() {
        return monthId;
    }

    public void setMonthId(int monthId) {
        this.monthId = monthId;
    }

    public int getBedId() {
        return bedId;
    }

    public void setBedId(int bedId) {
        this.bedId = bedId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return id == payment.id && monthId == payment.monthId && bedId == payment.bedId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, monthId, bedId);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", monthId=" + monthId +
                ", bedId=" + bedId +
                '}';
    }
}
