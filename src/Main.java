class Computer{
    private String cpu;
    private String memory;
    private String storage;
    private String gpu;
    private String monitor;

    public Computer(String cpu, String memory, String storage, String gpu, String monitor) {
        this.cpu = cpu;
        this.memory = memory;
        this.storage = storage;
        this.gpu = gpu;
        this.monitor = monitor;
    }

    @Override
    public String toString() {
        return "Computer: CPU - " + cpu + ", Memory - " + memory + ", Storage - " + storage + ", GPU - " + gpu + ", Monitor - " + monitor;
    }
}


class Laptop{
    private String cpu;
    private String memory;
    private String storage;
    private String gpu;
    private String monitor;

    public Laptop(String cpu, String memory, String storage, String gpu, String monitor) {
        this.cpu = cpu;
        this.memory = memory;
        this.storage = storage;
        this.gpu = gpu;
        this.monitor = monitor;
    }

    @Override
    public String toString() {
        return "Laptop: CPU - " + cpu + ", Memory - " + memory + ", Storage - " + storage + ", GPU - " + gpu + ", Monitor - " + monitor;
    }
}

interface Builder {
    void CPU(String cpu);

    void Memory(String memory);

    void Storage(String storage);

    void GPU(String gpu);

    void Monitor(String monitor);

}


class ComputerBuilder implements Builder{
    private String cpu;
    private String memory;
    private String storage;
    private String gpu;
    private String monitor;

    @Override
    public void CPU(String cpu) {
        this.cpu = cpu;
    }

    @Override
    public void Memory(String memory) {
        this.memory = memory;
    }

    @Override
    public void Storage(String storage) {
        this.storage = storage;
    }

    @Override
    public void GPU(String gpu) {
        this.gpu = gpu;
    }

    @Override
    public void Monitor(String monitor) {
        this.monitor = monitor;
    }

    public Computer build() {
        return new Computer(cpu, memory, storage, gpu, monitor);
    }
}

class LaptopBuilder implements Builder{
    private String cpu;
    private String memory;
    private String storage;
    private String gpu;
    private String monitor;


    @Override
    public void CPU(String cpu) {
        this.cpu = cpu;
    }

    @Override
    public void Memory(String memory) {
        this.memory = memory;
    }

    @Override
    public void Storage(String storage) {
        this.storage = storage;
    }

    @Override
    public void GPU(String gpu) {
        this.gpu = gpu;
    }

    @Override
    public void Monitor(String monitor) {
        this.monitor = monitor;
    }

    public Laptop build() {
        return new Laptop(cpu, memory, storage, gpu, monitor);
    }
}


class ComputerDirector {
    public Computer buildComputer(ComputerBuilder computerBuilder) {
        computerBuilder.CPU("Intel i7");
        computerBuilder.Memory("16GB");
        computerBuilder.Storage("512GB SSD");
        computerBuilder.GPU("Nvidia GTX 1660");
        computerBuilder.Monitor("24-inch Full HD");
        return computerBuilder.build();
    }
    
    public Laptop buildLaptop(LaptopBuilder laptopBuilder){
        laptopBuilder.CPU("Intel i7");
        laptopBuilder.Memory("16GB");
        laptopBuilder.Storage("512GB SSD");
        laptopBuilder.GPU("Nvidia GTX 1660");
        laptopBuilder.Monitor("24-inch Full HD");
        return laptopBuilder.build();
    }
}




public class Main {
    public static void main(String[] args) {
        ComputerBuilder computerBuilder = new ComputerBuilder();

        LaptopBuilder laptopBuilder = new LaptopBuilder();

        ComputerDirector director = new ComputerDirector();

        Computer computer = director.buildComputer(computerBuilder);

        Laptop laptop = director.buildLaptop(laptopBuilder);

        System.out.println(computer);
        System.out.println(laptop);
    }
}