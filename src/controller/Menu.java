package controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import gui.SearchPanel;
import gui.ViewLibrary;
import model.Clause;
import model.Library;

public class Menu extends Observable implements PropertyChangeListener{

    private Library myLibrary;
    //private ViewLibrary myViewLibrary;
    
   private Observer[] myObservers;
  
    public Menu(Observer... theObservers) {
        myLibrary = new Library();
        //myViewLibrary = new ViewLibrary();
        
        myObservers = theObservers;
        for (int i = 0; i < myObservers.length; i++){
            addObserver(myObservers[i]);
        }
        
        //addObserver(myViewLibrary);
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("search".equalsIgnoreCase(evt.getPropertyName())) {
            List<Clause> clauses = myLibrary.search(evt.getNewValue());
            System.out.println(clauses.toArray().toString());
            setChanged();
            notifyObservers(clauses);
        }
        if ("create".equalsIgnoreCase(evt.getPropertyName())) {
            boolean success = myLibrary.create(evt.getNewValue());
            setChanged();
            notifyObservers(success); 
        }
        if ("key".equalsIgnoreCase(evt.getPropertyName())) {
            System.err.println("Inside property view");

            DefaultTableModel tModel = myLibrary.viewLibray(evt.getNewValue());
            addObserver((Observer) evt.getOldValue());
            setChanged();
            notifyObservers(tModel);
        }
        if ("title".equalsIgnoreCase(evt.getPropertyName())) {
            System.err.println("Inside property view");

            DefaultTableModel tModel = myLibrary.viewLibray(evt.getNewValue());
            addObserver((Observer) evt.getOldValue());
            if (tModel.equals(null)) {
                System.err.println("view failed");
            } else {
                setChanged();
                notifyObservers(tModel);
            }
        }
    }
 
}
