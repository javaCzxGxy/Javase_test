package com.itheima_01;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        ArrayList<Student> array = new ArrayList<Student>();
        //while实现循环
        while (true) {
            //主界面的编写
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看所有学生");
            System.out.println("5 退出系统");
            System.out.println("请输入你的选项：");
            //Scanner实现键盘录入
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            //switch 完成选择操作

            switch (line) {
                case "1":
                    //System.out.println("添加学生");
                    addStudent(array);
                    break;
                case "2":
                    //System.out.println("删除学生");
                    deleteStudent(array);
                    break;
                case "3":
                    //System.out.println("修改学生");
                    updataStudent(array);
                    break;
                case "4":
                    //System.out.println("查看所有学生");
                    findAllStudent(array);
                    break;
                case "5":
                    System.out.println("谢谢使用");
                    // break;
                    System.exit(0);

            }

        }
    }

    //添加学生方法
    public static void addStudent(ArrayList<Student> array) {
        //键盘录入学生的信息
        Scanner sc = new Scanner(System.in);
        //学号
        String sid;
        while(true) {
            System.out.println("请输入学生学号：");
             sid = sc.nextLine();
            boolean flag = isUsed(array, sid);
            if (flag) {
                System.out.println("学号重复请重新输入");
            }else{
                break;
            }
        }
        //姓名
        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();
        //年龄
        System.out.println("请输入学生年龄：");
        String age = sc.nextLine();
        //学生地址
        System.out.println("请输入学生的地址：");
        String adress = sc.nextLine();
        //创建学生对象把值赋给学生对象
        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAdress(adress);
        //将学生对象的值添加到集合里
        array.add(s);
        //给出添加学生成功的提示；
        System.out.println("添加学生成功");
    }

    //判断学号重复问题
    public static boolean isUsed(ArrayList<Student> array, String sid) {
        boolean flag = false;
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getSid().equals(sid)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    //查看所有学生
    public static void findAllStudent(ArrayList<Student> array) {
        //判断无信息  给警告
        if (array.size() == 0) {
            System.out.println("无信息，清先添加信息再查询");
            return;//为了让程序停止不在继续往下执行
        }
        //显示表头信息
        // /t 其实就是tab键的位置
        System.out.println("学号\t\t\t姓名\t\t年龄\t\t居住地址");
        //遍历数组
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            System.out.println(s.getSid() + "\t" + s.getName() + "\t" + s.getAge() + "岁\t" + s.getAdress());
        }
    }

    //删除学生的方法
    public static void deleteStudent(ArrayList<Student> array) {
        //键盘输入学生的学号
        Scanner sc = new Scanner(System.in);
        System.out.println("输入要删除的学生的学号：");
        String sid = sc.nextLine();
        //判断学号是否存在
        int index = -1;
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getSid().equals(sid)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("您输入的学号有误，清重新输入");
            return;
        } else {
            array.remove(index);
        }
        //在集合中找的这个学生 删除他
//        for(int i=0;i<array.size();i++){
//            Student s=array.get(i);
//            if(s.getSid().equals(sid)){
//                array.remove(i);
//                break;
//            }
        //给出删除成功的提示
        System.out.println("删除学生成功");
    }


    //修改学生的方法
    public static void updataStudent(ArrayList<Student> array) {
        //键盘输入要修改学生的学号
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要修改的学生的学号：");
        String sid = sc.nextLine();
        //判断学号是否存在
        int index = -1;
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getSid().equals(sid)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("您输入的学号有不存在，请重新输入");
            return;
        } else {
            //输入新学生的信息
            System.out.println("请输入新学生的姓名：");
            String name = sc.nextLine();
            System.out.println("请输入新学生的年龄：");
            String age = sc.nextLine();
            System.out.println("请输入新学生的住址：");
            String adress = sc.nextLine();
            //创建学生对象保存信息
            Student s = new Student();
            s.setSid(sid);
            s.setName(name);
            s.setAge(age);
            s.setAdress(adress);
            array.set(index, s);
        }
        //遍历集合修改信息
       /* for (int i = 0; i < array.size(); i++) {
            Student student = array.get(i);
            if (student.getSid().equals(sid)) {
                array.set(i, s);
                break;
            }
        }
        */
        System.out.println("修改学生成功");
    }

}


