package com.eggmoney.ws.define;
/**
 * Created by comec on 2017-05-06.
 */
public enum MemberType {
    USER(1,   	"개인 회원");

    private int code;
    private String name;
    MemberType(int code, String name){
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }
    public String getName(){
        return name;
    }
    public static MemberType get(int code){
        for(MemberType item : values()){
            if(code == item.getCode()){
                return item;
            }
        }
        return USER;
    }
}
