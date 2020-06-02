package com.course.model.base;/**
 * @Author cgl
 * @Date 2020/6/2 18:06
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cgl
 * @date 2020/6/2 18:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    private int code;
    private String msg;
    private T data;


    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(RetCode retCode) {
        this.code = retCode.getCode();
        this.msg = retCode.getMsg();
    }

    public static Result success(){
        return new Result(RetCode.SUCCESS);
    }

    public  static  <D>  Result<D>    success(D data){
        return new Result(RetCode.SUCCESS.getCode(),RetCode.SUCCESS.getMsg(),data);
    }

    public static Result error(RetCode retCode){
        return new Result(retCode);
    }
}
