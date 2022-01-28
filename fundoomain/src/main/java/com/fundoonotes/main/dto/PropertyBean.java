package com.fundoonotes.main.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@ConfigurationProperties("fundoo-notes")
public class PropertyBean {
    private String signupURL;
    private String loginURL;
    private String deleteUserByIdURL;
    private String addNoteURL;
    private String deleteNoteURL;
    private String allLabelURL;
    private String getallNoteURL;
    private String deleteLAbelURL;
}
