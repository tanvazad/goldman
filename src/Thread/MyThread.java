package Thread;

public class MyThread extends Thread{
	
	public static void main(String args[]){
		
		A a = new A();
		a.start();
		Thread b = new Thread(new B());
		b.start();
	}

}

class A extends Thread{
	
	protected int i=0;
	
	public void run(){		
		while(i<4){
			System.out.println(i++);
		}
		System.out.print("Thread ends\n");
	}	
	
}


class B implements Runnable{
	
	protected int i=0;
	public void run(){
		while(i<4){
			System.out.println(i++);
		}
	}
}
