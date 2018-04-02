package com.zz.demo.model;

public class HS {
    private double saleprice;
    private double integral;
    private double quantity;
    private String m_id;
    private String p_id;

    public double getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(double saleprice) {
        this.saleprice = saleprice;
    }

    public double getIntegral() {
        return integral;
    }

    public void setIntegral(double integral) {
        this.integral = integral;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getM_id() {
        return m_id;
    }

    public void setM_id(String m_id) {
        this.m_id = m_id;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    @Override
    public String toString() {
        return "HS{" +
                "saleprice=" + saleprice +
                ", integral=" + integral +
                ", quantity=" + quantity +
                ", m_id='" + m_id + '\'' +
                ", p_id='" + p_id + '\'' +
                '}';
    }
}
