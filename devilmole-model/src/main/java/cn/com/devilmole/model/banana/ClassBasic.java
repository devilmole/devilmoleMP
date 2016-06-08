package cn.com.devilmole.model.banana;

/**
 * 班级基础信息
 * Created by devilmole on 16/6/6.
 */
public class ClassBasic {

    private String id;
    private int expectMax;
    private String classDay;
    private String classTime;
    private String starterHold;//发起人是否可提供上课场地
    private String createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getExpectMax() {
        return expectMax;
    }

    public void setExpectMax(int expectMax) {
        this.expectMax = expectMax;
    }

    public String getClassDay() {
        return classDay;
    }

    public void setClassDay(String classDay) {
        this.classDay = classDay;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    public String getStarterHold() {
        return starterHold;
    }

    public void setStarterHold(String starterHold) {
        this.starterHold = starterHold;
    }
}
