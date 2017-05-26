package com.eggmoney.ws.utils;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by dklee on 2016-04-06.
 */
public class ResultMessage {

    public static List<String> getMessages(String message) {
        List<String> resultMessages = new ArrayList<String>();
        resultMessages.add(message);
        return resultMessages;
    }

    public static List<String> getNotFoundMessages() {
        return getMessages(Messages.getMessage("MSG.ERROR.NOT_FOUND"));
    }

    public static List<String> getServerErrorMessages(){
        return getMessages(Messages.getMessage("MSG.ERROR.SERVER_ERROR"));
    }

    public static List<String> getCreateSuccessMessages(){
        return getMessages(Messages.getMessage("MSG.CREATE.SUCCESS"));
    }

    public static List<String> getUpdateSuccessMessages(){
        return getMessages(Messages.getMessage("MSG.UPDATE.SUCCESS"));
    }

    public static List<String> getDeleteSuccessMessages(){
        return getMessages(Messages.getMessage("MSG.DELETE.SUCCESS"));
    }

    public static List<String> getDuplicatedMessages(){
        return getMessages(Messages.getMessage("MSG.ERROR.DUPLICATED"));
    }
}
