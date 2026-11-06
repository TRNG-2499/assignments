import java.util.function.Function;

public class Stage {
    private String name;
    private int initIdx;
    private int duration;
    private int cycle = 0;

    public Stage(String name, int index, int duration) {
        this.name = name;
        this.initIdx = index;
        this.duration = duration;
    }

    public String name() {
        return name;
    }

    public int duration() {
        return duration;
    }

    public int index() {
        return initIdx + cycle;
    }

    public Stage cycle(int idx, int cycles, int maxCycles, Function<Integer, Stage> getter) {
        int complete = cycle + cycles >= duration ? 1 : 0;
        cycle += cycles;

        int newIdx = (idx + cycles) % maxCycles;
        Stage next = getter.apply(newIdx);
        int r = newIdx - next.reset().index();

        return switch(complete) {
            case 0 -> this;
            default -> swapTo(next).cycle(
                next.index(), 
                r,
                maxCycles,
                getter
            );
        };
    }

    public Stage reset() {
        cycle = 0;

        return this;
    }

    public Stage swapTo(Stage stage) {
        reset();

        return stage.reset();
    }
}