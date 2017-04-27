package com.dale.ms.entities;



/**
 * TVip entity. @author MyEclipse Persistence Tools
 */

public class TVip  implements java.io.Serializable {


    // Fields    

     private Long TVipId;
     private String vip;
     private String fee;


    // Constructors

    /** default constructor */
    public TVip() {
    }

    
    /** full constructor */
    public TVip(String vip, String fee) {
        this.vip = vip;
        this.fee = fee;
    }

   
    // Property accessors

    public Long getTVipId() {
        return this.TVipId;
    }
    
    public void setTVipId(Long TVipId) {
        this.TVipId = TVipId;
    }

    public String getVip() {
        return this.vip;
    }
    
    public void setVip(String vip) {
        this.vip = vip;
    }

    public String getFee() {
        return this.fee;
    }
    
    public void setFee(String fee) {
        this.fee = fee;
    }
   








}