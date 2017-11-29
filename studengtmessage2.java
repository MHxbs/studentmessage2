package studentmessage2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class studengtmessage2 {
    public static void main(String[] args) throws IOException {
        tools tool=new tools();
        //Map<major,Map<classnum,List<Map<student,List<String>>>>>整个集合
        Map<String,Map<String,List<Map<String,List<String>>>>> whole=new HashMap<>();
        //
        Map<String,List<String>> data=tool.getMajorToClassList();
        String major="通信工程";
        List<String> clazzes=data.get(major);
        //Map<classnum,List<Map<student,List<String>>>>班级对学生列表的Map
        Map<String,List<Map<String,List<String>>>> classes=new HashMap<>();
        for (String clazz:clazzes) {//遍历班级
            //List<Map<student,List<String>>>学生列表
            List<Map<String, List<String>>> studentList = new ArrayList<>();
            Map<String,List<String>> studentMessage = tool.getClassList(clazz);//得到这个班级的学生的Map
           //遍历每个学生
            for (Map.Entry<String,List<String>>entry:studentMessage.entrySet()){
                //提取学生信息
                Map<String,List<String>> stu=new HashMap<>();
                String name=entry.getKey();
                List<String> stuMessage=entry.getValue();
                stu.put(name,stuMessage);
                studentList.add(stu);//向学生列表添加该学生
            }
            //向班级列表添加这个班级
            classes.put(clazz,studentList);
        }
        //向专业加入班级
        whole.put(major,classes);
    }
}