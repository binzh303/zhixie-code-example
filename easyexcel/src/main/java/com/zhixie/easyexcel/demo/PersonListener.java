package com.zhixie.easyexcel.demo;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zhbin
 * @Description
 * @Date 2019-10-20 10:21
 */
@Slf4j
public class PersonListener extends AnalysisEventListener<Person> {

    private int successCount = 0; // 成功量

    private int exceptionCount = 0; // 异常量

    private List<Person> exceptionList = new ArrayList<>(); // 异常数据

    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;
    List<Person> list = new ArrayList();

    private PersonService personService;

    public PersonListener(PersonService personService){

        this.personService = personService;
    }

    @Override
    public void invoke(Person person, AnalysisContext analysisContext) {
        log.info("解析到一条数据:{}",person);
        successCount++;
        list.add(person);
        if (list.size() >= BATCH_COUNT) {
            saveData();
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
        log.info("所有数据解析完成！");
    }
    @Override
    public void onException(Exception exception, AnalysisContext context) {
        log.error("解析失败，但是继续解析下一行", exception);

        Person person  = (Person)context.readRowHolder().getCurrentRowAnalysisResult();
        exceptionList.add(person);
        exceptionCount++;

    }
    /**
     * 加上存储数据库
     */
    private void saveData(){
        log.info("{}条数据，开始存储数据库！", list.size());
        log.info("存储数据库成功！");
    }
    /**
     * 插入结果返回
     * @return
     */
    public Map<String,Object> getData(){

        Map<String,Object> map = new HashMap<>();
        map.put("success",successCount);
        map.put("exception",exceptionCount);
        return map;
    }

    /**
     * 失败数据返回
     * @return
     */
    public List<Person> getExceptionList(){

        return exceptionList;
    }
}
