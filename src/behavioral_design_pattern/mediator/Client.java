package behavioral_design_pattern.mediator;

import behavioral_design_pattern.mediator.colleague.AudioCard;
import behavioral_design_pattern.mediator.colleague.CDDriver;
import behavioral_design_pattern.mediator.colleague.CPU;
import behavioral_design_pattern.mediator.colleague.VideoCard;

public class Client {
    public static void main(String[] args) {
        MotherBoard motherBoard = new MotherBoard();

        CDDriver cdDriver = new CDDriver(motherBoard);
        CPU cpu = new CPU(motherBoard);
        VideoCard videoCard = new VideoCard(motherBoard);
        AudioCard audioCard = new AudioCard(motherBoard);

        motherBoard.setCdDriver(cdDriver);
        motherBoard.setCpu(cpu);
        motherBoard.setAudioCard(audioCard);
        motherBoard.setVideoCard(videoCard);

        cdDriver.readCD();
    }
}
