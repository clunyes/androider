package design_pattern.behavioral_design_pattern.command;

public class Tv {
    private int currentChannel = 0;

    public void turnOff() {
        System.out.println("television is turn off");
    }

    public void turnOn() {
        System.out.println("television is turn on");
    }

    public void changeChannel(int channel) {
        this.currentChannel = channel;
        System.out.println("Now tv channel is" + currentChannel);
    }
}
