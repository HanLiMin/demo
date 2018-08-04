package com.moontwon.demo.spring.da;

import javax.validation.constraints.Pattern;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 2018/7/30
 */
public class BookDO {
    @Pattern(regexp = "(1|2)\\d{3}")
    private String barcode;
}
