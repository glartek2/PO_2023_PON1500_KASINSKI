package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SimulationEngine {
    private final List<Simulation> simulations;
    private final ExecutorService executorService;
    private final List<Future<?>> simulationFutures;

    public SimulationEngine(List<Simulation> simulations) {
        this.simulations = simulations;
        this.executorService = Executors.newFixedThreadPool(4);
        this.simulationFutures = new ArrayList<>();
    }


    public void runSync() {
        for (Simulation simulation : simulations) {
            simulation.run();
        }
    }

    public void runAsync() {
        for (Simulation simulation : simulations) {
            Thread thread = new Thread(simulation);
            thread.start();
        }
    }

    public void runAsyncInThreadPool() {
        for (Simulation simulation : simulations) {
            Future<?> future = executorService.submit(simulation);
            simulationFutures.add(future);
        }
    }

    public void awaitSimulationsEnd() {
        try {
            for (Future<?> future: simulationFutures){
                future.get();
            }
            executorService.shutdown();
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
