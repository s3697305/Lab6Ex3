package Model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BtDealHandler implements EventHandler<ActionEvent> {

    public void handle(ActionEvent e){
        Ex3cards.getRandomCards();
        System.out.println(Ex3cards.pickedCards[0]);
        System.out.println(Ex3cards.pickedCards[1]);
        System.out.println(Ex3cards.pickedCards[2]);
    }
}
