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

    @Override
    public String toString() {
        return "FgsScanList{" +
                "refNo=" + refNo +
                ", line=" + line +
                ", companyCode='" + companyCode + '\'' +
                ", buyerPO='" + buyerPO + '\'' +
                ", salesOrderCounterCode='" + salesOrderCounterCode + '\'' +
                ", salesOrderCode='" + salesOrderCode + '\'' +
                ", orderLine=" + orderLine +
                ", subLine=" + subLine +
                ", componentOrderLine=" + componentOrderLine +
                ", customerSupplierType='" + customerSupplierType + '\'' +
                ", customerSupplierCode='" + customerSupplierCode + '\'' +
                ", upcId=" + upcId +
                ", cartonType=" + cartonType +
                ", packingFlag='" + packingFlag + '\'' +
                ", weight=" + weight +
                ", length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", unitPerPkg=" + unitPerPkg +
                ", status=" + status +
                '}';
    }
}

