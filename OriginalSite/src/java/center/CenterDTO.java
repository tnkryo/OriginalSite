/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package center;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author kobayashi
 */
public class CenterDTO {
    private int tenpoID;
    private String name;
    private String jusyo;
    private double lat;
    private double lng;
    private String tell;
    private String time;
    private String site;
    private String blog;
    private String twitter;
    private String kyoutai;
    private String comment;
    private Timestamp newDate;
    
    public int getTenpoID() {
        return tenpoID;
    }
    public void setTenpoID(int tenpoID) {
        this.tenpoID = tenpoID;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public String getJusyo(){
        return jusyo;
    }
    public void setJusyo(String jusyo){
        this.jusyo = jusyo;
    }
    
    public double getLat(){
        return lat;
    }
    public void setLat(double lat){
        this.lat = lat;
    }
    
    public double getLng(){
        return lng;
    }
    public void setLng(double lng){
        this.lng = lng;
    }
    
    public String getTell(){
        return tell;
    }
    public void setTell(String tell){
        this.tell = tell;
    }
    
    public String getTime(){
        return time;
    }
    public void setTime(String time){
        this.time = time;
    }
    
    public String getSite(){
        return site;
    }
    public void setSite(String site){
        this.site = site;
    }
    
    public String getBlog(){
        return blog;
    }
    public void setBlog(String blog){
        this.blog = blog;
    }
    
    public String getTwitter(){
        return twitter;
    }
    public void setTwitter(String twitter){
        this.twitter = twitter;
    }
    
    public String getKyoutai(){
        return kyoutai;
    }
    public void setKyoutai(String kyoutai){
        this.kyoutai = kyoutai;
    }
    
    public String getComment(){
        return comment;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    
    public Timestamp getNewDate() {
        return newDate;
    }
    
    public void setNewDate(Timestamp newDate) {
        this.newDate = newDate;
    }
    
}
