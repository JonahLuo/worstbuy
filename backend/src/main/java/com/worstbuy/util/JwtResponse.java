package com.worstbuy.javachinna;

import java.util.HashMap;
import java.util.Map;

public class JwtResponse{
    private final String message;
    private final int code;
    private final Map<String, Object> data = new HashMap<String, Object>();

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public JwtResponse putDataValue(String key, Object value) {
        data.put(key, value);
        return this;
    }

    private JwtResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static JwtResponse ok() {
        return new JwtResponse(200, "Ok");
    }

    public static JwtResponse notFound() {
        return new JwtResponse(404, "Not Found");
    }

    public static JwtResponse badRequest() {
        return new JwtResponse(400, "Bad Request");
    }

    public static JwtResponse forbidden() {
        return new JwtResponse(403, "Forbidden");
    }

    public static JwtResponse unauthorized() {
        return new JwtResponse(401, "unauthorized");
    }

    public static JwtResponse serverInternalError() {
        return new JwtResponse(500, "Server Internal Error");
    }

    public static JwtResponse customerError() {
        return new JwtResponse(1001, "customer Error");
    }

}
