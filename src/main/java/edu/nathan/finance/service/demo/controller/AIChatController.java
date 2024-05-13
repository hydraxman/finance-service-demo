package edu.nathan.finance.service.demo.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.azure.openai.AzureOpenAiChatClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AIChatController {
    @Resource
    AzureOpenAiChatClient azureOpenAiChatClient;

    @RequestMapping("/chat")
    public String chat(String message) {
        System.out.println(azureOpenAiChatClient.getDefaultOptions().getDeploymentName());
        return azureOpenAiChatClient.call(message);
    }
}
