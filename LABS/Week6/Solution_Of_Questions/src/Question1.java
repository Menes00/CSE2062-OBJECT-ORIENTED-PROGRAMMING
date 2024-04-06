public class Question1 {
    public static void main(String[] args) {
        TV obj = new TV();
        obj.turnOn();
        obj.setChannel(25);
        obj.setVolume(5);

        obj.channelUp();
        obj.volumeUp();
        obj.channelDown();
        obj.volumeDown();

        System.out.printf("Channel: %d Volume Level: %d\n",obj.channel, obj.volumeLevel);
        obj.turnOff();
        System.out.println("TV is " + obj.on);

    }
}
class TV {
    int channel = 10;
    int volumeLevel = 2;
    boolean on = false;

    TV(){
    }
    public void turnOn(){
        on = true;
    }
    public void turnOff(){
        on = false;
    }
    public void setChannel(int newChannel) {
        if (on && newChannel >= 1 && newChannel <= 120)
            channel = newChannel;
    }

    public void setVolume(int newVolumeLevel) {
        if (on && newVolumeLevel >= 1 && newVolumeLevel <= 7)
            volumeLevel = newVolumeLevel;
    }

    public void channelUp() {
        if (on && channel < 120)
            channel++;
    }

    public void channelDown() {
        if (on && channel > 1)
            channel--;
    }

    public void volumeUp() {
        if (on && volumeLevel < 7)
            volumeLevel++;
    }

    public void volumeDown() {
        if (on && volumeLevel > 1)
            volumeLevel--;
    }

}