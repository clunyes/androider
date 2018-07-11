package design_pattern.behavioral_design_pattern.mediator.colleague;

import design_pattern.behavioral_design_pattern.mediator.interf.Colleage;
import design_pattern.behavioral_design_pattern.mediator.interf.Mediator;

public class CDDriver extends Colleage {
    /**
     * 光驱读取出来的数据
     */
    private String data = "";

    public CDDriver(Mediator mediator) {
        super(mediator);
    }

    //读取cd
    public void readCD() {
        this.data = "视频：这里是设计模式学习,音频：这里是设计模式学习";
        getMediator().colleageChange(this);
    }

    public String getData() {
        return data;
    }


}
