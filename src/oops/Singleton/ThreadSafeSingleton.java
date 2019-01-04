package oops.Singleton;




public class ThreadSafeSingleton{
	
private static ThreadSafeSingleton instance;

ThreadSafeSingleton(){}

public static synchronized ThreadSafeSingleton getInstance(){
	 if(instance == null){
	        synchronized (ThreadSafeSingleton.class) {
	            if(instance == null){
	                instance = new ThreadSafeSingleton();
	            }
	        }
	    }
	    return instance;
 	}
}