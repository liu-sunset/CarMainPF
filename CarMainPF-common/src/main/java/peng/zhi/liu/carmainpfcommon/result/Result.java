package peng.zhi.liu.carmainpfcommon.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Integer code;
    private String msg;
    private Object data;
    public static  Result success(){
        Result result = new Result();
        result.code = 200;
        result.msg = "success";
        return result;
    }
    public static Result success(Object data){
        Result result = Result.success();
        result.data = data;
        return result;
    }
    public static Result error(Object data){
        Result result = new Result();
        result.code = 400;
        result.msg = "error";
        result.data = data;
        return result;
    }
}
