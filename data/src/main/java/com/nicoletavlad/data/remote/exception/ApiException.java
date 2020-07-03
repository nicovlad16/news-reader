package com.nicoletavlad.data.remote.exception;


public class ApiException extends RuntimeException
{
    public final int httpCode;


    public ApiException(int httpCode)
    {
        super("Server returned HTTP code: " + httpCode);
        this.httpCode = httpCode;
    }
}