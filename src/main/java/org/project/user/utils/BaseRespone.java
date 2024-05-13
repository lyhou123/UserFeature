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
public class BaseRespone<T>{
    private int status;
    private String message;
    private Object metadata;
    private T payload;

    public static <T> BaseRespone<T> createSuccess()
    {
        return new BaseRespone<T>()
                .setMessage("Created Successfully!!! ")
                .setStatus(HttpStatus.CREATED.value());
    }

    public static <T> BaseRespone<T> readSuccess()
    {
        return new BaseRespone<T>()
                .setMessage("Read Successfully!!! ")
                .setStatus(HttpStatus.OK.value());
    }

    public static <T> BaseRespone<T> updateSuccess()
    {
        return new BaseRespone<T>()
                .setMessage("Updated Successfully!!! ")
                .setStatus(HttpStatus.OK.value());
    }

    public static <T> BaseRespone<T> deleteSuccess()
    {
        return new BaseRespone<T>()
                .setMessage("Deleted Successfully!!! ")
                .setStatus(HttpStatus.OK.value());
    }
}
