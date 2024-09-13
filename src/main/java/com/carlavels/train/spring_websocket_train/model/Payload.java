package com.carlavels.train.spring_websocket_train.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payload {
    
    private String caseId;
    private String message;
}
