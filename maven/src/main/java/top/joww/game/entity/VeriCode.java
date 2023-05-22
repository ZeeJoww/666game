package top.joww.game.entity;

public class VeriCode {
    private String email;
    private String code;
    
    public VeriCode() {
    	super();
    }

    public VeriCode(String email) {
		super();
		this.email = email;
	}
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
