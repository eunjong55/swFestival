package com.example.eunjong.swfestival;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

public class RegisterRequest extends StringRequest{

    final static private String URL = "http://gladi4231.cafe24.com/Register.php";
    private Map<String, String> parameters;

    public RegisterRequest(String userID, String userPassword, String userName, int userStudentNumber, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("userID", userID);
        parameters.put("userPassword", userPassword);
        parameters.put("userName", userName);
        parameters.put("userStudentNumber", userStudentNumber + "");
    }

    @Override
    public Map<String, String> getParams() {
        return parameters;
    }

}
