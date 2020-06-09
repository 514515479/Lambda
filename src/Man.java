import lombok.Data;

@Data
public class Man {

	private Godness godness;

	public Man() {}

	public Man(Godness godness) {
		this.godness = godness;
	}
}
