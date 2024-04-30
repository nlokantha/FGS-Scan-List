package com.example.fgsscanlist.Models;

import org.json.JSONObject;

import java.math.BigDecimal;
import java.math.BigInteger;

public class FgsScanList {
    BigInteger refNo;
    int line;
    String companyCode;
    String buyerPO;
    String salesOrderCounterCode;
    String salesOrderCode;
    BigDecimal orderLine;
    BigDecimal subLine;
    BigDecimal componentOrderLine;
    String customerSupplierType;
    String customerSupplierCode;
    int upcId;
    int cartonType;
    String packingFlag;
    BigDecimal weight;
    BigDecimal length;
    BigDecimal width;
    BigDecimal height;
    BigDecimal unitPerPkg;
    int status;

    public FgsScanList() {
    }
    public FgsScanList(JSONObject jsonObject) {

    }



    public BigInteger getRefNo() {
        return refNo;
    }

    public void setRefNo(BigInteger refNo) {
        this.refNo = refNo;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getBuyerPO() {
        return buyerPO;
    }

    public void setBuyerPO(String buyerPO) {
        this.buyerPO = buyerPO;
    }

    public String getSalesOrderCounterCode() {
        return salesOrderCounterCode;
    }

    public void setSalesOrderCounterCode(String salesOrderCounterCode) {
        this.salesOrderCounterCode = salesOrderCounterCode;
    }

    public String getSalesOrderCode() {
        return salesOrderCode;
    }

    public void setSalesOrderCode(String salesOrderCode) {
        this.salesOrderCode = salesOrderCode;
    }

    public BigDecimal getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(BigDecimal orderLine) {
        this.orderLine = orderLine;
    }

    public BigDecimal getSubLine() {
        return subLine;
    }

    public void setSubLine(BigDecimal subLine) {
        this.subLine = subLine;
    }

    public BigDecimal getComponentOrderLine() {
        return componentOrderLine;
    }

    public void setComponentOrderLine(BigDecimal componentOrderLine) {
        this.componentOrderLine = componentOrderLine;
    }

    public String getCustomerSupplierType() {
        return customerSupplierType;
    }

    public void setCustomerSupplierType(String customerSupplierType) {
        this.customerSupplierType = customerSupplierType;
    }

    public String getCustomerSupplierCode() {
        return customerSupplierCode;
    }

    public void setCustomerSupplierCode(String customerSupplierCode) {
        this.customerSupplierCode = customerSupplierCode;
    }

    public int getUpcId() {
        return upcId;
    }

    public void setUpcId(int upcId) {
        this.upcId = upcId;
    }

    public int getCartonType() {
        return cartonType;
    }

    public void setCartonType(int cartonType) {
        this.cartonType = cartonType;
    }

    public String getPackingFlag() {
        return packingFlag;
    }

    public void setPackingFlag(String packingFlag) {
        this.packingFlag = packingFlag;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getUnitPerPkg() {
        return unitPerPkg;
    }

    public void setUnitPerPkg(BigDecimal unitPerPkg) {
        this.unitPerPkg = unitPerPkg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

