package italian.restaurant.waiter.ui.websocket;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import italian.restaurant.waiter.ui.dto.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequiredArgsConstructor
public class ConstantMessageFlowController {

    private final SimpMessagingTemplate simpleMessagingTemplate;

    private List<String> people = Arrays.asList("Tom", "Josh", "Lisa", "Sarah", "Peter");

    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public Message message(Message message) throws Exception {
        Thread.sleep(2 * 1000);
        String content = "Received message: " + message.getContent();
        return createMessage(content);
    }

    @Scheduled(fixedDelay = 15 * 1000)
    public void constantFlow() throws Exception {
        String content = buildContent();
        log.info("Sending constant flow message: " + content);
        Message message = createMessage(content);
        simpleMessagingTemplate.convertAndSend("/topic/messages", message);
    }

    private String buildContent() {
        StringBuilder content = new StringBuilder();
        content.append("I'd like to meet ");
        Random random = new Random();
        int index = random.nextInt(people.size());
        content.append(people.get(index));
        content.append("!");
        return content.toString();
    }

    private Message createMessage(String content) {
        return Message.builder()
                      .content(content)
                      .build();
    }

}
