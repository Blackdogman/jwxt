package packageModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
/**
*
*  @author author
*/
public class AdministrationOffice implements Serializable {

    private static final long serialVersionUID = 1529975059984L;


    /**
    * 主键
    * 
    * isNullAble:0
    */
    private String id;

    /**
    * 教务处员工工号
    * isNullAble:1
    */
    private String workerId;

    /**
    * 教务处员工姓名
    * isNullAble:1
    */
    private String workerName;

    /**
    * 教务处员工生日
    * isNullAble:1
    */
    private java.time.LocalDate workerBirthday;

    /**
    * 教务处员工性别（字典）
    * isNullAble:1
    */
    private Integer workerSex;

    /**
    * 地址
    * isNullAble:1
    */
    private String workerAddress;

    /**
    * 民族
    * isNullAble:1
    */
    private String workerNationality;

    /**
    * 电话号码
    * isNullAble:1
    */
    private String workerPhone;

    /**
    * 状态（字典）
    * isNullAble:1
    */
    private Integer workerStatus;

    /**
    * 
    * isNullAble:1
    */
    private String workerCitizenId;

    /**
    * 政治面貌（字典）
    * isNullAble:1
    */
    private Integer workerPoliticalStatus;


    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return this.id;
    }

    public void setWorkerId(String workerId){
        this.workerId = workerId;
    }

    public String getWorkerId(){
        return this.workerId;
    }

    public void setWorkerName(String workerName){
        this.workerName = workerName;
    }

    public String getWorkerName(){
        return this.workerName;
    }

    public void setWorkerBirthday(java.time.LocalDate workerBirthday){
        this.workerBirthday = workerBirthday;
    }

    public java.time.LocalDate getWorkerBirthday(){
        return this.workerBirthday;
    }

    public void setWorkerSex(Integer workerSex){
        this.workerSex = workerSex;
    }

    public Integer getWorkerSex(){
        return this.workerSex;
    }

    public void setWorkerAddress(String workerAddress){
        this.workerAddress = workerAddress;
    }

    public String getWorkerAddress(){
        return this.workerAddress;
    }

    public void setWorkerNationality(String workerNationality){
        this.workerNationality = workerNationality;
    }

    public String getWorkerNationality(){
        return this.workerNationality;
    }

    public void setWorkerPhone(String workerPhone){
        this.workerPhone = workerPhone;
    }

    public String getWorkerPhone(){
        return this.workerPhone;
    }

    public void setWorkerStatus(Integer workerStatus){
        this.workerStatus = workerStatus;
    }

    public Integer getWorkerStatus(){
        return this.workerStatus;
    }

    public void setWorkerCitizenId(String workerCitizenId){
        this.workerCitizenId = workerCitizenId;
    }

    public String getWorkerCitizenId(){
        return this.workerCitizenId;
    }

    public void setWorkerPoliticalStatus(Integer workerPoliticalStatus){
        this.workerPoliticalStatus = workerPoliticalStatus;
    }

    public Integer getWorkerPoliticalStatus(){
        return this.workerPoliticalStatus;
    }
    @Override
    public String toString() {
        return "AdministrationOffice{" +
                "id='" + id + '\'' +
                "workerId='" + workerId + '\'' +
                "workerName='" + workerName + '\'' +
                "workerBirthday='" + workerBirthday + '\'' +
                "workerSex='" + workerSex + '\'' +
                "workerAddress='" + workerAddress + '\'' +
                "workerNationality='" + workerNationality + '\'' +
                "workerPhone='" + workerPhone + '\'' +
                "workerStatus='" + workerStatus + '\'' +
                "workerCitizenId='" + workerCitizenId + '\'' +
                "workerPoliticalStatus='" + workerPoliticalStatus + '\'' +
            '}';
    }

    public static QueryBuilder QueryBuild(){
        return new QueryBuilder();
    }

    public static class QueryBuilder extends AdministrationOffice{
        /**
        * 需要返回的列
        */
        private Map<String,Object> fetchFields;

        public Map<String,Object> getFetchFields(){
            return this.fetchFields;
        }

        private List<String> idList;


        private List<String> fuzzyId;

        public List<String> getFuzzyId(){
            return this.fuzzyId;
        }

        private List<String> rightFuzzyId;

        public List<String> getRightFuzzyId(){
            return this.rightFuzzyId;
        }
        private List<String> workerIdList;


        private List<String> fuzzyWorkerId;

        public List<String> getFuzzyWorkerId(){
            return this.fuzzyWorkerId;
        }

        private List<String> rightFuzzyWorkerId;

        public List<String> getRightFuzzyWorkerId(){
            return this.rightFuzzyWorkerId;
        }
        private List<String> workerNameList;


        private List<String> fuzzyWorkerName;

        public List<String> getFuzzyWorkerName(){
            return this.fuzzyWorkerName;
        }

        private List<String> rightFuzzyWorkerName;

        public List<String> getRightFuzzyWorkerName(){
            return this.rightFuzzyWorkerName;
        }
        private List<java.time.LocalDate> workerBirthdayList;

        private java.time.LocalDate workerBirthdaySt;

        private java.time.LocalDate workerBirthdayEd;

        public java.time.LocalDate getWorkerBirthdaySt(){
            return this.workerBirthdaySt;
        }

        public java.time.LocalDate getWorkerBirthdayEd(){
            return this.workerBirthdayEd;
        }

        private List<Integer> workerSexList;

        private Integer workerSexSt;

        private Integer workerSexEd;

        public Integer getWorkerSexSt(){
            return this.workerSexSt;
        }

        public Integer getWorkerSexEd(){
            return this.workerSexEd;
        }

        private List<String> workerAddressList;


        private List<String> fuzzyWorkerAddress;

        public List<String> getFuzzyWorkerAddress(){
            return this.fuzzyWorkerAddress;
        }

        private List<String> rightFuzzyWorkerAddress;

        public List<String> getRightFuzzyWorkerAddress(){
            return this.rightFuzzyWorkerAddress;
        }
        private List<String> workerNationalityList;


        private List<String> fuzzyWorkerNationality;

        public List<String> getFuzzyWorkerNationality(){
            return this.fuzzyWorkerNationality;
        }

        private List<String> rightFuzzyWorkerNationality;

        public List<String> getRightFuzzyWorkerNationality(){
            return this.rightFuzzyWorkerNationality;
        }
        private List<String> workerPhoneList;


        private List<String> fuzzyWorkerPhone;

        public List<String> getFuzzyWorkerPhone(){
            return this.fuzzyWorkerPhone;
        }

        private List<String> rightFuzzyWorkerPhone;

        public List<String> getRightFuzzyWorkerPhone(){
            return this.rightFuzzyWorkerPhone;
        }
        private List<Integer> workerStatusList;

        private Integer workerStatusSt;

        private Integer workerStatusEd;

        public Integer getWorkerStatusSt(){
            return this.workerStatusSt;
        }

        public Integer getWorkerStatusEd(){
            return this.workerStatusEd;
        }

        private List<String> workerCitizenIdList;


        private List<String> fuzzyWorkerCitizenId;

        public List<String> getFuzzyWorkerCitizenId(){
            return this.fuzzyWorkerCitizenId;
        }

        private List<String> rightFuzzyWorkerCitizenId;

        public List<String> getRightFuzzyWorkerCitizenId(){
            return this.rightFuzzyWorkerCitizenId;
        }
        private List<Integer> workerPoliticalStatusList;

        private Integer workerPoliticalStatusSt;

        private Integer workerPoliticalStatusEd;

        public Integer getWorkerPoliticalStatusSt(){
            return this.workerPoliticalStatusSt;
        }

        public Integer getWorkerPoliticalStatusEd(){
            return this.workerPoliticalStatusEd;
        }

        private QueryBuilder (){
            this.fetchFields = new HashMap<>();
        }


        public QueryBuilder fuzzyId (List<String> fuzzyId){
            this.fuzzyId = fuzzyId;
            return this;
        }

        public QueryBuilder fuzzyId (String ... fuzzyId){
            if (fuzzyId != null){
                List<String> list = new ArrayList<>();
                for (String item : fuzzyId){
                    if (item != null){
                        list.add(item);
                    }
                }
                this.fuzzyId = list;
            }
            return this;
        }

        public QueryBuilder rightFuzzyId (List<String> rightFuzzyId){
            this.rightFuzzyId = rightFuzzyId;
            return this;
        }

        public QueryBuilder rightFuzzyId (String ... rightFuzzyId){
            if (rightFuzzyId != null){
                List<String> list = new ArrayList<>();
                for (String item : rightFuzzyId){
                    if (item != null){
                        list.add(item);
                    }
                }
                this.rightFuzzyId = list;
            }
            return this;
        }

        public QueryBuilder id(String id){
            setId(id);
            return this;
        }

        public QueryBuilder idList(String ... id){
            if (id != null){
                List<String> list = new ArrayList<>();
                for (String item : id){
                    if (item != null){
                        list.add(item);
                    }
                }
                this.idList = list;
            }

            return this;
        }

        public QueryBuilder idList(List<String> id){
            this.idList = id;
            return this;
        }

        public QueryBuilder fetchId(){
            setFetchFields("fetchFields","id");
            return this;
        }

        public QueryBuilder excludeId(){
            setFetchFields("excludeFields","id");
            return this;
        }



        public QueryBuilder fuzzyWorkerId (List<String> fuzzyWorkerId){
            this.fuzzyWorkerId = fuzzyWorkerId;
            return this;
        }

        public QueryBuilder fuzzyWorkerId (String ... fuzzyWorkerId){
            if (fuzzyWorkerId != null){
                List<String> list = new ArrayList<>();
                for (String item : fuzzyWorkerId){
                    if (item != null){
                        list.add(item);
                    }
                }
                this.fuzzyWorkerId = list;
            }
            return this;
        }

        public QueryBuilder rightFuzzyWorkerId (List<String> rightFuzzyWorkerId){
            this.rightFuzzyWorkerId = rightFuzzyWorkerId;
            return this;
        }

        public QueryBuilder rightFuzzyWorkerId (String ... rightFuzzyWorkerId){
            if (rightFuzzyWorkerId != null){
                List<String> list = new ArrayList<>();
                for (String item : rightFuzzyWorkerId){
                    if (item != null){
                        list.add(item);
                    }
                }
                this.rightFuzzyWorkerId = list;
            }
            return this;
        }

        public QueryBuilder workerId(String workerId){
            setWorkerId(workerId);
            return this;
        }

        public QueryBuilder workerIdList(String ... workerId){
            if (workerId != null){
                List<String> list = new ArrayList<>();
                for (String item : workerId){
                    if (item != null){
                        list.add(item);
                    }
                }
                this.workerIdList = list;
            }

            return this;
        }

        public QueryBuilder workerIdList(List<String> workerId){
            this.workerIdList = workerId;
            return this;
        }

        public QueryBuilder fetchWorkerId(){
            setFetchFields("fetchFields","workerId");
            return this;
        }

        public QueryBuilder excludeWorkerId(){
            setFetchFields("excludeFields","workerId");
            return this;
        }



        public QueryBuilder fuzzyWorkerName (List<String> fuzzyWorkerName){
            this.fuzzyWorkerName = fuzzyWorkerName;
            return this;
        }

        public QueryBuilder fuzzyWorkerName (String ... fuzzyWorkerName){
            if (fuzzyWorkerName != null){
                List<String> list = new ArrayList<>();
                for (String item : fuzzyWorkerName){
                    if (item != null){
                        list.add(item);
                    }
                }
                this.fuzzyWorkerName = list;
            }
            return this;
        }

        public QueryBuilder rightFuzzyWorkerName (List<String> rightFuzzyWorkerName){
            this.rightFuzzyWorkerName = rightFuzzyWorkerName;
            return this;
        }

        public QueryBuilder rightFuzzyWorkerName (String ... rightFuzzyWorkerName){
            if (rightFuzzyWorkerName != null){
                List<String> list = new ArrayList<>();
                for (String item : rightFuzzyWorkerName){
                    if (item != null){
                        list.add(item);
                    }
                }
                this.rightFuzzyWorkerName = list;
            }
            return this;
        }

        public QueryBuilder workerName(String workerName){
            setWorkerName(workerName);
            return this;
        }

        public QueryBuilder workerNameList(String ... workerName){
            if (workerName != null){
                List<String> list = new ArrayList<>();
                for (String item : workerName){
                    if (item != null){
                        list.add(item);
                    }
                }
                this.workerNameList = list;
            }

            return this;
        }

        public QueryBuilder workerNameList(List<String> workerName){
            this.workerNameList = workerName;
            return this;
        }

        public QueryBuilder fetchWorkerName(){
            setFetchFields("fetchFields","workerName");
            return this;
        }

        public QueryBuilder excludeWorkerName(){
            setFetchFields("excludeFields","workerName");
            return this;
        }



        public QueryBuilder workerBirthdayBetWeen(java.time.LocalDate workerBirthdaySt,java.time.LocalDate workerBirthdayEd){
            this.workerBirthdaySt = workerBirthdaySt;
            this.workerBirthdayEd = workerBirthdayEd;
            return this;
        }

        public QueryBuilder workerBirthdayGreaterEqThan(java.time.LocalDate workerBirthdaySt){
            this.workerBirthdaySt = workerBirthdaySt;
            return this;
        }
        public QueryBuilder workerBirthdayLessEqThan(java.time.LocalDate workerBirthdayEd){
            this.workerBirthdayEd = workerBirthdayEd;
            return this;
        }


        public QueryBuilder workerBirthday(java.time.LocalDate workerBirthday){
            setWorkerBirthday(workerBirthday);
            return this;
        }

        public QueryBuilder workerBirthdayList(java.time.LocalDate ... workerBirthday){
            if (workerBirthday != null){
                List<java.time.LocalDate> list = new ArrayList<>();
                for (java.time.LocalDate item : workerBirthday){
                    if (item != null){
                        list.add(item);
                    }
                }
                this.workerBirthdayList = list;
            }

            return this;
        }

        public QueryBuilder workerBirthdayList(List<java.time.LocalDate> workerBirthday){
            this.workerBirthdayList = workerBirthday;
            return this;
        }

        public QueryBuilder fetchWorkerBirthday(){
            setFetchFields("fetchFields","workerBirthday");
            return this;
        }

        public QueryBuilder excludeWorkerBirthday(){
            setFetchFields("excludeFields","workerBirthday");
            return this;
        }



        public QueryBuilder workerSexBetWeen(Integer workerSexSt,Integer workerSexEd){
            this.workerSexSt = workerSexSt;
            this.workerSexEd = workerSexEd;
            return this;
        }

        public QueryBuilder workerSexGreaterEqThan(Integer workerSexSt){
            this.workerSexSt = workerSexSt;
            return this;
        }
        public QueryBuilder workerSexLessEqThan(Integer workerSexEd){
            this.workerSexEd = workerSexEd;
            return this;
        }


        public QueryBuilder workerSex(Integer workerSex){
            setWorkerSex(workerSex);
            return this;
        }

        public QueryBuilder workerSexList(Integer ... workerSex){
            if (workerSex != null){
                List<Integer> list = new ArrayList<>();
                for (Integer item : workerSex){
                    if (item != null){
                        list.add(item);
                    }
                }
                this.workerSexList = list;
            }

            return this;
        }

        public QueryBuilder workerSexList(List<Integer> workerSex){
            this.workerSexList = workerSex;
            return this;
        }

        public QueryBuilder fetchWorkerSex(){
            setFetchFields("fetchFields","workerSex");
            return this;
        }

        public QueryBuilder excludeWorkerSex(){
            setFetchFields("excludeFields","workerSex");
            return this;
        }



        public QueryBuilder fuzzyWorkerAddress (List<String> fuzzyWorkerAddress){
            this.fuzzyWorkerAddress = fuzzyWorkerAddress;
            return this;
        }

        public QueryBuilder fuzzyWorkerAddress (String ... fuzzyWorkerAddress){
            if (fuzzyWorkerAddress != null){
                List<String> list = new ArrayList<>();
                for (String item : fuzzyWorkerAddress){
                    if (item != null){
                        list.add(item);
                    }
                }
                this.fuzzyWorkerAddress = list;
            }
            return this;
        }

        public QueryBuilder rightFuzzyWorkerAddress (List<String> rightFuzzyWorkerAddress){
            this.rightFuzzyWorkerAddress = rightFuzzyWorkerAddress;
            return this;
        }

        public QueryBuilder rightFuzzyWorkerAddress (String ... rightFuzzyWorkerAddress){
            if (rightFuzzyWorkerAddress != null){
                List<String> list = new ArrayList<>();
                for (String item : rightFuzzyWorkerAddress){
                    if (item != null){
                        list.add(item);
                    }
                }
                this.rightFuzzyWorkerAddress = list;
            }
            return this;
        }

        public QueryBuilder workerAddress(String workerAddress){
            setWorkerAddress(workerAddress);
            return this;
        }

        public QueryBuilder workerAddressList(String ... workerAddress){
            if (workerAddress != null){
                List<String> list = new ArrayList<>();
                for (String item : workerAddress){
                    if (item != null){
                        list.add(item);
                    }
                }
                this.workerAddressList = list;
            }

            return this;
        }

        public QueryBuilder workerAddressList(List<String> workerAddress){
            this.workerAddressList = workerAddress;
            return this;
        }

        public QueryBuilder fetchWorkerAddress(){
            setFetchFields("fetchFields","workerAddress");
            return this;
        }

        public QueryBuilder excludeWorkerAddress(){
            setFetchFields("excludeFields","workerAddress");
            return this;
        }



        public QueryBuilder fuzzyWorkerNationality (List<String> fuzzyWorkerNationality){
            this.fuzzyWorkerNationality = fuzzyWorkerNationality;
            return this;
        }

        public QueryBuilder fuzzyWorkerNationality (String ... fuzzyWorkerNationality){
            if (fuzzyWorkerNationality != null){
                List<String> list = new ArrayList<>();
                for (String item : fuzzyWorkerNationality){
                    if (item != null){
                        list.add(item);
                    }
                }
                this.fuzzyWorkerNationality = list;
            }
            return this;
        }

        public QueryBuilder rightFuzzyWorkerNationality (List<String> rightFuzzyWorkerNationality){
            this.rightFuzzyWorkerNationality = rightFuzzyWorkerNationality;
            return this;
        }

        public QueryBuilder rightFuzzyWorkerNationality (String ... rightFuzzyWorkerNationality){
            if (rightFuzzyWorkerNationality != null){
                List<String> list = new ArrayList<>();
                for (String item : rightFuzzyWorkerNationality){
                    if (item != null){
                        list.add(item);
                    }
                }
                this.rightFuzzyWorkerNationality = list;
            }
            return this;
        }

        public QueryBuilder workerNationality(String workerNationality){
            setWorkerNationality(workerNationality);
            return this;
        }

        public QueryBuilder workerNationalityList(String ... workerNationality){
            if (workerNationality != null){
                List<String> list = new ArrayList<>();
                for (String item : workerNationality){
                    if (item != null){
                        list.add(item);
                    }
                }
                this.workerNationalityList = list;
            }

            return this;
        }

        public QueryBuilder workerNationalityList(List<String> workerNationality){
            this.workerNationalityList = workerNationality;
            return this;
        }

        public QueryBuilder fetchWorkerNationality(){
            setFetchFields("fetchFields","workerNationality");
            return this;
        }

        public QueryBuilder excludeWorkerNationality(){
            setFetchFields("excludeFields","workerNationality");
            return this;
        }



        public QueryBuilder fuzzyWorkerPhone (List<String> fuzzyWorkerPhone){
            this.fuzzyWorkerPhone = fuzzyWorkerPhone;
            return this;
        }

        public QueryBuilder fuzzyWorkerPhone (String ... fuzzyWorkerPhone){
            if (fuzzyWorkerPhone != null){
                List<String> list = new ArrayList<>();
                for (String item : fuzzyWorkerPhone){
                    if (item != null){
                        list.add(item);
                    }
                }
                this.fuzzyWorkerPhone = list;
            }
            return this;
        }

        public QueryBuilder rightFuzzyWorkerPhone (List<String> rightFuzzyWorkerPhone){
            this.rightFuzzyWorkerPhone = rightFuzzyWorkerPhone;
            return this;
        }

        public QueryBuilder rightFuzzyWorkerPhone (String ... rightFuzzyWorkerPhone){
            if (rightFuzzyWorkerPhone != null){
                List<String> list = new ArrayList<>();
                for (String item : rightFuzzyWorkerPhone){
                    if (item != null){
                        list.add(item);
                    }
                }
                this.rightFuzzyWorkerPhone = list;
            }
            return this;
        }

        public QueryBuilder workerPhone(String workerPhone){
            setWorkerPhone(workerPhone);
            return this;
        }

        public QueryBuilder workerPhoneList(String ... workerPhone){
            if (workerPhone != null){
                List<String> list = new ArrayList<>();
                for (String item : workerPhone){
                    if (item != null){
                        list.add(item);
                    }
                }
                this.workerPhoneList = list;
            }

            return this;
        }

        public QueryBuilder workerPhoneList(List<String> workerPhone){
            this.workerPhoneList = workerPhone;
            return this;
        }

        public QueryBuilder fetchWorkerPhone(){
            setFetchFields("fetchFields","workerPhone");
            return this;
        }

        public QueryBuilder excludeWorkerPhone(){
            setFetchFields("excludeFields","workerPhone");
            return this;
        }



        public QueryBuilder workerStatusBetWeen(Integer workerStatusSt,Integer workerStatusEd){
            this.workerStatusSt = workerStatusSt;
            this.workerStatusEd = workerStatusEd;
            return this;
        }

        public QueryBuilder workerStatusGreaterEqThan(Integer workerStatusSt){
            this.workerStatusSt = workerStatusSt;
            return this;
        }
        public QueryBuilder workerStatusLessEqThan(Integer workerStatusEd){
            this.workerStatusEd = workerStatusEd;
            return this;
        }


        public QueryBuilder workerStatus(Integer workerStatus){
            setWorkerStatus(workerStatus);
            return this;
        }

        public QueryBuilder workerStatusList(Integer ... workerStatus){
            if (workerStatus != null){
                List<Integer> list = new ArrayList<>();
                for (Integer item : workerStatus){
                    if (item != null){
                        list.add(item);
                    }
                }
                this.workerStatusList = list;
            }

            return this;
        }

        public QueryBuilder workerStatusList(List<Integer> workerStatus){
            this.workerStatusList = workerStatus;
            return this;
        }

        public QueryBuilder fetchWorkerStatus(){
            setFetchFields("fetchFields","workerStatus");
            return this;
        }

        public QueryBuilder excludeWorkerStatus(){
            setFetchFields("excludeFields","workerStatus");
            return this;
        }



        public QueryBuilder fuzzyWorkerCitizenId (List<String> fuzzyWorkerCitizenId){
            this.fuzzyWorkerCitizenId = fuzzyWorkerCitizenId;
            return this;
        }

        public QueryBuilder fuzzyWorkerCitizenId (String ... fuzzyWorkerCitizenId){
            if (fuzzyWorkerCitizenId != null){
                List<String> list = new ArrayList<>();
                for (String item : fuzzyWorkerCitizenId){
                    if (item != null){
                        list.add(item);
                    }
                }
                this.fuzzyWorkerCitizenId = list;
            }
            return this;
        }

        public QueryBuilder rightFuzzyWorkerCitizenId (List<String> rightFuzzyWorkerCitizenId){
            this.rightFuzzyWorkerCitizenId = rightFuzzyWorkerCitizenId;
            return this;
        }

        public QueryBuilder rightFuzzyWorkerCitizenId (String ... rightFuzzyWorkerCitizenId){
            if (rightFuzzyWorkerCitizenId != null){
                List<String> list = new ArrayList<>();
                for (String item : rightFuzzyWorkerCitizenId){
                    if (item != null){
                        list.add(item);
                    }
                }
                this.rightFuzzyWorkerCitizenId = list;
            }
            return this;
        }

        public QueryBuilder workerCitizenId(String workerCitizenId){
            setWorkerCitizenId(workerCitizenId);
            return this;
        }

        public QueryBuilder workerCitizenIdList(String ... workerCitizenId){
            if (workerCitizenId != null){
                List<String> list = new ArrayList<>();
                for (String item : workerCitizenId){
                    if (item != null){
                        list.add(item);
                    }
                }
                this.workerCitizenIdList = list;
            }

            return this;
        }

        public QueryBuilder workerCitizenIdList(List<String> workerCitizenId){
            this.workerCitizenIdList = workerCitizenId;
            return this;
        }

        public QueryBuilder fetchWorkerCitizenId(){
            setFetchFields("fetchFields","workerCitizenId");
            return this;
        }

        public QueryBuilder excludeWorkerCitizenId(){
            setFetchFields("excludeFields","workerCitizenId");
            return this;
        }



        public QueryBuilder workerPoliticalStatusBetWeen(Integer workerPoliticalStatusSt,Integer workerPoliticalStatusEd){
            this.workerPoliticalStatusSt = workerPoliticalStatusSt;
            this.workerPoliticalStatusEd = workerPoliticalStatusEd;
            return this;
        }

        public QueryBuilder workerPoliticalStatusGreaterEqThan(Integer workerPoliticalStatusSt){
            this.workerPoliticalStatusSt = workerPoliticalStatusSt;
            return this;
        }
        public QueryBuilder workerPoliticalStatusLessEqThan(Integer workerPoliticalStatusEd){
            this.workerPoliticalStatusEd = workerPoliticalStatusEd;
            return this;
        }


        public QueryBuilder workerPoliticalStatus(Integer workerPoliticalStatus){
            setWorkerPoliticalStatus(workerPoliticalStatus);
            return this;
        }

        public QueryBuilder workerPoliticalStatusList(Integer ... workerPoliticalStatus){
            if (workerPoliticalStatus != null){
                List<Integer> list = new ArrayList<>();
                for (Integer item : workerPoliticalStatus){
                    if (item != null){
                        list.add(item);
                    }
                }
                this.workerPoliticalStatusList = list;
            }

            return this;
        }

        public QueryBuilder workerPoliticalStatusList(List<Integer> workerPoliticalStatus){
            this.workerPoliticalStatusList = workerPoliticalStatus;
            return this;
        }

        public QueryBuilder fetchWorkerPoliticalStatus(){
            setFetchFields("fetchFields","workerPoliticalStatus");
            return this;
        }

        public QueryBuilder excludeWorkerPoliticalStatus(){
            setFetchFields("excludeFields","workerPoliticalStatus");
            return this;
        }

        public QueryBuilder fetchAll(){
            this.fetchFields.put("AllFields",true);
            return this;
        }

        public QueryBuilder addField(String ... fields){
            List<String> list = new ArrayList<>();
            if (fields != null){
                for (String field : fields){
                    list.add(field);
                }
            }
            this.fetchFields.put("otherFields",list);
            return this;
        }
        @SuppressWarnings("unchecked")
        private void setFetchFields(String key,String val){
            Map<String,Boolean> fields= (Map<String, Boolean>) this.fetchFields.get(key);
            if (fields == null){
                fields = new HashMap<>();
            }
            fields.put(val,true);
            this.fetchFields.put(key,fields);
        }

        public AdministrationOffice build(){
            return this;
        }
    }

}
