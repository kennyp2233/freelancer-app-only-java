package com.app.frontend.common.input;

import com.app.backend.auth.entities.AuthEntity;
import com.app.backend.common.responses.Response;
import com.app.backend.users.entities.UserEntity;

public class FormatResponse {
    private Response response;

    public FormatResponse() {

    }

    // public static String format(Response response) {
    // String sepparator = "#####################################";
    // String formatedResponse = "\n" + sepparator + "\n"
    // + (response.getError() ? "\t[Error]\n\t" + response.getMessage()
    // : "\t[" + response.getMessage() + "]\n\t"
    // + ((response.getData() instanceof AuthEntity)
    // ? ((AuthEntity) response.getData()).getId()
    // : ""))
    // + "\n" + sepparator + "\n";
    // return formatedResponse;
    // }

    public static String format(Response response) {
        String sepparator = "#####################################";
        String formatedResponse = "\n" + sepparator + "\n";
        Object message = response.getMessage();
        if (response.getError()) {
            formatedResponse += "\t[Error]\n\t" + message;
        } else {
            Object data = response.getData();

            formatedResponse += "\t[" + message + "]\n\t";

            if (data.getClass().equals(UserEntity.class)) {

                formatedResponse += "\n\t(ID): " + ((UserEntity) data).getId();
                formatedResponse += "\n\t(Name): " + ((UserEntity) data).getName();
                formatedResponse += "\n\t(Email): " + ((UserEntity) data).getEmail();
            } else {
                formatedResponse += data;
            }
        }
        formatedResponse += "\n" + sepparator + "\n";

        return formatedResponse;
    }
}