package design_pattern.behavioral_design_pattern.mediator;

import design_pattern.behavioral_design_pattern.mediator.colleague.AudioCard;
import design_pattern.behavioral_design_pattern.mediator.colleague.CDDriver;
import design_pattern.behavioral_design_pattern.mediator.colleague.CPU;
import design_pattern.behavioral_design_pattern.mediator.colleague.VideoCard;
import design_pattern.behavioral_design_pattern.mediator.interf.Colleage;
import design_pattern.behavioral_design_pattern.mediator.interf.Mediator;

public class MotherBoard implements Mediator {
    private CDDriver cdDriver;
    private CPU cpu;
    private VideoCard videoCard;
    private AudioCard audioCard;

    public void setCdDriver(CDDriver cdDriver) {
        this.cdDriver = cdDriver;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public void setVideoCard(VideoCard videoCard) {
        this.videoCard = videoCard;
    }

    public void setAudioCard(AudioCard audioCard) {
        this.audioCard = audioCard;
    }

    @Override
    public void colleageChange(Colleage colleage) {
        if (colleage == cdDriver) {
            this.openCDDriverReadData(cdDriver);
        } else if (colleage == cpu) {
            this.openCPU(cpu);
        }
    }

    /**
     * 处理光驱读取数据过后与其它对象的交互
     *
     * @param cd 光驱同事对象
     */
    private void openCDDriverReadData(CDDriver cd) {
        //1：先获取光驱读取的数据
        String data = cd.getData();
        //2：把这些数据传递给CPU进行处理
        this.cpu.excuteData(data);
    }

    /**
     * 处理CPU处理完数据后与其它对象的交互
     *
     * @param cpu CPU同事类
     */
    private void openCPU(CPU cpu) {
        //1：先获取CPU处理过后的数据
        String videoData = cpu.getVideoData();
        String soundData = cpu.getAudioData();
        //2：把这些数据传递给显卡和声卡展示出来
        this.videoCard.showData(videoData);
        this.audioCard.soundData(soundData);
    }

}
