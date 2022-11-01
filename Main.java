import view.Window;

public class Main{
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public void run(){
        // initialize_model();
        Window.initialize_window();
        Window.initialize_listeners();
        Window.render_menu();
        Window.welcome_message();
        Window.render_frame();
    }
}