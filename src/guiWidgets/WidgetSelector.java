package guiWidgets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import business.Controller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

/**
 *
 * @author Kristian
 */
public class WidgetSelector {

    private ArrayList<Widget> widgets;
    private File directory;
    private Controller controller;
    private static WidgetSelector ws;

    public WidgetSelector() {
        this.widgets = new ArrayList();
        controller = Controller.getController();
        try {
            this.updateWidgets();
        } catch (IOException ex) {
            System.out.println("Widget selector was unable to load widgets");
            Logger.getLogger(WidgetSelector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static WidgetSelector getWidgetSelector(){
        if (ws == null) {
            ws = new WidgetSelector();
        }
        return ws;
    }
    
    private void updateWidgets() throws IOException {
        directory = new File(System.getProperty("user.dir") + "/src/guiWidgets");
        loadAll();
    }


    private void loadAll() throws IOException {
        HashMap<Integer, String> staticWidget = new HashMap<>();
        staticWidget = controller.getStaticWidget();
        for (Integer i : staticWidget.keySet()) {
            saveWidget(staticWidget.get(i), i);
        }
    }



    /**
     * @return the widgets
     */
    public ArrayList<Widget> getWidgets() {
        return widgets;
    }

    public void saveWidget(String fileName, int id) throws IOException {
        this.widgets.add(getWidget(fileName, id));
    }

    public Widget getWidget(String fileName, int id) throws IOException {
        Node root = FXMLLoader.load(getClass().getResource(fileName));
        return new Widget(root, fileName, id);
    }
    
    public Widget loadWidget(int id){
        for(Widget w: widgets){
            if(id == w.getDBID()){
                try {
                   return getWidget(w.getFxmlName(), id);
                } catch (IOException ex) {
                    Logger.getLogger(WidgetSelector.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println(ex);
                }
                
            }
        }
        return null;
    }
    
}
