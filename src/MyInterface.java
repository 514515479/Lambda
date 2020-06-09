public interface MyInterface {

	default String getName() {
		return "MyInterface";
	}

	public static String name(){
		return "接口中的默认方法";
	}
}
