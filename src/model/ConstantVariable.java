package model;

public interface ConstantVariable {
    
    /** Control delay number **/
    public final static int INITIAL_DELAY = 1;
    public final static int FINAL_DELAY = 200;
    public final static int DELAY_INCREMENT = 4;
    
    /** Status bar message **/
    public final static String WIN_COLOR = "Winning Color : ";
    public final static String WIN_NUMBER = "Winning Number : ";
    public final static String WIN_POSITION = "Winning Position : ";
    
    /** Frame Title **/
    public final static String DISPLAYRESULT_TITLE = "Final Result!";
    public final static String APPFRAME_TITLE = "Wheel Game";
    public final static String PLAYERGUI_TITLE = "Player GUI";
    public final static String ADDNEWPLAYER_TITLE = "Add New Player";
    public final static String ADDNEWPLAYER_ERROR = "ERROR OCCUR!";
    
    /** Error Message **/
    public final static String ADD_NEW_PLAYER_MSG = "Name or Point cannot be empty!";
    
    /** Image location **/
    public final static String IMAGE_LOCATION = "img/Basic_roulette_wheel_1024x1024.png";
    
    /** Size of roulette ball by % determine by the diameter of roulette **/
    public final static double BALL_SIZE = 0.02;
    
    /** The position of ball on the roulette **/
    public final static double BALL_POSITION = 0.9;
    
    /** The full degree of circle **/
    public final static int totalDegree = 360;
    
    /** For wheel divide into half **/
    public final static int HALF = 2;
    
    /** GridLayout gap value **/
    public final static int GAP = 20;
    
    /** Screen size percentage **/
    public final static double MIN_HEIGHT = 0.8;
    public final static double MIN_WIDTH = 0.4;
}
