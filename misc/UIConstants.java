package misc;

import java.awt.*;

public class UIConstants {
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;
    public static final Dimension PANEL_SIZE = new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);
    public static final Dimension BOTTOM_PANEL_SIZE = new Dimension(WINDOW_WIDTH, 400);
    public static final Dimension COMPONENT_SIZE = new Dimension(600, 40);
    public static final Dimension TITLE_SIZE = new Dimension(600, 60);
    public static final Font TITLE_FONT = new Font("Roboto", Font.BOLD, 45);
    public static final Font INPUT_FONT = new Font("Segoe UI", Font.PLAIN, 15);
    public static final Font OUTPUT_PROCESS_FONT = new Font("Segoe UI", Font.BOLD, 20);
    public static final Color PANEL_COLOR = new Color(255, 255, 255);
    public static final Color TEXT_COLOR = new Color(34, 34, 34);
    public static final Color INPUT_FIELD_COLOR = new Color(247, 247, 247);
    public static final Color BUTTON_BG = new Color(0, 120, 215);
    public static final String[] TITLE_1 = {
                        "Process", 
                        "Arrival Time", 
                        "Burst Time",
                        "Start Time",
                        "Waiting Time"}; 
    public static final String[] TITLE_2 = {
                        "Process", 
                        "Arrival Time", 
                        "Burst Time",
                        "Completion Time",
                        "Turnaround Time",
                        "Waiting Time"}; 
}
