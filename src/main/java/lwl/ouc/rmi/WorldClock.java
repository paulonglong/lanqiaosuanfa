 package lwl.ouc.rmi;

 import java.rmi.Remote;
 import java.rmi.RemoteException;
 import java.time.LocalDateTime;

 /**
  * @author wlli
  * @date 2021/07/23
  */
 public interface WorldClock extends Remote {
     LocalDateTime getLocalDateTime(String zoneId) throws RemoteException;
 }