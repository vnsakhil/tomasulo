import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulator {
    private ArrayList<Instruction> instructionBuffer;
    private Processor processor;
    private RegisterFile registerFile;
    private int cycleCount;

    // Constructor that loads instructions from the input file
    public Simulator(String inputFilePath) {
        instructionBuffer = new ArrayList<>();
        processor = new Processor();
        registerFile = new RegisterFile();
        loadInstructions(inputFilePath);  // Load the instructions and register values
    }

    // Method to load instructions and initial register values from the input file
    private void loadInstructions(String filePath) {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            System.out.println("Loading instructions...");

            int numInstructions = scanner.nextInt();
            cycleCount = scanner.nextInt();
            System.out.println("Number of instructions: " + numInstructions);
            System.out.println("Cycle count: " + cycleCount);

            // Load each instruction into the instruction buffer
            for (int i = 0; i < numInstructions; i++) {
                int opcode = scanner.nextInt();
                int destReg = scanner.nextInt();
                int srcReg1 = scanner.nextInt();
                int srcReg2 = scanner.nextInt();
                instructionBuffer.add(new Instruction(opcode, destReg, srcReg1, srcReg2));
                System.out.println("Loaded instruction: " + opcode + " " + destReg + " " + srcReg1 + " " + srcReg2);
            }

            // Load initial register values
            for (int i = 0; i < 10; i++) {
                if (!scanner.hasNextInt()) {
                    System.out.println("Error: Unexpected input format for register values at register " + i);
                    return;
                }
                int registerValue = scanner.nextInt();
                registerFile.updateRegister(i, registerValue);
                System.out.println("Register R" + i + " initialized to: " + registerValue);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Input file not found.");
        } catch (Exception e) {
            System.out.println("Error reading input file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to start the simulation and execute cycles
    public void run() {
        for (int cycle = 1; cycle <= cycleCount; cycle++) {
            System.out.println("Cycle " + cycle + ":");

            if (cycle - 1 < instructionBuffer.size()) {
                processor.issueInstruction(instructionBuffer.get(cycle - 1));
            }

            processor.dispatch();
            processor.broadcast();
            displayStatus();

            System.out.println();  // Blank line between cycles for readability
        }
    }

    // Method to display the status of the simulator after each cycle
    private void displayStatus() {
        System.out.println("Reservation Stations:");
        for (ReservationStation rs : processor.getReservationStations()) {
            System.out.println("Busy: " + rs.isBusy() + " Op: " + rs.getOperation());
        }

        System.out.println("Register File:");
        for (int i = 0; i < 10; i++) {
            System.out.print("R" + i + "=" + registerFile.getRegisterValue(i) + " ");
        }
        System.out.println();

        System.out.println("RAT (Register Allocation Table):");
        for (int i = 0; i < 10; i++) {
            System.out.print("R" + i + " -> " + registerFile.getRATValue(i) + " ");
        }
        System.out.println();
    }
}
