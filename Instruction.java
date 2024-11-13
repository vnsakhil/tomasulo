public class Instruction {
    private int opcode;
    private int destReg;
    private int srcReg1;
    private int srcReg2;

    public Instruction(int opcode, int destReg, int srcReg1, int srcReg2) {
        this.opcode = opcode;
        this.destReg = destReg;
        this.srcReg1 = srcReg1;
        this.srcReg2 = srcReg2;
    }

    public int getOpcode() {
        return opcode;
    }

    public int getDestReg() {
        return destReg;
    }

    public int getSrcReg1() {
        return srcReg1;
    }

    public int getSrcReg2() {
        return srcReg2;
    }
}
