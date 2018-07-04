package com.jwxt.model.zys.dictionary;

public class ZysDictionary {
	/**id */
    private Integer id;
    /**代码 */
    private Integer code;
    /**对应名称 */
    private String name;
    /**字典类型 */
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

	public ZysDictionary() {
		super();
	}

	public ZysDictionary(Integer id, Integer code, String name, String type) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.type = type;
	}

	@Override
	public String toString() {
		return "ZysDictionary [id=" + id + ", code=" + code + ", name=" + name + ", type=" + type + "]";
	}
    
}