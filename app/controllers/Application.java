package controllers;

import play.mvc.Controller;

/**
 * Created by aleksandar on 25.6.16..
 */
public class Application extends Controller {

    public static void index() {
        render();
    }
    
    public static void verify() {
    	renderText("p2JDnYiEvgMDp19bKMvDUauDjsN99yP065Sl3aSDLJw.hzNR118Y-KXT8SQ_Sh64T45WRNRXYBn3yv2x8HGaBTc");
    }
}
