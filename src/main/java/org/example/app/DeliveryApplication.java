package org.example.app;

import org.example.transport.Logistics;
import org.example.ui.Button;
import org.example.ui.Checkbox;
import org.example.ui.GUIFactory;

public class DeliveryApplication {

    private final GUIFactory guiFactory;
    private final Logistics logistics;

    public DeliveryApplication(GUIFactory guiFactory, Logistics logistics) {
        this.guiFactory = guiFactory;
        this.logistics = logistics;
    }
    public void run() {
        Button button = guiFactory.createButton();
        Checkbox checkbox = guiFactory.createCheckbox();

        button.paint();
        checkbox.paint();

        logistics.planDelivery("laboratory equipment", "Aktau warehouse");
    }
}