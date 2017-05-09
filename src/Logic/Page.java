/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Marcg
 */
class Page {
    HashMap<BusinessWidget, String> widgets;
    ArrayList<BusinessWidget> specificWidgets;
    String desc;
    int id;
    
    Page(int id, String desc, HashMap<BusinessWidget, String> widgets){
        this.widgets = widgets;
        this.desc = desc;
        this.id = id;
    }
    
    
    ArrayList<BusinessWidget> getTopWidgets(){
        specificWidgets.clear();
        for(BusinessWidget s: widgets.keySet()){
            if(widgets.get(s).equals("top")){
                specificWidgets.add(s);
            }
        }
        return specificWidgets;
    }
    
    ArrayList<BusinessWidget> getBottomWidgets(){
        specificWidgets.clear();
        for(BusinessWidget s: widgets.keySet()){
            if(widgets.get(s).equals("bottom")){
                specificWidgets.add(s);
            }
        }
        return specificWidgets;
    }
    
    ArrayList<BusinessWidget> getLeftWidgets(){
        specificWidgets.clear();
        for(BusinessWidget s: widgets.keySet()){
            if(widgets.get(s).equals("left")){
                specificWidgets.add(s);
            }
        }
        return specificWidgets;
    }
    
    ArrayList<BusinessWidget> getCenterWidgets(){
        specificWidgets.clear();
        for(BusinessWidget s: widgets.keySet()){
            if(widgets.get(s).equals("center")){
                specificWidgets.add(s);
            }
        }
        return specificWidgets;
    }
    
    HashMap<BusinessWidget, String> getAllWidgets(){
        return widgets;
    }
    
    ArrayList<Integer> getWidgetID(){
        ArrayList<Integer> id = new ArrayList<>();
        for(BusinessWidget w: widgets.keySet()){
            id.add(w.getID());
        }
        return id;
    }
}   
