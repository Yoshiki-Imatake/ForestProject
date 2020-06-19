package my_work;

public class Test {

	public static void main(String[] args) {
		
		Forest forest = new Forest();
		
		for (int i=0; i<100; i++) {
			for (int j=0; j<100; j++) {
				Tree tree = forest.checkTree(j, i);
				if (tree != null) {
					System.out.print(tree.getHeight()+ " ");
				}else {
					System.out.print("   ");
				}
			}
			System.out.println("");
		}
		
		/*
		Animal mark = new Squirrel(99,99,0);
		System.out.println("リスが生成された。");
		System.out.println("リスは3のエネルギーを持っている。");
		System.out.println("これからリスは森を駆け回り、木の実を探す。");
		System.out.println("木の実1個でエネルギーは１増加する。");
		System.out.println("エネルギーが５になるとリスは満腹になる。");
		mark.move();
		*/

	}

}
