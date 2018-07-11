package design_pattern.behavioral_design_pattern.mediator;

import design_pattern.behavioral_design_pattern.mediator.colleague.AudioCard;
import design_pattern.behavioral_design_pattern.mediator.colleague.CDDriver;
import design_pattern.behavioral_design_pattern.mediator.colleague.CPU;
import design_pattern.behavioral_design_pattern.mediator.colleague.VideoCard;

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
