public class Planet {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double dx = p.xxPos - this.xxPos; 
        double dy = p.yyPos - this.yyPos;
        double r = Math.sqrt(dx*dx + dy*dy);
        return r;
    }

    public double calcForceExertedBy(Planet p) {
        double G = 6.67 * Math.pow(10, -11);
        double F = G * this.mass * p.mass / (calcDistance(p) * calcDistance(p));
        return F;
    }

    public double calcForceExertedByX(Planet p) {
        double dx = p.xxPos - this.xxPos;
        double Fx = calcForceExertedBy(p) * dx / calcDistance(p);
        return Fx;
    }

    public double calcForceExertedByY(Planet p) {
        double dy = p.yyPos - this.yyPos;
        double Fy = calcForceExertedBy(p) * dy / calcDistance(p);
        return Fy;
    }

    public double calcNetForceExertedByX(Planet[] plist){
        double FxNet = 0;
        for (Planet p: plist) {
            if (this.equals(p)){
                continue;
            } {
                FxNet += calcForceExertedByX(p);
            }
        }
    return FxNet;
    }

    public double calcNetForceExertedByY(Planet[] plist){
        double FxNet = 0;
        for (Planet p: plist) {
            if (this.equals(p)){
                continue;
            } {
                FxNet += calcForceExertedByY(p);
            }
        }
    return FxNet;
    }
}
