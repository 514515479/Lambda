import lombok.Data;

@Data
public class Godness {

	private String name;

	public Godness() {}

	public Godness(String name) {
		this.name = name;
	}
}
