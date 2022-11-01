package events.listeners;

public class ClickListener implements EventListener{
    // private String menu_name; 

    // public void ClickListener(String menu_name) {
    //     this.menu_name = menu_name;
    // }

    @Override
    public void update(String eventType) {
        System.out.println("An event of type: " + eventType + "was broadcasted");
    }
    
}
