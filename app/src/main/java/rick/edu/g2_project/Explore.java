package rick.edu.g2_project;

//setters and getters that are used in various spots
//right click on one and click view usage to see where they are used

public class Explore {
    private int id;
    private String cpu;
    private int cpu_price;

    public Explore(){}

    public Explore(String cpu, int cpuPrice) {
        this.cpu = cpu;
        this.cpu_price = cpuPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getCpu_price() {
        return cpu_price;
    }

    public void setCpu_price(int cpu_price) {
        this.cpu_price = cpu_price;
    }
}
