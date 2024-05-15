package org.project.user.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
public class BaseResponse<T>{
    private int status;
    private String message;
    private Object metadata;
    private T payload;

    public static <T> BaseResponse<T> createSuccess()
    {
        return new BaseResponse<T>()
                .setMessage("Created Successfully!!! ")
                .setStatus(HttpStatus.CREATED.value());
    }

    public static <T> BaseResponse<T> readSuccess()
    {
        return new BaseResponse<T>()
                .setMessage("Read Successfully!!! ")
                .setStatus(HttpStatus.OK.value());
    }

    public static <T> BaseResponse<T> updateSuccess()
    {
        return new BaseResponse<T>()
                .setMessage("Updated Successfully!!! ")
                .setStatus(HttpStatus.OK.value());
    }

    public static <T> BaseResponse<T> deleteSuccess()
    {
        return new BaseResponse<T>()
                .setMessage("Deleted Successfully!!! ")
                .setStatus(HttpStatus.OK.value());
    }

    public static <T> BaseResponse<T> notFound()
    {
        return new BaseResponse<T>()
                .setMessage("Not Found!!! ")
                .setStatus(HttpStatus.NOT_FOUND.value());
    }

    public static <T> BaseResponse<T> badRequest()
    {
        return new BaseResponse<T>()
                .setMessage("Bad Request!!! ")
                .setStatus(HttpStatus.BAD_REQUEST.value());
    }
}
