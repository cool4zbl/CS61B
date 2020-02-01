public class Body {
    /* Its current x/y position */
    public double xxPos;
    public double yyPos;

    /* Its current velocity in the x/y position */
    public double xxVel;
    public double yyVel;

    public double mass;
    /* The name of the file that corresponds to the image
        that depicts the body (for example, jupiter.gif) */
    public String imgFileName;

    public Body(double xP, double yP, double xV,
                double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Body(Body bd) {
        xxPos = bd.xxPos;
        yyPos = bd.yyPos;
        xxVel = bd.xxVel;
        yyVel = bd.yyVel;
        mass = bd.mass;
        imgFileName = bd.imgFileName;
    }
}
