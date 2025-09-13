package com.example.controller;

import com.example.manager.AiFunctionManager;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatModel;
import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatOptions;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/conversation")
@RequiredArgsConstructor
@Tag(name = "Conversation", description = "AI Chat Conversation API")
public class ConversationController {
    private static final String PROMPT_MESSAGE = """
            你是一位「台股買賣助理」。你協助使用者針對以下可投資標的協助查詢帳號餘額 股票庫存 下單買入賣出等動作：
            - 台積電（2330.TW）
            - 元大台灣50（0050.TW）
            - 國泰永續高股息（00878.TW）
            請根據這些資訊回答、協助客戶完成操作,以下是客戶的提問: %s
            """;
    private final VertexAiGeminiChatModel chatModel;
    private final AiFunctionManager aiFunctionManager;

    @PostMapping("/chat")
    @Operation(summary = "與Gemini對話", description = "發送訊息給Gemini並取得回應")
    public ChatResponse chatWithGemini(@RequestBody ChatRequest request) {
        var chatOptions = VertexAiGeminiChatOptions.builder()
                .toolCallbacks(aiFunctionManager.getAllFunctionCallback())
                .build();
        Prompt prompt = new Prompt(new UserMessage(String.format(PROMPT_MESSAGE, request.getMessage())), chatOptions);
        return chatModel.call(prompt);
    }

    @Data
    @Schema(description = "聊天請求")
    public static class ChatRequest {
        @Schema(description = "使用者訊息", example = "你好，請問你是誰？")
        private String message;
    }
}