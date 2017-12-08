package behavioral_design_pattern.mediator.colleague;

import behavioral_design_pattern.mediator.interf.Colleage;
import behavioral_design_pattern.mediator.interf.Mediator;

public class AudioCard extends Colleage {

    public AudioCard(Mediator mediator) {
        super(mediator);
    }

    /**
     * 按照声频数据发出声音
     *
     * @param data 发出声音的数据
     */
    public void soundData(String data) {
        System.out.println("画外音：" + data);
    }

}
