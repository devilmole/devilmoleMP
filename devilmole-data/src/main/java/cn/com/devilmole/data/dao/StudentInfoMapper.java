package cn.com.devilmole.data.dao;

import cn.com.devilmole.model.banana.StudentBasic;
import cn.com.devilmole.model.banana.StudentTime;
import org.springframework.stereotype.Component;

/**
 * Created by devilmole on 16/6/8.
 */
@Component
public interface StudentInfoMapper {

    int newStudentInfo(StudentBasic studentBasic);

    int newStudentTimeInfo(StudentTime studentTime);

    int checkStudentInfoByMPCode(String mpCode);

    StudentTime getStudentTimeByMpCode(String mpCode);

    int updateStudentInfo(StudentBasic studentBasic);

    int checkStudentTimeByMPCode(String mpCode);

    StudentBasic getStudentInfoByMPCode(String mpCode);

    int updateStudentTime(StudentTime studentTime);

}
