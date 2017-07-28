
public class Test {

	public static void main(String[] args) {
		new Test();

	}

	public Test() {
		String str = fact(104d).toString();
		System.out.println(str);
		System.out.println(str.substring(15));
	}

	public Double fact(Double n) {
		if (n == 1 ) return 1d;
		return n * fact(n-1);
	}
}
