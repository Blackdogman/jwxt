package com.jwxt.model.sc;

import java.util.Date;

public class ScAdmini {
    private String id;

    private String workerId;

    private String workerName;

    private Date workerBirthday;

    private Integer workerSex;

    private String workerAddress;

    private String workerNationality;

    private String workerPhone;

    private Integer workerStatus;

    private String workerCitizenId;

    private Integer workerPoliticalStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public Date getWorkerBirthday() {
        return workerBirthday;
    }

    public void setWorkerBirthday(Date workerBirthday) {
        this.workerBirthday = workerBirthday;
    }

    public Integer getWorkerSex() {
        return workerSex;
    }

    public void setWorkerSex(Integer workerSex) {
        this.workerSex = workerSex;
    }

    public String getWorkerAddress() {
        return workerAddress;
    }

    public void setWorkerAddress(String workerAddress) {
        this.workerAddress = workerAddress;
    }

    public String getWorkerNationality() {
        return workerNationality;
    }

    public void setWorkerNationality(String workerNationality) {
        this.workerNationality = workerNationality;
    }

    public String getWorkerPhone() {
        return workerPhone;
    }

    public void setWorkerPhone(String workerPhone) {
        this.workerPhone = workerPhone;
    }

    public Integer getWorkerStatus() {
        return workerStatus;
    }

    public void setWorkerStatus(Integer workerStatus) {
        this.workerStatus = workerStatus;
    }

    public String getWorkerCitizenId() {
        return workerCitizenId;
    }

    public void setWorkerCitizenId(String workerCitizenId) {
        this.workerCitizenId = workerCitizenId;
    }

    public Integer getWorkerPoliticalStatus() {
        return workerPoliticalStatus;
    }

    public void setWorkerPoliticalStatus(Integer workerPoliticalStatus) {
        this.workerPoliticalStatus = workerPoliticalStatus;
    }

	@Override
	public String toString() {
		return "ScAdmini [id=" + id + ", workerId=" + workerId + ", workerName=" + workerName + ", workerBirthday="
				+ workerBirthday + ", workerSex=" + workerSex + ", workerAddress=" + workerAddress
				+ ", workerNationality=" + workerNationality + ", workerPhone=" + workerPhone + ", workerStatus="
				+ workerStatus + ", workerCitizenId=" + workerCitizenId + ", workerPoliticalStatus="
				+ workerPoliticalStatus + "]";
	}

	public ScAdmini(String id, String workerId, String workerName, Date workerBirthday, Integer workerSex,
                    String workerAddress, String workerNationality, String workerPhone, Integer workerStatus,
                    String workerCitizenId, Integer workerPoliticalStatus) {
		super();
		this.id = id;
		this.workerId = workerId;
		this.workerName = workerName;
		this.workerBirthday = workerBirthday;
		this.workerSex = workerSex;
		this.workerAddress = workerAddress;
		this.workerNationality = workerNationality;
		this.workerPhone = workerPhone;
		this.workerStatus = workerStatus;
		this.workerCitizenId = workerCitizenId;
		this.workerPoliticalStatus = workerPoliticalStatus;
	}

	public ScAdmini() {
		super();
	}
    
}