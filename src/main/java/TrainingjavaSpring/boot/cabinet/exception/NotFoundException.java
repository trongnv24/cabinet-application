package TrainingjavaSpring.boot.cabinet.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {
    private String message;
    private String id;
    private String objectName;
   public NotFoundException ( String message, String id, String objectName){
       this.message = message;
       this.id = id;
       this.objectName = objectName;
   }
}
