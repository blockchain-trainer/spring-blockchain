package in.bt.demochain.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    
    public Date getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
 
    private Date timeStamp;
    private String from;
    private String data;
  
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return new SimpleDateFormat().format(timeStamp) + "from " + from + " data "+ data;
    }

}
