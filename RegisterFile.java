public class RegisterFile {
    private int[] registers;
    private String[] RAT;

    public RegisterFile() {
        registers = new int[10];
        RAT = new String[10];
        for (int i = 0; i < 10; i++) {
            RAT[i] = "-1";
        }
    }

    public int getRegisterValue(int index) {
        return registers[index];
    }

    public void updateRegister(int index, int value) {
        registers[index] = value;
    }

    public String getRATValue(int index) {
        return RAT[index];
    }

    public void updateRAT(int index, String value) {
        RAT[index] = value;
    }
}
