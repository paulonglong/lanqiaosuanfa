package lwl.ouc.future;

public class FutureData implements Data {

    // 内部需要维护RealData
    protected RealData realdata = null;          
    protected boolean isReady = false;
    
    public synchronized void setRealData(RealData realdata) {
        if (isReady) { 
            return;
        }
        this.realdata = realdata;
        isReady = true;
        //RealData已经被注入，通知getResult()
        notifyAll();                                        
    }
    
    //会等待RealData构造完成
    public synchronized String getResult() {            
        while (!isReady) {
            try {
                //一直等待，直到RealData被注入
                System.out.println("我正在等待realData的完成通知");
                wait();                                 
            } catch (InterruptedException e) {
            }
        }
        //真正需要的数据从RealData获取
        return realdata.result;                         
    }
}
