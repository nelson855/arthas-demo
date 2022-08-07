package demos.arthas.controller.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @author nelson
 * @description
 * @date 2022-08-07 11:11 上午
 */
@Getter
@Setter
public class WatchRequest {
    private String id;
    private String name;
    private Integer code;

    public String getIdAndName() {
        return this.id + "_" + this.name;
    }
}
