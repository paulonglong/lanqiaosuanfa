 package lwl.ouc.rmi;

 import java.rmi.RemoteException;
 import java.time.LocalDateTime;
 import java.time.ZoneId;

 /**
  * @author wlli
  * @date 2021/07/23
  */
 public class WorldClockService implements WorldClock {
     @Override
     public LocalDateTime getLocalDateTime(String zoneId) throws RemoteException {
         return LocalDateTime.now(ZoneId.of(zoneId)).withNano(0);
     }
 }