package edu.global.ex.dto;

import java.sql.Date;

/*
100001	김행복	010-1111-2222	서울 동대문구 휘경1동	15/12/02	A	01
100002	이축복	010-1111-3333	서울 동대문구 휘경2동	15/12/06	B	01
100003	장믿음	010-1111-4444	울릉군 울릉읍 독도1리	15/10/01	B	30
100004	최사랑	010-1111-5555	울릉군 울릉읍 독도2리	15/11/13	A	30
100005	진평화	010-1111-6666	제주도 제주시 외나무골	15/12/25	B	60
100006	차공단	010-1111-7777	제주도 제주시 감나무골	15/12/11	C	60
*/
public class SDto {

    /*
    CUSTNO	NUMBER(6,0)
    CUSTNAME	VARCHAR2(20 BYTE)
    PHONE	VARCHAR2(13 BYTE)
    ADDRESS	VARCHAR2(60 BYTE)
    JOINDATE	DATE
    GRADE	CHAR(1 BYTE)
    CITY	CHAR(2 BYTE)
    */
    private int custno;
    private String custname;
    private String phone;
    private String address;
    private Date joindate;
    private String grade;
    private String city;


    public SDto(
            int custno,
            String custname,
            String phone,
            String address,
            Date joindate,
            String grade,
            String city) {
        super();
        this.custno = custno;
        this.custname = custname;
        this.phone = phone;
        this.address = address;
        this.joindate = joindate;
        this.grade = grade;
        this.city = city;
    }


    public int getCustno() {
        return custno;
    }


    public void setCustno(int custno) {
        this.custno = custno;
    }


    public String getCustname() {
        return custname;
    }


    public void setCustname(String custname) {
        this.custname = custname;
    }


    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public Date getJoindate() {
        return joindate;
    }


    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }


    public String getGrade() {
        return grade;
    }


    public void setGrade(String grade) {
        this.grade = grade;
    }


    public String getCity() {
        return city;
    }


    public void setCity(String city) {
        this.city = city;
    }


}
