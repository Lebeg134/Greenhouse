public class Plant {
    int dry, damp;
    int dryhm, damphm;
    int cold, hot;
    int dark, bright;
    int fertilization;
    int drys, wets;

    public Plant(int dry, int damp,
                 int dryhm, int damphm,
                 int cold, int hot,
                 int dark, int bright,
                 int fertilization,
                 int drys, int wets){
        this.dry = dry;
        this.damp = damp;
        this.dryhm = dryhm;
        this.damphm = damphm;
        this.cold = cold;
        this.hot = hot;
        this.dark = dark;
        this.bright= bright;
        this.fertilization = fertilization;
        this.drys = drys;
        this.wets = wets;
    }
}
