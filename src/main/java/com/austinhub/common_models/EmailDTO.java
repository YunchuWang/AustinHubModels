package com.austinhub.common_models;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.mail.SimpleMailMessage;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmailDTO {

    private String from;

    private String replyTo;

    private List<String> to;

    private List<String> cc;

    private List<String> bcc;

    private Date sentDate;

    private String subject;

    private String text;

    public SimpleMailMessage toMailMessage() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setReplyTo(replyTo);
        simpleMailMessage.setTo(to == null? null : to.toArray(new String[to.size()]));
        simpleMailMessage.setCc(cc == null? null : cc.toArray(new String[cc.size()]));
        simpleMailMessage.setBcc(bcc == null? null : bcc.toArray(new String[bcc.size()]));
        simpleMailMessage.setSentDate(sentDate);
        simpleMailMessage.setText(text);

        return simpleMailMessage;
    }

    public static EmailDTO from(SimpleMailMessage simpleMailMessage) {
        System.out.println("Simple message");
        System.out.println(simpleMailMessage.toString());
        EmailDTO emailDTO = new EmailDTO();
        if (simpleMailMessage.getFrom() != null) {
            emailDTO.setFrom(simpleMailMessage.getFrom());
        }
        if (simpleMailMessage.getCc() != null) {
            emailDTO.setCc(Arrays.asList(simpleMailMessage.getCc()));
        }
        if (simpleMailMessage.getBcc() != null) {
            emailDTO.setBcc(Arrays.asList(simpleMailMessage.getBcc()));
        }
        if (simpleMailMessage.getTo() != null) {
            emailDTO.setTo(Arrays.asList(simpleMailMessage.getTo()));
        }
        if (simpleMailMessage.getReplyTo() != null) {
            emailDTO.setReplyTo(simpleMailMessage.getReplyTo());
        }
        if (simpleMailMessage.getSubject() != null) {
            emailDTO.setSubject(simpleMailMessage.getSubject());
        }
        if (simpleMailMessage.getText() != null) {
            emailDTO.setText(simpleMailMessage.getText());
        }

        return emailDTO;
    }
}
