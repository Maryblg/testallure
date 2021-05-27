package com.easyqa.qa.pages.util;

import io.qameta.allure.Step;

public class CardData {
    private String cardName;
    private String cardDescription;
    private String cardPriority;

    public CardData(String cardName, String cardDescription, String cardPriority) {
        this.cardName = cardName;
        this.cardDescription = cardDescription;
        this.cardPriority = cardPriority;
    }

    @Step
    public String getCardName() {
        return this.cardName;
    }

    @Step
    public String getCardDescription() {
        return this.cardDescription;
    }

    @Step
    public String getCardPriority() {
        return this.cardPriority;
    }
}

