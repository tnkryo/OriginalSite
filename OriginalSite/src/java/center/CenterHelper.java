package center;

import java.util.ArrayList;

/**
 *
 * @author kobayashi
 */
public class CenterHelper {
    
    //トップへのリンクを定数として設定
    private final String homeURL = "top.jsp";
    
    public static CenterHelper getInstance(){
        return new CenterHelper();
    }
    
    //トップへのリンクを返却
    public String home(){
        return "<a href=\""+homeURL+"\">トップへ戻る</a>";
    }
    
    //お問い合わせへのリンクを定数として設定
    private final String conURL = "Contact";
    
    //お問い合わせへのリンクを返却
    public String contact(){
        return "<a href=\""+conURL+"\">お問い合わせ</a>";
    }
    
    public String chkinput(ArrayList<String> chkList){
        String output = "";
        for(String val : chkList){
                if(val.equals("name")){
                    output += "店舗名";
                }
                if(val.equals("jusyo")){
                    output +="住所";
                }
                output +="が未記入です<br>";
            }
        return output;
    }
    
    public String coninput(ArrayList<String> chkList){
        String output = "";
        for(String val : chkList){
                if(val.equals("name")){
                    output += "名前";
                }
                if(val.equals("comment")){
                    output +="内容";
                }
                output +="が未記入です<br>";
            }
        return output;
    }
    
    public String input(CenterBeans cb){
        String output = "";
        if(!cb.getTell().equals("")){
                output += "電話番号:<br>"+cb.getTell()+"<br><br>";
            }
            if(!cb.getTime().equals("")){
                output += "営業時間:<br>"+cb.getTime()+"<br><br>";
            }
            if(!cb.getSite().equals("")){
                output += "公式サイト:<br>"+cb.getSite()+"<br><br>";
            }
            if(!cb.getBlog().equals("")){
                output += "公式ブログ:<br>"+cb.getBlog()+"<br><br>";
            }
            if(!cb.getTwitter().equals("")){
                output += "Twitter ID:<br>"+cb.getTwitter()+"<br><br>";
            }
            if(!cb.getKyoutai().equals("")){
                String kyoutai = cb.getKyoutai().replaceAll("\n","<BR>");
                output += "筐体:<br>"+kyoutai+"<br><br>";
            }
            if(!cb.getComment().equals("")){
                String comment = cb.getComment().replaceAll("\n","<BR>");
                output += "備考:<br>"+comment+"<br><br>";
            }
            return output;
    }
}
