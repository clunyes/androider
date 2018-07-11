package design_pattern.behavioral_design_pattern.state;

public class AuxLift implements LiftInterface{
    @Override
    public void open() {
        System.out.println("电梯门开启");
    }

    @Override
    public void close() {
        System.out.println("电梯门关闭");
    }

    @Override
    public void run() {
        System.out.println("电梯开始运行");
    }

    @Override
    public void stop() {
        System.out.println("电梯到啦，停下来了");
    }
}
