package com.prova0911.prova.selenium;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;


public class test {

    private WebDriver nav;

    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.operadriver().setup();
    }

    @BeforeEach
    void setUp() {
        nav = new ChromeDriver();
    }

    @Test
    void criaUmNovo() {
        nav.get("http://localhost:3000");
        nav.findElement(By.name("botao")).click();
        nav.findElement(By.name("nome")).sendKeys("Pedro vida loka");
        nav.findElement(By.name("email")).sendKeys("teu_pai_aquele_putao@mail.com");
        nav.findElement(By.name("number")).sendKeys("666666666");
        nav.findElement(By.name("botao2")).click();

    }
}

