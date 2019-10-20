package com.zhixie.easyexcel.demo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Author zhbin
 * @Description
 * @Date 2019-10-20 10:11
 */
@Data
public class Person {

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty("性别")
    private String sex;

    @ExcelProperty("年龄")
    private int age;
}
