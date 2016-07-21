/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package center;

import static center.CenterSystem.getLatLng;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author kobayashi
 */
public class CenterBeans implements Serializable{
    private int tenpoID;
    private String name;
    private String jusyo;
    private String tell;
    private String time;
    private String site;
    private String blog;
    private String twitter;
    private String kyoutai;
    private String comment;
    private Timestamp newDate;
    
    public CenterBeans(){
        this.tenpoID = 0;
        this.name = "";
        this.jusyo = "";
        this.tell = "";
        this.time = "";
        this.site = "";
        this.blog = "";
        this.twitter = "";
        this.kyoutai = "";
        this.comment= "";
    }
    
    public int getTenpoID(){
        return tenpoID;
    }
    
    public void setTenpoID(int tenpoID){
        this.tenpoID=tenpoID;
        }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        //空文字(未入力)の場合空文字をセット
        if(name.trim().length()==0){
            this.name = "";
        }else{
            this.name = name;
        }
    }
    
    public String getJusyo() {
        return jusyo;
    }
    public void setJusyo(String jusyo) {
        //空文字(未入力)の場合空文字をセット
        if(jusyo.trim().length()==0){
            this.jusyo = "";
        }else{
            this.jusyo = jusyo;
        }
    }
    
    public String getTell() {
        return tell;
    }
    public void setTell(String tell) {
        //空文字(未入力)の場合空文字をセット
        if(tell.trim().length()==0){
            this.tell = "";
        }else{
            this.tell = tell;
        }
    }
    
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        //空文字(未入力)の場合空文字をセット
        if(time.trim().length()==0){
            this.time = "";
        }else{
            this.time = time;
        }
    }
    
    public String getSite() {
        return site;
    }
    public void setSite(String site) {
        //空文字(未入力)の場合空文字をセット
        if(site.trim().length()==0){
            this.site = "";
        }else{
            this.site = site;
        }
    }
    
    public String getBlog() {
        return blog;
    }
    public void setBlog(String blog) {
        //空文字(未入力)の場合空文字をセット
        if(blog.trim().length()==0){
            this.blog = "";
        }else{
            this.blog = blog;
        }
    }
    
    public String getTwitter() {
        return twitter;
    }
    public void setTwitter(String twitter) {
        //空文字(未入力)の場合空文字をセット
        if(twitter.trim().length()==0){
            this.twitter = "";
        }else{
            this.twitter = twitter;
        }
    }
    
    public String getKyoutai() {
        return kyoutai;
    }
    public void setKyoutai(String kyoutai) {
        //空文字(未入力)の場合空文字をセット
        if(kyoutai.trim().length()==0){
            this.kyoutai = "";
        }else{
            this.kyoutai = kyoutai;
        }
    }
    
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        //空文字(未入力)の場合空文字をセット
        if(comment.trim().length()==0){
            this.comment = "";
        }else{
            this.comment = comment;
        }
    }
    
    public Timestamp getNewDate(){
        return newDate;
    }
    
    public void setNewDate(Timestamp newDate){
        this.newDate = newDate;
    }
    
    public ArrayList<String> chkproperties(){
        ArrayList<String> chkList = new ArrayList<String>();
        if(this.name.equals("")){
            chkList.add("name");
        }
        if(this.jusyo.equals("")){
            chkList.add("jusyo");
        }
        
        return chkList;
    }
    
    public ArrayList<String> conproperties(){
        ArrayList<String> chkList = new ArrayList<String>();
        if(this.name.equals("")){
            chkList.add("name");
        }
        if(this.comment.equals("")){
            chkList.add("comment");
        }
        
        return chkList;
    }
    
    public void UD2DTOMapping(CenterDTO udd) throws Exception{
        udd.setTenpoID(this.tenpoID);
        udd.setName(this.name);
        udd.setJusyo(this.jusyo);
        HashMap<String, Double> latlngMap = getLatLng(jusyo);
        udd.setLat(latlngMap.get("lat"));
        udd.setLng(latlngMap.get("lng"));
        udd.setTell(this.tell);
        udd.setTime(this.time);
        udd.setSite(this.site);
        udd.setBlog(this.blog);
        udd.setTwitter(this.twitter);
        udd.setKyoutai(this.kyoutai);
        udd.setComment(this.comment);
    }
    
    public void UD2BeansMapping(CenterDTO udd){
        this.tenpoID=udd.getTenpoID();
        this.name=udd.getName();
        this.jusyo=udd.getJusyo();
        this.tell=udd.getTell();
        this.time=udd.getTime();
        this.site=udd.getSite();
        this.blog=udd.getBlog();
        this.twitter=udd.getTwitter();
        this.kyoutai=udd.getKyoutai();
        this.comment=udd.getComment();
        this.newDate=udd.getNewDate();
    }
}
