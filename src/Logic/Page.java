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
    HashMap<Widgets, String> widgets;
    ArrayList<Widgets> specificWidgets;
    String desc;
    int id;
    
    Page(int id, String desc, HashMap<Widgets, String> widgets){
        this.widgets = widgets;
        this.desc = desc;
        this.id = id;
    }
    
    
    ArrayList<Widgets> getTopWidgets(){
        specificWidgets.clear();
        for(Widgets s: widgets.keySet()){
            if(widgets.get(s).equals("top")){
                specificWidgets.add(s);
            }
        }
        return specificWidgets;
    }
    
    ArrayList<Widgets> getBottomWidgets(){
        specificWidgets.clear();
        for(Widgets s: widgets.keySet()){
            if(widgets.get(s).equals("bottom")){
                specificWidgets.add(s);
            }
        }
        return specificWidgets;
    }
    
    ArrayList<Widgets> getLeftWidgets(){
        specificWidgets.clear();
        for(Widgets s: widgets.keySet()){
            if(widgets.get(s).equals("left")){
                specificWidgets.add(s);
            }
        }
        return specificWidgets;
    }
    
    ArrayList<Widgets> getCenterWidgets(){
        specificWidgets.clear();
        for(Widgets s: widgets.keySet()){
            if(widgets.get(s).equals("center")){
                specificWidgets.add(s);
            }
        }
        return specificWidgets;
    }
    
    HashMap<Widgets, String> getAllWidgets(){
        return widgets;
    }
}   
