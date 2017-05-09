package Logic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marcg
 */
class BusinessWidget {
    int id;
    int x;
    int y;
    int width;
    int height;
    int DBid;
    
    BusinessWidget(int x, int y, int height, int width, int id, int dbid){
        this.x = x;
        this.y = y;
        this.id = id;
        this.height = height;
        this.width = width;
        this.DBid = dbid;
               
    }
    
    void setX(int x){
        this.x = x;
    }
    
    void setY(int y){
        this.y = y;
    }
    
    int getX(){
        return x;
    }
    
    int getY(){
        return y;
    }
    
    int getHeight(){
        return height;
    }
    
    int getWidth(){
        return width;
    }
    
    int getID(){
        return id;
    }
    
    int getDBID(){
        return DBid;
    }
    
    
}
