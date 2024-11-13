public class ReservationStation {
    private boolean busy;
    private String operation;
    private int vj, vk;
    private String qj, qk;

    public ReservationStation() {
        this.busy = false;
        this.operation = "";
        this.vj = 0;
        this.vk = 0;
        this.qj = null;
        this.qk = null;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    // Getters and setters for vj, vk, qj, qk
    public int getVj() {
        return vj;
    }

    public void setVj(int vj) {
        this.vj = vj;
    }

    public int getVk() {
        return vk;
    }

    public void setVk(int vk) {
        this.vk = vk;
    }

    public String getQj() {
        return qj;
    }

    public void setQj(String qj) {
        this.qj = qj;
    }

    public String getQk() {
        return qk;
    }

    public void setQk(String qk) {
        this.qk = qk;
    }
}
