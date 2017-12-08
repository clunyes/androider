package behavioral_design_pattern.mediator.colleague;

import behavioral_design_pattern.mediator.interf.Colleage;
import behavioral_design_pattern.mediator.interf.Mediator;

public class VideoCard extends Colleage {

    public VideoCard(Mediator mediator) {
        super(mediator);
    }

    /**
     * 显示视频数据
     * @param data 被显示的数据
     */
    public void showData(String data){
        System.out.println("您正观看的是："+data);
    }
}
