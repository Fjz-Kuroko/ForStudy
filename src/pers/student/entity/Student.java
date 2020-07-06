package pers.student.entity;

public class Student {

    private String sno;
    private String sname;
    private int age;
    private String address;

    public Student(){}

    public Student(String sname, int age, String address) {
        this.sname = sname;
        this.age = age;
        this.address = address;
    }

    public Student(String sno, String sname, int age, String address) {
        this.sno = sno;
        this.sname = sname;
        this.age = age;
        this.address = address;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return this.getSno() + " - " + this.getSname() + " - " + this.getAge() + " - " + this.getAddress();
    }
}
