interface Switchable {
 
    void on();
 
    void off();
 
    default void toggle() {
        System.out.println("Toggle operation is being performed.");
    }
}
 
class Fan implements Switchable {
 
    private boolean isOn = false;
 
    @Override
    public void on() {
        isOn = true;
        System.out.println("Fan is ON");
    }
 
    @Override
    public void off() {
        isOn = false;
        System.out.println("Fan is OFF");
    }
 
    @Override
    public void toggle() {
        if (isOn) {
            off();
        } else {
            on();
        }
    }
}
 
class Light implements Switchable {
 
    private boolean isOn = false;
 
    @Override
    public void on() {
        isOn = true;
        System.out.println("Light is ON");
    }
 
    @Override
    public void off() {
        isOn = false;
        System.out.println("Light is OFF");
    }
 
    @Override
    public void toggle() {
        if (isOn) {
            off();
        } else {
            on();
        }
    }
}
 
@FunctionalInterface
interface DeviceController {
    void control(Switchable device);
}
 
public class RemoteControlDemo {
 
    public static void main(String[] args) {
 
        Switchable[] devices = {
            new Fan(),
            new Light()
        };
 
        System.out.println("Remote Control:");
 
        for (Switchable device : devices) {
            device.toggle();
        }
 
        System.out.println("\nUsing Anonymous Class:");
 
        DeviceController controller1 = new DeviceController() {
            @Override
            public void control(Switchable device) {
                device.on();
            }
        };
 
        controller1.control(devices[0]);
 
        System.out.println("\nUsing Lambda Expression:");
 
        DeviceController controller2 = device -> device.off();
 
        controller2.control(devices[1]);
    }
}
