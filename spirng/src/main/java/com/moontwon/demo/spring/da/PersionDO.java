package com.moontwon.demo.spring.da;

import lombok.Data;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 2018/7/30
 */
@Data
public class PersionDO {
    @NotEmpty
    @Size(max = 12)
    private String name;
}
