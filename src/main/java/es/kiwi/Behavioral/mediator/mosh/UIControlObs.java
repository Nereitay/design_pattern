package es.kiwi.Behavioral.mediator.mosh;

import java.util.ArrayList;
import java.util.List;

public class UIControlObs {

   private List<EventHandler> eventHandlers = new ArrayList<>();

   public void addEventHandler(EventHandler eventHandler) {
       eventHandlers.add(eventHandler);
   }

   protected void notifyEventHandler() {
       eventHandlers.forEach(EventHandler::handler);
   }


}
