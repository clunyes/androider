package behavioral_design_pattern.mediator.colleague;

import behavioral_design_pattern.mediator.interf.Colleage;
import behavioral_design_pattern.mediator.interf.Mediator;

public class CPU extends Colleage {
    //视频
    private String videoData;
    //音频
    private String audioData;

    public CPU(Mediator mediator) {
        super(mediator);
    }


    public String getVideoData() {
        return videoData;
    }

    public String getAudioData() {
        return audioData;
    }

    public void excuteData(String data) {
        //把数据分解开，前面的是视频数据，后面的是音频数据
        String [] ss = data.split(",");
        this.videoData = ss[0];
        this.audioData = ss[1];
        //通知主板，CPU的工作完成
        this.getMediator().colleageChange(this);
    }
}
