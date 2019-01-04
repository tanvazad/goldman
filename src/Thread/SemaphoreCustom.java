package Thread;

public class SemaphoreCustom {
	
	private int permit=0;
	static int SharedValue;
	
	public SemaphoreCustom(int permit){
		this.permit=permit;
	}
	
	public synchronized void acquire() throws InterruptedException{		
		
			if(permit>0)permit--;
			
			else{
				this.wait();
				permit--;
			}
		
	} 
	
	public synchronized void release() throws InterruptedException{
		
			permit++;
			
			if(permit>0)
				this.notifyAll();	
	}
	
	public static void main(String args[]){
		
		SemaphoreCustom semaphore = new SemaphoreCustom(1);
		System.out.println("Semaphore with 1 permit has been created");
		
		IncrementThread incrementThread=new IncrementThread(semaphore);
        new Thread(incrementThread,"incrementThread").start();
        
        DecrementThread decrementThread=new DecrementThread(semaphore);
        new Thread(decrementThread,"decrementThread").start();
	}

}

class IncrementThread implements Runnable{
	 
    SemaphoreCustom semaphoreCustom;
    
    public IncrementThread(SemaphoreCustom semaphoreCustom) {
           this.semaphoreCustom=semaphoreCustom;        
    }
    
    public void run(){
           System.out.println(Thread.currentThread().getName()+
                        " is waiting for permit");
           try {
                  semaphoreCustom.acquire();
                  System.out.println(Thread.currentThread().getName()+
                               " has got permit");
           
                  for(int i=0;i<5;i++){
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName()+
                                      " > "+SemaphoreCustom.SharedValue++);
                  }
                  
           } catch (InterruptedException e) {
                  e.printStackTrace();
           }
           
           System.out.println(Thread.currentThread().getName()+
                        " has released permit");
           try {
			semaphoreCustom.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    }
    
}
 
class DecrementThread implements Runnable{
 
    SemaphoreCustom semaphoreCustom;
    public DecrementThread(SemaphoreCustom semaphoreCustom){
           this.semaphoreCustom=semaphoreCustom;
    }
    
    public void run(){
           System.out.println(Thread.currentThread().getName()+
                        " is waiting for permit");
           
           try {
                  semaphoreCustom.acquire();
                  System.out.println(Thread.currentThread().getName()+
                               " has got permit");
           
                  for(int i=0;i<5;i++){          
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName()+
                                      " >"+SemaphoreCustom.SharedValue--);
                  }
                  
           } catch (InterruptedException e) {
                  e.printStackTrace();
           }
           
           
           System.out.println(Thread.currentThread().getName()+
                        " has released permit");
           try {
			semaphoreCustom.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           
           
    }
    
}
