package cn.com.devilmole.data.service;

import cn.com.devilmole.model.banana.StudentBasic;
import cn.com.devilmole.model.banana.StudentTime;

/**
 * Created by devilmole on 16/6/11.
 */
public interface StudentService {

    int newClassForm(StudentBasic studentBasic, StudentTime studentTime,String mpCode);

    StudentTime getStudentTimeByMpCode(String mpCode);

    StudentBasic getStudentInfoByMPCode(String mpCode);
}
