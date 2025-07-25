package com.example.demo;

import java.util.List;

public record SettingsExercicio(String idExercicio, String enunnciado, Integer dificuldade, Integer tipo, List<String> alternativas, List<String> gabarito) { }
