package com.eggmoney.ws.define;

/**
 * Created by comec on 2017-05-06.
 */
public enum AccountType {
    DS(1,   	"대성"),
    FACEBOOK(2, 	"페이스북"),
    KAKAO(3, 		"카카오"),
    NAVER(4, 		"네이버"),
    GOOGLE(5, 		"구글 Gmail"),
    ;

    private int code;
    private String name;
    AccountType(int code, String name){
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }
    public String getName(){
        return name;
    }
    public static AccountType get(int code){
        for(AccountType item : values()){
            if(code == item.getCode()){
                return item;
            }
        }
        return DS;
    }
}
