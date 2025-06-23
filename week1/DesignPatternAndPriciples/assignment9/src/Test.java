public class Test {
    public static void main(String[] args) throws Exception {
        Light remoteLight = new Light();

        Command on = new LightOnCommand(remoteLight);
        Command off = new LightOffCommand(remoteLight);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(on);
        remote.touch();

        remote.setCommand(off);
        remote.touch();
    }
}
