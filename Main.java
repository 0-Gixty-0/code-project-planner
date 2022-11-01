import view.Window;

public class Main{
    Window window = new Window();
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public void run(){
        // initialize_model();
        window.initialize_window();
        window.render_menu();
        window.welcome_message();
        window.render_frame();
    }
}