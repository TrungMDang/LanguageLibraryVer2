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
    private ViewLibrary myViewLibrary;
    
   private Observer[] myObservers;
  
    public Menu(Observer... theObservers) {
        myLibrary = new Library();
        myViewLibrary = new ViewLibrary();
        
        myObservers = theObservers;
        for (int i = 0; i < myObservers.length; i++){
            addObserver(myObservers[i]);
        }
        addObserver(myViewLibrary);
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("search".equalsIgnoreCase(evt.getPropertyName())) {
            List<Clause> clauses = myLibrary.search(evt.getNewValue());
            System.out.println(clauses.toArray().toString());
            setChanged();
            notifyObservers(clauses);
        } else if ("create".equalsIgnoreCase(evt.getPropertyName())) {
            boolean success = myLibrary.create(evt.getNewValue());
            setChanged();
            notifyObservers(success); 
        } else if ("view".equalsIgnoreCase(evt.getPropertyName())) {
            DefaultTableModel tModel = myLibrary.viewLibray();
            
            setChanged();
            notifyObservers(tModel);
        }
    }
 
}
