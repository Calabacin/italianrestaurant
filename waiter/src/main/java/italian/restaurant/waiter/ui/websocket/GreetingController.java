package italian.restaurant.waiter.ui.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import italian.restaurant.waiter.ui.dto.Message;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Message greeting(Message message) throws Exception {
        Thread.sleep(2000);
        StringBuilder content = buildContent(message);
        return createMessage(content);
    }

    private StringBuilder buildContent(Message message) {
        StringBuilder content = new StringBuilder();
        content.append("Hello, ");
        content.append(message.getContent());
        content.append("!");
        return content;
    }

    private Message createMessage(StringBuilder content) {
        return Message.builder()
                      .content(content.toString())
                      .build();
    }

}
