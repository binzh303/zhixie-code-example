package com.zhixie.easyexcel.demo;

import com.alibaba.excel.EasyExcel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * @Author zhbin
 * @Description
 * @Date 2019-10-20 10:26
 */
@RestController
@Slf4j
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("importFile")
    public String readPerson(MultipartFile file){

        PersonListener personListener = new PersonListener(personService);
        try {

            // headRowNumber(2) 这里可以设置1，因为头就是一行。如果多行头，可以设置其他值。不传入也可以，他没有指定头，也就是默认1行
            EasyExcel.read(file.getInputStream(), Person.class,personListener).sheet().headRowNumber(1).doRead();

        }catch (IOException ioe){

            log.info("读取excel异常={}",ioe);
        }
        Map<String, Object> data = personListener.getData();
        String exception = data.get("exception") + "";
        int exceptionCount = Integer.parseInt(exception);
        if(exceptionCount>0){
            String fileName = System.currentTimeMillis() + ".xlsx";
            // 这里 需要指定写用哪个class去读，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
            EasyExcel.write("E://upload/file/"+fileName, Person.class).sheet("模板").doWrite(personListener.getExceptionList());
            data.put("fileName",fileName);
        }
        return data.toString();
    }
}
