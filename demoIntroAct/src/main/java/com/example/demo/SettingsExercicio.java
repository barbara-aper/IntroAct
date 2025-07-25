package com.example.demo;

import java.util.List;

public record SettingsExercicio(String id, String enunnciado, Integer dificuldade, Integer tipo, List<String> alternativas, List<String> gabarito) { }
