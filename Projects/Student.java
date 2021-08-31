package com.itheima_01;

public class Student {
    //学号
    private String sid;
    //姓名
    private String name;
    //年龄
    private String age;
    //居住地
    private String adress;
    //无参构造
    public Student () {

    }
    //四参构造
    public Student (String sid,String name,String age,String adress){
        this.sid=sid;
        this.name=name;
        this.age=age;
        this.adress=adress;
    }
    //学号的set方法
    public void setSid(String sid){
        this.sid=sid;
    }
    //学号的get方法
    public String getSid(){
        return sid;
    }
    //姓名的set方法
    public void setName(String name)
    {
        this.name=name;
    }
    //姓名的get方法
    public String getName(){
        return name;
    }//年龄的set方法
    public void setAge(String age){
        this.age=age;
    }
    //年龄的get方法
    public String getAge(){
        return age;
    }//学生地址的set方法
    public void setAdress(String adress){
        this.adress=adress;
    }
    //学生地址的get方法
    public String getAdress(){
        return adress;
    }

}
