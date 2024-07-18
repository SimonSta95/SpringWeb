package org.example.springweb;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MessageController {

    List<Message> messages = new ArrayList<>();

    @PostMapping("/message")
    public String postMessages(@RequestBody Message message) {
        messages.add(message);

        return "Message added";
    }

    @GetMapping("/message")
    public List<Message> getMessages() {
        return messages;
    }

    @DeleteMapping("/message/{id}")
    public String deleteMessages(@PathVariable String id) {
        for (Message message : messages) {
            if (message.getId().equals(id)) {
                messages.remove(message);
            }
        }
        return "Message with id " + id + " deleted";
    }
}
