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
     * @param mpCode openid
     * @return
     */
    public int newClassForm(StudentBasic studentBasic, StudentTime studentTime,String mpCode){
        int a=studentInfoMapper.checkStudentInfoByMPCode(mpCode);
        if(a==0){
            studentInfoMapper.newStudentInfo(studentBasic);
        }else{
            studentInfoMapper.updateStudentInfo(studentBasic);
        }
        int b=studentInfoMapper.checkStudentTimeByMPCode(mpCode);
        if(b==0){
            studentInfoMapper.newStudentTimeInfo(studentTime);
        }else{
            studentInfoMapper.updateStudentTime(studentTime);
        }
        return 0;
    }

    /**
     * 根据openid 获取学生上课时间信息
     * @param mpCode
     * @return
     */
    public StudentTime getStudentTimeByMpCode(String mpCode){

        return studentInfoMapper.getStudentTimeByMpCode(mpCode);
    }

    /**
     * 根据openid 获取学生基本信息
     * @param mpCode
     * @return
     */
    public StudentBasic getStudentInfoByMPCode(String mpCode){
        return studentInfoMapper.getStudentInfoByMPCode(mpCode);
    }
}
