package lwl.ouc.future;

public class RealData implements Data {

    protected final String result;
    
    public RealData(String para) {
        StringBuffer sb=new StringBuffer(para);
        //假设这里很慢很慢，构造RealData不是一个容易的事
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sb.append(i);
        }
        result =sb.toString();
    }
    public String getResult() {
        return result;
    }
}
