package com.jwxt.model.ydj;

public class YdjDiction {
    private Integer id;

    private Integer code;

    private String name;

    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

	@Override
	public String toString() {
		return "YdjDiction [id=" + id + ", code=" + code + ", name=" + name + ", type=" + type + "]";
	}
    
}