package Lesson4;

public class Main2 {
	public static void main(String[] args) {
		/*Header header = new IndexHeader();
		Body body = new IndexBody();
		Footer footer = new IndexFooter();
		Engine engine = new Engine(header, body, footer);
		engine.printPage();
		Body leftSide=new LeftSiderBarBody();
		Engine left=new Engine(header,leftSide, footer);
		System.out.println();
		left.printPage();
		Body rightSide=new RightSideBarBody();
		Engine right=new Engine(header,rightSide, footer);
		System.out.println();
		right.printPage();
		Engine rightWithoutFooter=new Engine(header,rightSide, null);
		System.out.println();
		rightWithoutFooter.printPage();
		*/
		
		Engine engine = new Engine(new IndexHeader(), new IndexBody(), new IndexFooter());
		engine.printPage();
		Engine left=new Engine(engine,new LeftSiderBarBody(), engine);
		System.out.println();
		left.printPage();
		Engine right=new Engine(engine,new RightSideBarBody(), engine);
		System.out.println();
		right.printPage();
		Engine rightWithoutFooter=new Engine(engine,right, null);
		System.out.println();
		rightWithoutFooter.printPage();
	}
}
