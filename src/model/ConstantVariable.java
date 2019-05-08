package model;

public interface ConstantVariable {
    
    /** Action command name for button **/
    public final static String VIEW_PLAYER = "VIEW_PLAYER";
    public final static String NEW_PLAYER = "NEW_PLAYER";
    public final static String PLACE_BET = "PLACE_BET";
    public final static String CLOSE_FRAME = "CLOSE_FRAME";
    public final static String INITIAL_POINTS = "INITIAL_POINTS";
    public final static String SPIN_WHEEL = "SPIN_WHEEL";
    
    /** Control delay number **/
    public final static int INITIAL_DELAY = 1;
    public final static int FINAL_DELAY = 500;
    public final static int DELAY_INCREMENT = 25;
    
    /** Status bar message **/
    public final static String WIN_COLOR = "Winning Color : ";
    public final static String WIN_NUMBER = "Winning Number : ";
    
    /** Frame Title **/
    public final static String DISPLAYRESULT_TITLE = "Final Result!";
    public final static String APPFRAME_TITLE = "Wheel Game";
    public final static String PLAYERGUI_TITLE = "Player GUI";
    public final static String ADDNEWPLAYER_TITLE = "Add New Player";
    
    /** Image location **/
    public final static String IMAGE_LOCATION = "img/Basic_roulette_wheel_1024x1024.png";
}
