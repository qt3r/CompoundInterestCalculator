public class Interest {
    private double P;
    private double r;
    private double I;
    private int n;
    private int t;

    public Interest(double p, double r, double i, int n, int t) {
        P = p;
        this.r = r;
        I = calculateInterestEarned();
        this.n = n;
        this.t = t;
    }

    public double amount(){
        return P * Math.pow((1 + r/n),(n*t));
    }

    public double calculateInterestEarned(){
        return amount() - P;
    }

    public void display(){
        System.out.println("Principal investment: " + P + "\n Total Interest Earned: " + I + "\n Final Amount: " + amount());
    }
}