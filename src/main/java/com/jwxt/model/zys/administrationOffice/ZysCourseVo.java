package com.jwxt.model.zys.administrationOffice;

public class ZysCourseVo {
	/**课程id */
    private String id;
    /**任课教师id */
    private String courseTeacherId;
    /**任课教师姓名 */
    private String teacherName;
    /**班级id */	
    private String courseClassId;
    /**班级名 */	
    private String className;
    /**科目id */	
    private String courseSubjectId;
    /**科目 */	
    private String subjectName;
    /**年份 */
    private String courseYear;
    /**学期 */
    private String courseSemester;
    /**日期 */
    private String courseWeekday;
    /**时间段 */
    private String coursePeriod;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCourseTeacherId() {
		return courseTeacherId;
	}
	public void setCourseTeacherId(String courseTeacherId) {
		this.courseTeacherId = courseTeacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getCourseClassId() {
		return courseClassId;
	}
	public void setCourseClassId(String courseClassId) {
		this.courseClassId = courseClassId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getCourseSubjectId() {
		return courseSubjectId;
	}
	public void setCourseSubjectId(String courseSubjectId) {
		this.courseSubjectId = courseSubjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getCourseYear() {
		return courseYear;
	}
	public void setCourseYear(String courseYear) {
		this.courseYear = courseYear;
	}
	public String getCourseSemester() {
		return courseSemester;
	}
	public void setCourseSemester(String courseSemester) {
		this.courseSemester = courseSemester;
	}
	public String getCourseWeekday() {
		return courseWeekday;
	}
	public void setCourseWeekday(String courseWeekday) {
		this.courseWeekday = courseWeekday;
	}
	public String getCoursePeriod() {
		return coursePeriod;
	}
	public void setCoursePeriod(String coursePeriod) {
		this.coursePeriod = coursePeriod;
	}
	
	public ZysCourseVo() {
		super();
	}
	
	public ZysCourseVo(String id, String courseTeacherId, String teacherName, String courseClassId, String className,
                       String courseSubjectId, String subjectName, String courseYear, String courseSemester, String courseWeekday,
                       String coursePeriod) {
		super();
		this.id = id;
		this.courseTeacherId = courseTeacherId;
		this.teacherName = teacherName;
		this.courseClassId = courseClassId;
		this.className = className;
		this.courseSubjectId = courseSubjectId;
		this.subjectName = subjectName;
		this.courseYear = courseYear;
		this.courseSemester = courseSemester;
		this.courseWeekday = courseWeekday;
		this.coursePeriod = coursePeriod;
	}
	
	@Override
	public String toString() {
		return "ZysCourseVo [id=" + id + ", courseTeacherId=" + courseTeacherId + ", teacherName=" + teacherName
				+ ", courseClassId=" + courseClassId + ", className=" + className + ", courseSubjectId="
				+ courseSubjectId + ", subjectName=" + subjectName + ", courseYear=" + courseYear + ", courseSemester="
				+ courseSemester + ", courseWeekday=" + courseWeekday + ", coursePeriod=" + coursePeriod + "]";
	}

}
