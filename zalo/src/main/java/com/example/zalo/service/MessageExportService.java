package com.example.zalo.service;

import com.example.zalo.entity.ChatMessage;
import com.example.zalo.repository.ChatMessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Service for exporting chat message history to CSV format.
 * Provides functionality to export conversations for backup or compliance purposes.
 */
@Service
public class MessageExportService {

    private static final Logger logger = LoggerFactory.getLogger(MessageExportService.class);
    private static final String CSV_HEADER = "MessageID,ChatID,SenderName,RecipientName,Content,Timestamp,Status";
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    /**
     * Export all messages from a specific chat conversation to CSV format.
     *
     * @param chatId the chat room identifier
     * @return byte array containing the CSV data
     */
    public byte[] exportChatToCSV(String chatId) {
        if (chatId == null || chatId.trim().isEmpty()) {
            logger.warn("Cannot export: invalid chatId provided");
            return new byte[0];
        }

        List<ChatMessage> messages = chatMessageRepository.findByChatId(chatId);
        logger.info("Exporting {} messages from chat {}", messages.size(), chatId);

        return generateCSVBytes(messages);
    }

    /**
     * Export all messages for a given user to CSV format.
     *
     * @param userId the user ID
     * @return byte array containing the CSV data
     */
    public byte[] exportUserMessagesToCSV(int userId) {
        List<ChatMessage> allMessages = chatMessageRepository.findAll();
        logger.info("Starting export for user {}", userId);

        List<ChatMessage> userMessages = allMessages.stream()
                .filter(msg -> (msg.getSenderId() != null && msg.getSenderId().getId() == userId)
                        || (msg.getRecipientId() != null && msg.getRecipientId().getId() == userId))
                .collect(java.util.stream.Collectors.toList());

        logger.info("Exporting {} messages for user {}", userMessages.size(), userId);
        return generateCSVBytes(userMessages);
    }

    /**
     * Generate the CSV content as a byte array from a list of messages.
     *
     * @param messages the list of chat messages to export
     * @return byte array containing the CSV data
     */
    private byte[] generateCSVBytes(List<ChatMessage> messages) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try (PrintWriter writer = new PrintWriter(
                new OutputStreamWriter(outputStream, StandardCharsets.UTF_8))) {

            // Write BOM for Excel compatibility
            outputStream.write(0xEF);
            outputStream.write(0xBB);
            outputStream.write(0xBF);

            writer.println(CSV_HEADER);

            SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

            for (ChatMessage msg : messages) {
                String line = buildCSVLine(msg, dateFormat);
                writer.println(line);
            }

            writer.flush();
            logger.debug("CSV generation complete: {} bytes", outputStream.size());

        } catch (Exception e) {
            logger.error("Error generating CSV export", e);
            return new byte[0];
        }

        return outputStream.toByteArray();
    }

    /**
     * Build a single CSV line from a chat message, properly escaping special characters.
     *
     * @param msg        the chat message
     * @param dateFormat the date formatter to use
     * @return formatted CSV line string
     */
    private String buildCSVLine(ChatMessage msg, SimpleDateFormat dateFormat) {
        StringBuilder sb = new StringBuilder();

        sb.append(msg.getId() != null ? msg.getId() : "");
        sb.append(",");
        sb.append(escapeCSV(msg.getChatId()));
        sb.append(",");
        sb.append(escapeCSV(msg.getSenderName()));
        sb.append(",");
        sb.append(escapeCSV(msg.getRecipientName()));
        sb.append(",");
        sb.append(escapeCSV(msg.getContent()));
        sb.append(",");
        sb.append(msg.getTimestamp() != null ? dateFormat.format(msg.getTimestamp()) : "");
        sb.append(",");
        sb.append(msg.getStatus() != null ? msg.getStatus().name() : "");

        return sb.toString();
    }

    /**
     * Escape a string value for safe CSV inclusion.
     * Wraps in double quotes if the value contains commas, quotes, or newlines.
     *
     * @param value the string to escape
     * @return escaped CSV-safe string
     */
    private String escapeCSV(String value) {
        if (value == null) {
            return "";
        }
        if (value.contains(",") || value.contains("\"") || value.contains("\n")) {
            return "\"" + value.replace("\"", "\"\"") + "\"";
        }
        return value;
    }
}
