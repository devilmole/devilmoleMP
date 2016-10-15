package cn.com.devilmole.model.banana;

/**
 * 学生基础信息
 * Created by devilmole on 16/6/6.
 */
public class StudentBasic {

    private String id;
    private String studentName;
    private String studentGender;
    private String birthDate;
    private String mobile;
    private String home1;
    private String mpCode;//微信号
    private String studentLevel;//学生基础
    private String demand;
    private int locationId;//所在省市区id
    private String locationName;
    private String locationOthers;//详细地址
    private String createTime;

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationOthers() {
        return locationOthers;
    }

    public void setLocationOthers(String locationOthers) {
        this.locationOthers = locationOthers;
    }

    public String getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = demand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHome1() {
        return home1;
    }

    public void setHome1(String home1) {
        this.home1 = home1;
    }

    public String getMpCode() {
        return mpCode;
    }

    public void setMpCode(String mpCode) {
        this.mpCode = mpCode;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getStudentLevel() {
        return studentLevel;
    }

    public void setStudentLevel(String studentLevel) {
        this.studentLevel = studentLevel;
    }
}
