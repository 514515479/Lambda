import lombok.Data;

/**
 * @Author: tobi
 * @Date: 2020/5/4 16:09
 **/
@Data
public class Employee {

    private String name;
    private Integer age;
    private Status status;

    public Employee() {}

    public Employee(String name, Integer age, Status status) {
        this.age = age;
        this.name = name;
        this.status = status;
    }

    public Employee(String name) {
        this.name = name;
    }
    
    public enum Status {
		FREE,
		BUSY,
		VOCATION;
	}
}
