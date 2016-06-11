package cn.com.devilmole.data.service;

import cn.com.devilmole.data.dao.StudentInfoMapper;
import cn.com.devilmole.model.banana.StudentBasic;
import cn.com.devilmole.model.banana.StudentTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by devilmole on 16/6/11.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentInfoMapper studentInfoMapper;

    /**
     * 新建或更新发起课程信息
     * @param studentBasic 学生基本信息
     * @param studentTime 课程时间等信息
     * @return
     */
    public int newClassForm(StudentBasic studentBasic, StudentTime studentTime){
        studentInfoMapper.newStudentInfo(studentBasic);
        studentInfoMapper.newStudentTimeInfo(studentTime);
        return 0;
    }
}
