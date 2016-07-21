/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package center;

import base.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author kobayashi
 */
public class CenterDAO {
    
    //インスタンスオブジェクトを返却させてコードの簡略化
    public static CenterDAO getInstance(){
        return new CenterDAO();
    }
    
    /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void insert(CenterDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO tenpo_t(name,jusyo,lat,lng,tell,time,site,blog,twitter,kyoutai,comment,newDate) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setString(1, ud.getName());
            st.setString(2, ud.getJusyo());
            st.setDouble(3, ud.getLat());
            st.setDouble(4, ud.getLng());
            st.setString(5, ud.getTell());
            st.setString(6, ud.getTime());
            st.setString(7, ud.getSite());
            st.setString(8, ud.getBlog());
            st.setString(9, ud.getTwitter());
            st.setString(10, ud.getKyoutai());
            st.setString(11, ud.getComment());
            st.setTimestamp(12, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void coninsert(CenterDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO info_t(name,comment) VALUES(?,?)");
            st.setString(1, ud.getName());
            st.setString(2, ud.getComment());
            st.executeUpdate();
            System.out.println("insert completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * データの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public ArrayList<CenterDTO> search(String ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            st =  con.prepareStatement("SELECT * FROM tenpo_t WHERE name like ?");
            
            st.setString(1, "%"+ud+"%");
            
            ResultSet rs = st.executeQuery();
            
            
            ArrayList<CenterDTO> al = new ArrayList<CenterDTO>();
            while(rs.next()){
            CenterDTO resultUd = new CenterDTO();
            resultUd.setTenpoID(rs.getInt(1));
            resultUd.setName(rs.getString(2));
            resultUd.setJusyo(rs.getString(3));
            resultUd.setLat(rs.getDouble(4));
            resultUd.setLng(rs.getDouble(5));
            resultUd.setTell(rs.getString(6));
            resultUd.setTime(rs.getString(7));
            resultUd.setSite(rs.getString(8));
            resultUd.setBlog(rs.getString(9));
            resultUd.setTwitter(rs.getString(10));
            resultUd.setKyoutai(rs.getString(11));
            resultUd.setComment(rs.getString(12));
            resultUd.setNewDate(rs.getTimestamp(13));
            al.add(resultUd);
            }
            System.out.println("search completed");

            return al;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * IDによるデータの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public CenterDTO searchByID(int id) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            String sql = "SELECT * FROM tenpo_t WHERE tenpoID = ?";
            
            st =  con.prepareStatement(sql);
            st.setInt(1, id);
            
            ResultSet rs = st.executeQuery();
            rs.next();
            CenterDTO resultUd = new CenterDTO();
            resultUd.setTenpoID(rs.getInt(1));
            resultUd.setName(rs.getString(2));
            resultUd.setJusyo(rs.getString(3));
            resultUd.setLat(rs.getDouble(4));
            resultUd.setLng(rs.getDouble(5));
            resultUd.setTell(rs.getString(6));
            resultUd.setTime(rs.getString(7));
            resultUd.setSite(rs.getString(8));
            resultUd.setBlog(rs.getString(9));
            resultUd.setTwitter(rs.getString(10));
            resultUd.setKyoutai(rs.getString(11));
            resultUd.setComment(rs.getString(12));
            resultUd.setNewDate(rs.getTimestamp(13));
            
            System.out.println("searchByID completed");

            return resultUd;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    public void update(CenterDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("UPDATE tenpo_t SET name = ?,jusyo = ?,lat = ?,lng = ?,tell = ?,time = ?,site = ?,blog = ?,twitter = ?,kyoutai = ?,comment = ?,newdate = ? WHERE tenpoID = ?");
            st.setString(1, ud.getName());
            st.setString(2, ud.getJusyo());
            st.setDouble(3, ud.getLat());
            st.setDouble(4, ud.getLng());
            st.setString(5, ud.getTell());
            st.setString(6, ud.getTime());
            st.setString(7, ud.getSite());
            st.setString(8, ud.getBlog());
            st.setString(9, ud.getTwitter());
            st.setString(10, ud.getKyoutai());
            st.setString(11, ud.getComment());
            st.setTimestamp(12, new Timestamp(System.currentTimeMillis()));
            st.setInt(13, ud.getTenpoID());
            st.executeUpdate();
            System.out.println("update completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    public ArrayList<CenterDTO> allsearch() throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            st =  con.prepareStatement("SELECT * FROM tenpo_t");
            
            ResultSet rs = st.executeQuery();
            
            
            ArrayList<CenterDTO> al = new ArrayList<CenterDTO>();
            while(rs.next()){
            CenterDTO resultUd = new CenterDTO();
            resultUd.setTenpoID(rs.getInt(1));
            resultUd.setName(rs.getString(2));
            resultUd.setJusyo(rs.getString(3));
            resultUd.setLat(rs.getDouble(4));
            resultUd.setLng(rs.getDouble(5));
            resultUd.setTell(rs.getString(6));
            resultUd.setTime(rs.getString(7));
            resultUd.setSite(rs.getString(8));
            resultUd.setBlog(rs.getString(9));
            resultUd.setTwitter(rs.getString(10));
            resultUd.setKyoutai(rs.getString(11));
            resultUd.setComment(rs.getString(12));
            resultUd.setNewDate(rs.getTimestamp(13));
            al.add(resultUd);
            }
            System.out.println("search completed");

            return al;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
}
