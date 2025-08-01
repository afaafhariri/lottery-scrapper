package com.lotteryscrapper.server.scrapper;

import jakarta.persistence.*;

@Entity
@Table(name = "lottery_results")
public class LotteryResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lotteryName;
    private String drawDate;  // Use String or LocalDate depending on input
    private String letter;
    private int number1;
    private int number2;
    private int number3;
    private int number4;

    // ✅ Add getters, setters, and constructors
}