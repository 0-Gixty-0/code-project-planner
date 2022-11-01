package events.editor;

import events.publisher.EventManager;

public class Editor {
    public EventManager events;

    public Editor() {
        this.events = new EventManager("create", "open");
    }

    public void createProject() {
        events.notify("create");
    }

    public void openProject(){
        events.notify("open");
    }
}
