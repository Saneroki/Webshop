/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Marcg
 */
class Page {
    ArrayList<BusinessWidget> widgets = new ArrayList<>();
    ArrayList<BusinessWidget> specificWidgets;
    String desc;
    int id;
    
    Page(int id, String desc){
        this.desc = desc;
        this.id = id;
    }
    
    
    
    ArrayList<BusinessWidget> getAllWidgets(){
        return widgets;
    }
    
    ArrayList<Integer> getWidgetID(){
        ArrayList<Integer> id = new ArrayList<>();
        for(BusinessWidget w: widgets){
            id.add(w.getID());
        }
        return id;
    }
    
    void addWidget(BusinessWidget widget){
        widgets.add(widget);
    }
}   
