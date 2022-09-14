package dev.peter.luterium;

import dev.peter.luterium.payload.Payload;
import dev.peter.luterium.payload.PayloadExecutor;

/**
 * @author Peter
 * @since 08/15/2022
 */

public class Executor {
    Main main = new Main();

    public void execute() {
        for (PayloadExecutor payload : Payload.getPayloads()) {
            try {
                payload.execute();
            } catch (Exception e) {
                main.theThing.send(e.getMessage());
            }
        }
    }
}
