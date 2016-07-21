/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package center;

import java.net.URLEncoder;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author kobayashi
 */
public class CenterSystem {
    
    //地名から座標を取得するメソッド
    public static HashMap<String, Double> getLatLng(String address) throws Exception{
        HashMap<String, Double> latlngMap = new HashMap<String, Double>();
        double lat=0.0;
        double lng=0.0;
        String query4url = URLEncoder.encode(address, "UTF-8");
        String url = "http://www.geocoding.jp/api/?q=" + query4url;
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse(url);
        Element root = document.getDocumentElement();
        
        //ルート要素の子ノードを取得する
        NodeList rootChildren = root.getChildNodes();
        
        for(int i=0; i<rootChildren.getLength(); i++){
            Node node = rootChildren.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element)node;
                if(element.getNodeName().equals("coordinate")){
                    NodeList coordinateChildren = node.getChildNodes();
                    
                    for(int j=0; j<coordinateChildren.getLength(); j++){
                        Node coordinateNode = coordinateChildren.item(j);
                        if(coordinateNode.getNodeType() == Node.ELEMENT_NODE){
                            Element coordinateElement = (Element)coordinateNode;
                            if(coordinateElement.getNodeName().equals("lat")){
                                lat = Double.parseDouble(coordinateElement.getTextContent());
                            }
                            if(coordinateElement.getNodeName().equals("lng")){
                                lng = Double.parseDouble(coordinateElement.getTextContent());
                            }
                        }
                    }
                }
            }
        }
        latlngMap.put("lat", lat);
        latlngMap.put("lng", lng);
        
        return latlngMap;
    }
    
}
