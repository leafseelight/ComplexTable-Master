package com.leaf.complextable.bean;

/**
 * 实际的数据模型（在多个种表格的常见下，要单独建类似的模型）
 *
 * 特点：每条记录包含行标题与行的所有列内容
 *
 * demo可以直接使用TableModel
 *
 * Data:2016-06-23 16:23
 * Created by YJG
 */
public class OnlineSaleBean extends BaseBean{

    private int id;
    private String addTime;
    private String modTime;
    private String nianYue;
    private String areaCode;
    private String orgCode;
    private String status;
    private String saleAll;
    private String saleAllOneNow;
    private String retailSale;
    private String retailSaleOneNow;
    private String onlineSale;
    private String onlineSaleOneNow;
    private String retailOnlineSale;
    private String retailOnlineSaleOneNow;
    private String addUserId;
    private String addUser;
    private String areaName;
    private String companyName;
    private String saleAllLast;
    private String saleAllOneNowLast;
    private String retailSaleLast;
    private String retailSaleOneNowLast;
    private String onlineSaleLast;
    private String onlineSaleOneNowLast;
    private String retailOnlineSaleLast;
    private String retailOnlineSaleOneNowLast;
    private String saleAllRate;
    private String saleAllOneNowRate;
    private String retailSaleRate;
    private String retailSaleOneNowRate;
    private String onlineSaleRate;
    private String onlineSaleOneNowRate;
    private String retailOnlineSaleRate;
    private String retailOnlineSaleOneNowRate;

    public OnlineSaleBean(String companyName){
        this.companyName = companyName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getModTime() {
        return modTime;
    }

    public void setModTime(String modTime) {
        this.modTime = modTime;
    }

    public String getNianYue() {
        return nianYue;
    }

    public void setNianYue(String nianYue) {
        this.nianYue = nianYue;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSaleAll() {
        return saleAll;
    }

    public void setSaleAll(String saleAll) {
        this.saleAll = saleAll;
    }

    public String getSaleAllOneNow() {
        return saleAllOneNow;
    }

    public void setSaleAllOneNow(String saleAllOneNow) {
        this.saleAllOneNow = saleAllOneNow;
    }

    public String getRetailSale() {
        return retailSale;
    }

    public void setRetailSale(String retailSale) {
        this.retailSale = retailSale;
    }

    public String getRetailSaleOneNow() {
        return retailSaleOneNow;
    }

    public void setRetailSaleOneNow(String retailSaleOneNow) {
        this.retailSaleOneNow = retailSaleOneNow;
    }

    public String getOnlineSale() {
        return onlineSale;
    }

    public void setOnlineSale(String onlineSale) {
        this.onlineSale = onlineSale;
    }

    public String getOnlineSaleOneNow() {
        return onlineSaleOneNow;
    }

    public void setOnlineSaleOneNow(String onlineSaleOneNow) {
        this.onlineSaleOneNow = onlineSaleOneNow;
    }

    public String getRetailOnlineSale() {
        return retailOnlineSale;
    }

    public void setRetailOnlineSale(String retailOnlineSale) {
        this.retailOnlineSale = retailOnlineSale;
    }

    public String getRetailOnlineSaleOneNow() {
        return retailOnlineSaleOneNow;
    }

    public void setRetailOnlineSaleOneNow(String retailOnlineSaleOneNow) {
        this.retailOnlineSaleOneNow = retailOnlineSaleOneNow;
    }

    public String getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(String addUserId) {
        this.addUserId = addUserId;
    }

    public String getAddUser() {
        return addUser;
    }

    public void setAddUser(String addUser) {
        this.addUser = addUser;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSaleAllLast() {
        return saleAllLast;
    }

    public void setSaleAllLast(String saleAllLast) {
        this.saleAllLast = saleAllLast;
    }

    public String getSaleAllOneNowLast() {
        return saleAllOneNowLast;
    }

    public void setSaleAllOneNowLast(String saleAllOneNowLast) {
        this.saleAllOneNowLast = saleAllOneNowLast;
    }

    public String getRetailSaleLast() {
        return retailSaleLast;
    }

    public void setRetailSaleLast(String retailSaleLast) {
        this.retailSaleLast = retailSaleLast;
    }

    public String getRetailSaleOneNowLast() {
        return retailSaleOneNowLast;
    }

    public void setRetailSaleOneNowLast(String retailSaleOneNowLast) {
        this.retailSaleOneNowLast = retailSaleOneNowLast;
    }

    public String getOnlineSaleLast() {
        return onlineSaleLast;
    }

    public void setOnlineSaleLast(String onlineSaleLast) {
        this.onlineSaleLast = onlineSaleLast;
    }

    public String getOnlineSaleOneNowLast() {
        return onlineSaleOneNowLast;
    }

    public void setOnlineSaleOneNowLast(String onlineSaleOneNowLast) {
        this.onlineSaleOneNowLast = onlineSaleOneNowLast;
    }

    public String getRetailOnlineSaleLast() {
        return retailOnlineSaleLast;
    }

    public void setRetailOnlineSaleLast(String retailOnlineSaleLast) {
        this.retailOnlineSaleLast = retailOnlineSaleLast;
    }

    public String getRetailOnlineSaleOneNowLast() {
        return retailOnlineSaleOneNowLast;
    }

    public void setRetailOnlineSaleOneNowLast(String retailOnlineSaleOneNowLast) {
        this.retailOnlineSaleOneNowLast = retailOnlineSaleOneNowLast;
    }

    public String getSaleAllRate() {
        return saleAllRate;
    }

    public void setSaleAllRate(String saleAllRate) {
        this.saleAllRate = saleAllRate;
    }

    public String getSaleAllOneNowRate() {
        return saleAllOneNowRate;
    }

    public void setSaleAllOneNowRate(String saleAllOneNowRate) {
        this.saleAllOneNowRate = saleAllOneNowRate;
    }

    public String getRetailSaleRate() {
        return retailSaleRate;
    }

    public void setRetailSaleRate(String retailSaleRate) {
        this.retailSaleRate = retailSaleRate;
    }

    public String getRetailSaleOneNowRate() {
        return retailSaleOneNowRate;
    }

    public void setRetailSaleOneNowRate(String retailSaleOneNowRate) {
        this.retailSaleOneNowRate = retailSaleOneNowRate;
    }

    public String getOnlineSaleRate() {
        return onlineSaleRate;
    }

    public void setOnlineSaleRate(String onlineSaleRate) {
        this.onlineSaleRate = onlineSaleRate;
    }

    public String getOnlineSaleOneNowRate() {
        return onlineSaleOneNowRate;
    }

    public void setOnlineSaleOneNowRate(String onlineSaleOneNowRate) {
        this.onlineSaleOneNowRate = onlineSaleOneNowRate;
    }

    public String getRetailOnlineSaleRate() {
        return retailOnlineSaleRate;
    }

    public void setRetailOnlineSaleRate(String retailOnlineSaleRate) {
        this.retailOnlineSaleRate = retailOnlineSaleRate;
    }

    public String getRetailOnlineSaleOneNowRate() {
        return retailOnlineSaleOneNowRate;
    }

    public void setRetailOnlineSaleOneNowRate(String retailOnlineSaleOneNowRate) {
        this.retailOnlineSaleOneNowRate = retailOnlineSaleOneNowRate;
    }
}
