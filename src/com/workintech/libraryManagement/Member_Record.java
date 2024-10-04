package com.workintech.libraryManagement;

public class Member_Record {
    private int member_id;
    private String type;
    private String date_of_membership;
    private int max_book_limit;
    private String name;
    private String address;
    private String phone_no;


    public Member_Record(int member_id, String phone_no, String address, String name, int max_book_limit, String date_of_membership, String type) {
        this.member_id = member_id;
        this.phone_no = phone_no;
        this.address = address;
        this.name = name;
        this.max_book_limit = max_book_limit;
        this.date_of_membership = date_of_membership;
        this.type = type;
    }

    public int getMember_id() {
        return member_id;
    }

    public String getType() {
        return type;
    }

    public String getDate_of_membership() {
        return date_of_membership;
    }

    public int getMax_book_limit() {
        return max_book_limit;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getPhone_no() {
        return phone_no;
    }


    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate_of_membership(String date_of_membership) {
        this.date_of_membership = date_of_membership;
    }

    public void setMax_book_limit(int max_book_limit) {
        this.max_book_limit = max_book_limit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public void getMember(){
        System.out.println( "Member_Record{" +
                    "member_id=" + member_id +
                    ", type='" + type + '\'' +
                    ", date_of_membership='" + date_of_membership + '\'' +
                    ", max_book_limit=" + max_book_limit +
                    ", name='" + name + '\'' +
                    ", address='" + address + '\'' +
                    ", phone_no='" + phone_no + '\'' +
                     '}');
    }


    }

