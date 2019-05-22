package model;

public interface ConstantVariable {
    
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
    
    /** Size of roulette ball by % determine by the diameter of roulette **/
    public final static double BALL_SIZE = 0.02;
    
    /** The position of ball on the roulette **/
    public final static double BALL_POSITION = 0.9;
    
    /** For wheel divide into half **/
    public final static int HALF = 2;
}
