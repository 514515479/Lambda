import lombok.Data;

/**
 * @Author: tobi
 * @Date: 2020/5/4 16:09
 **/
@Data
public class Employee {

    private String name;
    private Integer age;

    public Employee() {}

    public Employee(String name, Integer age) {
        this.age = age;
        this.name = name;
    }

    public Employee(String name) {
        this.name = name;
    }
}
